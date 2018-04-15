package examples.teamboard.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void testIsEmpty() {
        String str = "";
        
        assertTrue(StringUtil.isEmtpy(str));
        
        str = "   ";
        assertFalse(StringUtil.isEmtpy(str));
    }
    
    @Test
    public void testIsBlank() {
        String str = "";
    
        assertTrue(StringUtil.isBlank(str));
    
        str = "   ";
        assertTrue(StringUtil.isBlank(str));
    }

}
