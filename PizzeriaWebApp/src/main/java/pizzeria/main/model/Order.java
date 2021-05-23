package pizzeria.main.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private ArrayList<Pizza> pizzaList = new ArrayList<>() {{
        add(new Pizza(1, 26, 1, 399, false));
        add(new Pizza(1, 30, 1, 549, false));
        add(new Pizza(1, 40, 1, 769, false));
        add(new Pizza(2, 26, 1, 499, false));
        add(new Pizza(2, 30, 1, 649, false));
        add(new Pizza(2, 40, 1, 869, false));
        add(new Pizza(3, 26, 1, 519, false));
        add(new Pizza(3, 30, 1, 759, false));
        add(new Pizza(3, 40, 1, 999, false));
        add(new Pizza(4, 26, 1, 489, false));
        add(new Pizza(4, 30, 1, 649, false));
        add(new Pizza(4, 40, 1, 869, false));
        add(new Pizza(5, 26, 1, 529, false));
        add(new Pizza(5, 30, 1, 699, false));
        add(new Pizza(5, 40, 1, 989, false));
        add(new Pizza(6, 26, 1, 349, false));
        add(new Pizza(6, 30, 1, 439, false));
        add(new Pizza(6, 40, 1, 579, false));
        add(new Pizza(7, 26, 1, 479, false));
        add(new Pizza(7, 30, 1, 659, false));
        add(new Pizza(7, 40, 1, 899, false));
        add(new Pizza(8, 26, 1, 499, false));
        add(new Pizza(8, 30, 1, 569, false));
        add(new Pizza(8, 40, 1, 789, false));
    }};

    @Column(name = "first_name")
    @NotNull
    private String first_name;

    @Column(name = "last_name")
    @NotNull
    private String last_name;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phone_number")
    @NotNull
    private String phone_number;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "house_number")
    @NotNull
    private String house_number;

    @Column(name = "street_door_number")
    @NotNull
    private String street_door_number;

    @Column(name = "floor")
    @NotNull
    private String floor;

    @Column(name = "intercom_code")
    @NotNull
    private String intercom_code;

    @Column(name = "comment")
    @NotNull
    private String comment;

    public Order() {
    }

    public Order(String first_name, String last_name, String email, String phone_number, String street, String house_number, String street_door_number, String floor, String intercom_code, String comment) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.street = street;
        this.house_number = house_number;
        this.street_door_number = street_door_number;
        this.floor = floor;
        this.intercom_code = intercom_code;
        this.comment = comment;
    }

    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void choosePizza(int type, int size, int quantity) {
        for(Pizza p : pizzaList) {
            if(p.getType() == type && p.getSize() == size) {
                p.setQuantity(quantity);
                p.setChoosed(true);
            }
        }
    }

    public void unChoosePizza(int type, int size) {
        for(Pizza p : pizzaList) {
            if(p.getType() == type && p.getSize() == size)
                p.setChoosed(false);
        }
    }

    public int getTotalCost() {
        int total = 0;

        for(Pizza p : pizzaList) {
            if(p.isChoosed())
                total += p.getCost();
        }

        return total;
    }

    public String getFinalOrder() {
        StringBuilder sb = new StringBuilder();

        for(Pizza p : pizzaList) {
            if(p.isChoosed()) {
                sb.append(p.getTypeName()).append(", размер = ").append(p.getSize()).append(", кол-во = ").append(p.getQuantity()).append(".");
            }
        }

        return sb.toString();
    }
}
