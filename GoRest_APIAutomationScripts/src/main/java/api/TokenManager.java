package api;

public class TokenManager {

    private final static String bearerToken = "dec93875a5c12ad6b1af62c3c43a4539ab689eb67761a7f561f7ef0a1fc5c838";

    public synchronized static String getBearerToken(){
        return bearerToken;
    }

}
