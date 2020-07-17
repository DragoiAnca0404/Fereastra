package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CampText {
    PAROLA, CNP, EMAIL, TELEFON;
    public String continut;
    private String parola;
    private StringBuffer sb;

    CampText() {
        parola = "";
        sb = new StringBuffer();
    }

    public boolean verificaText(String s) {
        int o = ordinal();
        switch (o) {
            case 0:
                if (verificaParola(s)) {
                    for (int i = 0; i < s.length(); i++) {
                        sb.append('*');
                    }

                    continut = sb.toString();
                    parola = s;
                    return true;
                }
                break;
            case 1:
                if (s.length() == 13 && Pattern.matches("[0-9]+", s)) {
                    continut = s;
                    return true;
                }
                return false;

            case 2:
                if (verificaEmail(s)) {
                    continut = s;
                    return true;
                }
                return false;
            case 3:
                if (s.length() == 10 && Pattern.matches("[0-9]+", s)) {
                    continut = s;
                    return true;
                }
                return false;
        }
        return false;
    }

    private boolean verificaEmail(String s) {
        if (s.indexOf("@") != -1 && s.indexOf("@") == s.lastIndexOf("@")) {
            return true;
        }
        return false;
    }
    private boolean verificaParola(String s){
        String sablon="((?=.*[a-z])(?=.*[A-Z])(?=.*d)(?=.*[@&#$%])).{8,16}";
        Pattern p=Pattern.compile(sablon);
        Matcher m=p.matcher(s);
        return m.matches();
    }
    public String getContinut(){
        return continut;
    }
}
