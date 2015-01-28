import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMACSHA1 {

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    /*
     * չʾ��һ������ָ���㷨��Կ�Ĺ��� ��ʼ��HMAC��Կ
     * @return
     * @throws Exception public static String initMacKey() throws Exception {
     * //�õ�һ�� ָ���㷨��Կ����Կ������ KeyGenerator KeyGenerator keyGenerator
     * =KeyGenerator.getInstance(MAC_NAME); //����һ����Կ SecretKey secretKey
     * =keyGenerator.generateKey(); return null; }
     */

    /**
     * ʹ�� HMAC-SHA1 ǩ�������Զ�encryptText����ǩ��
     * 
     * @param encryptText ��ǩ�����ַ���
     * @param encryptKey ��Կ
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception
    {
        byte[] data = encryptKey.getBytes(ENCODING);
        // ���ݸ������ֽ����鹹��һ����Կ,�ڶ�����ָ��һ����Կ�㷨������
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        // ����һ��ָ�� Mac �㷨 �� Mac ����
        Mac mac = Mac.getInstance(MAC_NAME);
        // �ø�����Կ��ʼ�� Mac ����
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(ENCODING);
        // ��� Mac ����
        return mac.doFinal(text);
    }


}
