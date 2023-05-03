package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import java.util.Properties;

public class BaseHelper {


    public static final ObjectMapper mapper = new ObjectMapper();


    public static String expireGenerator() {  //generates APIKey expiration - instant Time and Date with a delay of 5 minutes
        Instant expiresInst = Instant.now().plus(5, ChronoUnit.MINUTES);
        String expires = String.valueOf(expiresInst.getEpochSecond());
        return expires;
    }

    public static String ApiSignatureGenerator(String verb, String resource,String data) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        String expires = expireGenerator();
        String apiSecret = BaseHelper.getGlobalValue("APISecret");

        String signature = verb + resource + expires + data;

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        byte[] signature_bytes = sha256_HMAC.doFinal(signature.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(signature_bytes);
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static String getJsonPath(Response response, String key){
        String resp  = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }


}

