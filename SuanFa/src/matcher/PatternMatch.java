package matcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatternMatch {
    public static void main(String[] args) {
        System.out.println(match("abab", "dog cat dog cat"));
        System.out.println(match("aaaa", "dog dog dog cat"));
        System.out.println(match("aaab", "dog dog dog cat"));
        System.out.println(match("aabb", "dog cat cat cat"));
    }

    private static boolean match(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0)
            return false;

        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length)
            return false;

        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < strArray.length; ++i) {
            Character ch = pattern.charAt(i);
            String v = strArray[i];
            String s = map.get(ch);
            if (s != null) {
                if (!s.equals(v))
                    return false;
            } else {
                if (!set.add(v))
                    return false;

                map.put(ch, v);
            }
        }

        return true;
    }
}
