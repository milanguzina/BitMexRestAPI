package Request;

public enum HTTPRequest {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");


    private String requestType;

    HTTPRequest(String requestType){
        this.requestType = requestType;
    }

    public  String getRequestType(){
        return requestType;
    }


}
