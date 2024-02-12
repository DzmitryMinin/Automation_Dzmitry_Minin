package entities.saucedemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class ProductBuilder {
    private String product;
}