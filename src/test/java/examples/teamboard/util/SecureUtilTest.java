package examples.teamboard.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class SecureUtilTest {
    
    @Test
    public void sha256EncodingTest() throws NoSuchAlgorithmException {
        String str = "testString";
    
        String encoding1 = SecureUtil.sha256Encoding(str);
        String encoding2 = SecureUtil.sha256Encoding(str);
    
        assertEquals(encoding1, encoding2);
    }
}
