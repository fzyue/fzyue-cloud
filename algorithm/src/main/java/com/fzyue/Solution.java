package com.fzyue;

import java.util.*;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
class Solution {
    static Map<String, String> map = new HashMap<String, String>();
    static {
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
    }
    public boolean isValid(String str) {
        List<String> fuhaoList = new ArrayList<>();
        char[] arr = str.toCharArray();
        String s = null;
        for (char c : arr) {
             s = String.valueOf(c);
            if (map.containsKey(s)) {
                fuhaoList.add(s);
            } else if (map.containsValue(s)) {
                if (fuhaoList.isEmpty()) {
                    return false;
                }
                // 出现结束符号
                if (!s.equals(map.get(fuhaoList.get(fuhaoList.size() - 1)))) {
                    // 找不到上一个开始符号对应
                    return false;
                } else {
                    if (!fuhaoList.isEmpty()) {
                        fuhaoList.remove(fuhaoList.size() - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return fuhaoList.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid2("[([]])"));
    }


    /**
     * 方法2：栈
     */
    static Map<Character, Character> fuhaoMap = new HashMap<>();
    static {
        fuhaoMap.put(')', '(');
        fuhaoMap.put(']', '[');
        fuhaoMap.put('}', '{');
    }

    public static boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (fuhaoMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != fuhaoMap.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                if (fuhaoMap.containsValue(ch)) {
                    stack.push(ch);
                }
            }

        }
        return stack.isEmpty();

    }


}
