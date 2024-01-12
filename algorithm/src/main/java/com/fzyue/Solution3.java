package com.fzyue;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
//        System.out.println(isValid(""));
        System.out.println(isValid("([)]"));
    }
        static Map<Character, Character> fuhaoMap = new HashMap<Character, Character>();
        static {
            fuhaoMap.put(')','(');
            fuhaoMap.put('}','{');
            fuhaoMap.put('}','{');
        }
        public static boolean isValid(String s) {
            List zuocefh = new ArrayList<Character>();
            if (null == s) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            char tmp;
            for (int i = 0; i<s.length(); i++) {
                tmp = s.charAt(i);
                if (fuhaoMap.containsValue(tmp)) {
                    // 存在左侧符号
                    zuocefh.add(tmp);
                } else if (null != fuhaoMap.get(tmp)) {
                    if (zuocefh.isEmpty()) {
                        return false;
                    }
                    // 存在右侧结束符号
                    if (fuhaoMap.get(tmp) == zuocefh.get(zuocefh.size() - 1)) {
                        // 相同， 符号要求
                        zuocefh.remove(zuocefh.size() - 1);
                    } else{
                        return false;
                    }
                }
            }
            return zuocefh.isEmpty() ? true : false;
        }
}
