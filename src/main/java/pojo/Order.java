package pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {

    private String symbol;

    private int orderQty;

    private int price;

    private String ordType;

}
