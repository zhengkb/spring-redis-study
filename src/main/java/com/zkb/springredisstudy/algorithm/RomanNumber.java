package com.zkb.springredisstudy.algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }


    public static int romanToInt(String s) {
        //"MCDLXXVI" 1100+ 550 +20+ 6
        Map<Character, Integer> codeAndNUm = new HashMap<>();
        codeAndNUm.put('I', 1);
        codeAndNUm.put('V', 5);
        codeAndNUm.put('X', 10);
        codeAndNUm.put('L', 50);
        codeAndNUm.put('C', 100);
        codeAndNUm.put('D', 500);
        codeAndNUm.put('M', 1000);
        //MCMXCIV 1000 100 1000 10 100 1 5 1000 900 90 4
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer value1 = codeAndNUm.get(s.charAt(i));
            Integer value2 = codeAndNUm.get(s.charAt(i + 1));
            if (value1 < value2) {
                sum -= value1;
                continue;
            }
            sum += value1;
        }
        return sum + codeAndNUm.get(s.charAt(s.length() - 1));
    }
}
