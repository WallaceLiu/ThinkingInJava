package apacheCommonsUtils.codecDemo;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/21
 */
public class CodecDemo {
    public static void main(String[] args) throws DecoderException {
        byte[] binaryData = "www.bdata-cap.com".getBytes();
        // Base64
        String encodeBase64String = Base64.encodeBase64String(binaryData);
        byte[] decodeBase64 = Base64.decodeBase64(encodeBase64String);
        System.out.println(encodeBase64String);
        System.out.println(decodeBase64);

        // MD5
        String md5Hex = DigestUtils.md5Hex("www.bdata-cap.com");
        System.out.println(md5Hex);
        // URL

        byte[] decodeUrl=URLCodec.decodeUrl(binaryData);
        System.out.println(decodeUrl);
//        decodeUrl=URLCodec.encodeUrl(BitSet urlsafe, binaryData);
//        System.out.println(decodeUrl);
    }
}
