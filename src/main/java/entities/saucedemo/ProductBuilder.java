package entities.saucedemo;

public class ProductBuilder {
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductBuilder{" +
                "product='" + product + '\'' +
                '}';
    }

    public static class Builder {
        private final ProductBuilder productBuilder;

        public Builder withProduct(String product) {
            productBuilder.product= product;
            return this;
        }

        public Builder() {
            this.productBuilder = new ProductBuilder();
        }

        public ProductBuilder build() {
            return productBuilder;
        }
    }
}
