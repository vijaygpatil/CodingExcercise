package com.selfPractice;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();

        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1);
        reverseStack(s1);
        while(!s1.empty()) {
            System.out.println(s1.pop());
        }
    }

    private static void reverseStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        while(!s2.empty()) {
            s1.push(s2.pop());
            int temp = s2.pop();
            int i = 0;
            while(!s1.empty()) {
                s2.push(s1.pop());
                i++;
            }
            s1.push(temp);
            while(i > 0) {
                s1.push(s2.pop());
                i--;
            }
        }
    }
}
