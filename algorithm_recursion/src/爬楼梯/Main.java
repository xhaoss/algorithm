package 爬楼梯;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stairs stairs =new Stairs();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = stairs.stairNum(scanner.nextInt());
            System.out.println(num);
        }
    }
}
class Stairs{
    public int stairNum(int n){
        if(n == 1) return 1;
        else if(n == 2) return 2;
        return stairNum(n-1) + stairNum(n-2);
    }
}
