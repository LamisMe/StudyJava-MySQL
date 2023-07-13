package ss8_clean_code.mvc.model;

public class Product {
    private String idProduct;
    private String nameProduct;
    private long price;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, long price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String infoToCSV() {
        return this.idProduct + "," + this.nameProduct + "," + this.price;
    }

    @Override
    public String toString() {
        return "Sản phẩm: " +
                "Mã sản phẩm: '" + idProduct + '\'' +
                ", Tên sản phẩm: '" + nameProduct + '\'' +
                ", Giá: " + price;
    }
}
