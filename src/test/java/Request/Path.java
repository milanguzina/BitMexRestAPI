package Request;

public enum Path {

    GetUser("/api/v1/user"),
    GetInstrument("/api/v1/instrument"),
    GetWalletAssets("api/v1/wallet/assets"),
    GetWalletNetwork("api/v1/wallet/networks"),
    GetOrder("/api/v1/order"),
    GetUserEvent("/api/v1/userEvent"),

    GetOrderBook("/api/v1/orderBook/L2"),
    GetPorlSnapshots("/api/v1/porl/snapshots"),
    GetPorlNonce("/api/v1/porl/nonce");


    private String resource;

    Path(String resource){
        this.resource = resource;
    }

    public  String getResource(){
        return resource;
    }


}
