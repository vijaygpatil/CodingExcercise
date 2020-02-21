package com.selfPractice.XOR;

public class CalculateComplement {
    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }

    public static int bitwiseComplement(int n) {
        int count = 0;
        int num = n;
        while(n > 0) {
            count++;
            n >>= 1;
        }

        int allbittset =(int) Math.pow(2, count) - 1;

        return num ^ allbittset;
    }
}
