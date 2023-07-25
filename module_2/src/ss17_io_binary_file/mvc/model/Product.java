package ss17_io_binary_file.mvc.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String codeProduct;
    private String nameProduct;
    private long price;
    private String manufacturer;
    private String describe;

    public Product() {
    }

    public Product(String codeProduct, String nameProduct, long price, String manufacturer, String describe) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.manufacturer = manufacturer;
        this.describe = describe;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(codeProduct, product.codeProduct) && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProduct, nameProduct);
    }

    @Override
    public String toString() {
        return "Sản phẩm: " +
                "Mã sản phẩm: " + codeProduct +
                ", Tên sản phẩm: " + nameProduct +
                ", Giá: " + price +
                ", Hãng sản xuất: " + manufacturer +
                ", Mô tả: " + describe;
    }
}
