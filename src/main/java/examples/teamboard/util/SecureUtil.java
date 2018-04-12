package examples.teamboard.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SecureUtil {
    
    public static String sha256Encoding(String str) throws NoSuchAlgorithmException {
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedBytes = digest.digest(str.getBytes());
    
        return DatatypeConverter.printHexBinary(encodedBytes).toLowerCase();
    }
    
    
    private SecureUtil() {}
    
}
