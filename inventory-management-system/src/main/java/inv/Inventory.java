package inv;

public class Inventory {
    private int id;
    private String name;
    private int category_id;
    private int price;
    private String description;


    private int count;



    public Inventory(int id, String name, int category_id, int price, String description, int count){
        this.id=id;
        this.name=name;
        this.description=description;
        this.count=count;
        this.category_id=category_id;
        this.price=price;

    }

    public int getCategory_id() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + " " +
                ", category_id=" + category_id +
                ", price=" + price +
                ", description='" + description + " " +
                ", count=" + count +
                '}';
    }
}
