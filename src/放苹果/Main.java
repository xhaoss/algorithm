package 放苹果;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Scanner scanner = new Scanner(System.in);
        for (int num = scanner.nextInt();num > 0;num--){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int result = apple.PutApple(n,m);
            System.out.println(result);
        }
    }
}
class Apple{
    public int PutApple(int n, int m){
        if(m > n ) return PutApple(n, n);
        if(n == 0) return 1;
        if(m == 0) return 0;
        return PutApple(n, m-1) + PutApple(n-m,m);
    }
}
