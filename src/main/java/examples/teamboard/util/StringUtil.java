package examples.teamboard.util;

import java.util.stream.IntStream;

public final class StringUtil {
    
    
    public static boolean isEmtpy(String str) {
        
        return str == null || str.isEmpty();
    }
    
    public static boolean isNotEmpty(String str) {
        return !isEmtpy(str);
    }
    
    public static boolean isBlank(String str) {
        
        if(str == null) return true;
        
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if(!Character.isWhitespace(ch)) return false;
        }
        return true;
    }
    
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    
}
