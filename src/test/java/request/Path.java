package request;

public enum Path {

    GET_USER("/api/v1/user"),
    GET_INSTRUMENT("/api/v1/instrument"),
    GET_WALLET_ASSETS("api/v1/wallet/assets"),
    GET_WALLET_NETWORK("api/v1/wallet/networks"),
    GET_ORDER("/api/v1/order"),
    GET_USER_EVENT("/api/v1/userEvent"),
    GET_ORDER_BOOK("/api/v1/orderBook/L2"),
    GET_PORL_SNAPSHOTS("/api/v1/porl/snapshots"),
    GET_PORL_NONCE("/api/v1/porl/nonce");


    private String resource;

    Path(String resource){
        this.resource = resource;
    }

    public  String getResource(){
        return resource;
    }


}
