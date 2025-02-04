package com.example.util;

public final class CapitalizingUtil { // final 클래스는 상속을 방지)
    // UPPER_CASE 문자열 -> 그 중에서 A-Z, _ 구간 및 그 주변만 인색해서 Capitalizing 하는 메서드

    private CapitalizingUtil() {} // private 생성자는 인스턴스 생성 방지

    public static String capitalize(String str){
        char[] origin = str.toCharArray();
        char[] target = new char[origin.length];

        // 대문자 되는 조건

        //  : 이전에 띄어쓰기나 언더스코어, 이번엔 알파벳
        // 소문자 되는 조건
        //  : 이전에 띄어쓰기나 언더스코어가 아니었고, 이번에 알파벳
        // _ -> 띄어쓰기로

        // 이전에 띄어쓰기나 언더스코어 -> 이번엔 대문자 (65)
        // 이전에 띄어쓰기나 언더스코어가 아니면 -> 이번엔 소문자 (67)
        // _ -> 띄어쓰기로
        target[0] = toUpperCase(origin[0]);
        for (int i = 1; i< origin.length; i++){
            if(origin[i] == '_'){
                target[i] = ' ';
                continue;
            }
            if(origin[i - 1] == '_'){
                target[i] = toUpperCase(origin[i]);
            } else{
                target[i] = toLowerCase(origin[i]);
            }
        }
        return String.valueOf(target);
    }

    private static char toUpperCase(char ch) {
        return (char) (ch & ~0x20);
    }

    private static char toLowerCase(char ch) {
        return (char) (ch | ' ');
    }
}
