package examples.teamboard.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SecureUtil {
    
    public static String sha256Encoding(String str) {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedBytes = digest.digest(str.getBytes());
    
        return DatatypeConverter.printHexBinary(encodedBytes).toLowerCase();
    }
    
    
    private SecureUtil() {}
    
}
