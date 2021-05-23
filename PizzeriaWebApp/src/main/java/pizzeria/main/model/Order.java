package pizzeria.main.model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzaList = new ArrayList<>() {{
        add(new Pizza(1, 26, 1, 399, 399, false));
        add(new Pizza(1, 30, 1, 549, 549, false));
        add(new Pizza(1, 40, 1, 769, 769, false));
        add(new Pizza(2, 26, 1, 499, 499, false));
        add(new Pizza(2, 30, 1, 649, 649, false));
        add(new Pizza(2, 40, 1, 869, 869, false));
        add(new Pizza(3, 26, 1, 519, 519, false));
        add(new Pizza(3, 30, 1, 759, 759, false));
        add(new Pizza(3, 40, 1, 999, 999, false));
        add(new Pizza(4, 26, 1, 489, 489, false));
        add(new Pizza(4, 30, 1, 649, 649, false));
        add(new Pizza(4, 40, 1, 869, 869, false));
        add(new Pizza(5, 26, 1, 529, 529, false));
        add(new Pizza(5, 30, 1, 699, 699, false));
        add(new Pizza(5, 40, 1, 989, 989, false));
        add(new Pizza(6, 26, 1, 349, 349, false));
        add(new Pizza(6, 30, 1, 439, 439, false));
        add(new Pizza(6, 40, 1, 579, 579, false));
        add(new Pizza(7, 26, 1, 479, 479, false));
        add(new Pizza(7, 30, 1, 659, 659, false));
        add(new Pizza(7, 40, 1, 899, 899, false));
        add(new Pizza(8, 26, 1, 499, 499, false));
        add(new Pizza(8, 30, 1, 569, 569, false));
        add(new Pizza(8, 40, 1, 789, 789, false));
    }};

    public Order() {
    }

    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(ArrayList<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
