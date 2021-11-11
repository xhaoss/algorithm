package 算24;

import java.util.Scanner;

/*

 */
public class Main {
    public static void main(String[] args) {
        double[] a = new double[5];
        Scanner scanner = new Scanner(System.in);
        Cla cla = new Cla();
        while(true){
            for(int i = 0;i<4;i++){
                a[i] = scanner.nextInt();
            }
            if(cla.isZero(a[0])) break;
            if (cla.count24(a,4)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

class Cla{
    public boolean isZero(double x){
        final double eps = 1e-6;
        if(Math.abs(x)<eps){
            return true;
        }else return false;
    }
    public boolean count24(double[]a,int n){
        //用数组中的24个数，计算24
        if(n==1){
            if(isZero(a[0] - 24))
                return true;
            else
                return false;
        }
        //因为a数组保存原始数组，所以其值不能发生改变
        double[] b = new double[5];
        //首先需要选两个数
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                //枚举所有的可能性，因为需要两个数字，所以i最多到n-2
                int m = 0;
                for(int k = 0; k < n;k++)
                    if(k!=i &&k!=j)
                        b[m++] = a[k];
                        //将剩下的数再放回数组中
                //接下来尝试所有的可能性
                //+
                b[m] = a[i] + a[j];
                if(count24(b,m+1))
                    return true;
                //-
                //将b[m]这个位置覆盖修改
                b[m] = a[i] - a[j];
                if(count24(b,m+1))
                    return true;

                b[m] = a[j] - a[i];
                if (count24(b,m+1))
                    return true;

                //*
                b[m] = a[i] * a[j];
                if (count24(b,m+1))
                    return true;
                ///
                if(a[j]!=0){
                    b[m] = a[i]/a[j];
                    if (count24(b,m+1))
                        return true;
                }

                if(a[i]!=0){
                    b[m] = a[j]/a[i];
                    if (count24(b,m+1))
                        return true;
                }
            }
        }
    return false;
    }
}