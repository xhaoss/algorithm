package 表达式求解;
/*字符串一次取一个字符的操作就是
Scanner scanner = new Scanner(System.in);
String str = scanner.next();
char c = str.charAt(0);//已经取出第一个字符
str = str.substring(1);//截取第一个及其以后的所有字符也就是删除第一个字符
*/
/*
字符串读取多位数字转换成十进制数
int result = 0;
char c = str.charAt(0);
while(Character.isDigit(c)){
    result = result * 10 + c -'0';
    str = str.substring(0);
    if(str.length == 0) break;
    char c = str.charAt(0);
    }
*/
/*
如果遇到空数组，charAt操作会失败
所以在substring之后和charat之前需要判断是否为空数组
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Expression expression = new Expression();
        int result = expression.expression_value();
        System.out.println(result);
    }
}

class Expression{
    private Scanner scanner;
    private String str;

    Expression(){
        this.scanner = new Scanner(System.in);
        this.str = scanner.next();
    }

    //要注意的是读入的一整个是表达式同时位于括号里面的同样也是表达式
    public int expression_value(){
        int result = term_value();
        boolean more = true;
        while(more){
            if(str.length() != 0){
            char op = str.charAt(0);
                if(op == '+' || op == '-'){
                    str = str.substring(1);
                    int value = term_value();
                    if(op == '+') result += value;
                    else result -= value;
                }else more = false;
            }
            else break;
        }
        return result;
    }

    public int term_value(){
        int result = factor_value();
        while(true){
            if(str.length() != 0){
                char op = str.charAt(0);
                if(op == '*' || op == '/'){
                    str = str.substring(1);
                    int value = factor_value();
                    if(op == '*') result *= value;
                    else result /= value;
                }
                else
                    break;}
            else break;
        }
        return result;
    }

    public int factor_value(){
        int result = 0;
        if(str.length()!=0){
        char op = str.charAt(0);
        if(op == '('){
            str = str.substring(1);
            result = expression_value();
            str = str.substring(1);
        }else{
            while(Character.isDigit(op)){
                result = 10 * result + op - '0';
                str = str.substring(1);
                if(str.length()==0) break;
                op = str.charAt(0);
            }
        }}
        return result;
    }
}