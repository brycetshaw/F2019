public class Supplier {
    private int id;
    private String name;
    private String address;
    private String contact;

    Supplier(int id, String name, String address, String contact){
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String toString(){
        String st = "";
        st = String.valueOf(id) + " " +  name + "\n" + address+ "\n" + contact;
        return st;
    }
}
