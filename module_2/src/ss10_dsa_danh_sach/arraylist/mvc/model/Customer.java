package ss10_dsa_danh_sach.arraylist.mvc.model;

public class Customer implements Comparable<Customer> {
    private int code;
    private String name;
    private int age;
    private String typeCustomer;
    private int id;

    public Customer() {
    }

    public Customer(int id, String name, int age, String typeCustomer) {
        this.code = id;
        this.name = name;
        this.age = age;
        this.typeCustomer = typeCustomer;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Khách hàng: " +
                " mã khách hàng : " + code +
                ", tên khách hàng : " + name +
                ", tuổi : " + age +
                ", loại khách hàng : " + typeCustomer;
    }

    @Override
    public int compareTo(Customer o) {
        int result = this.name.compareTo(o.name);
        if(result == 0){
            return this.code-o.code;
        }else {
            return result;
        }
    }
}
