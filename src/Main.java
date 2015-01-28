public class Main {
    private final static String UploadPolocy = "{\"scope\":\"semi\",\"deadline\":1735660800}";
    private final static String AccessKey = "ZV65mg8TCX-_82OiOgIHcAYNG6wR06y09HvNCgJb";
    private final static String SecretKey = "CHWYKs9w6qD3o6mtLL0KsjkKOeWF3Ocehp7YfXB0";

    public static void main(String[] args) {

        try {

            String encodedPolocy = Base64Utils.encode(UploadPolocy.getBytes())
                    .replaceAll("\\+", "-")
                    .replaceAll("/", "_");

            String HMAC_SHA1_UrlBase64Encoded = Base64Utils
                    .encode(
                            HMACSHA1.HmacSHA1Encrypt(
                                    encodedPolocy,
                                    SecretKey))
                    .replaceAll("\\+", "-")
                    .replaceAll("/", "_");
            
            
           String UploadToken = AccessKey +":"+HMAC_SHA1_UrlBase64Encoded+":"+encodedPolocy;
           
           System.out.println(UploadToken);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
