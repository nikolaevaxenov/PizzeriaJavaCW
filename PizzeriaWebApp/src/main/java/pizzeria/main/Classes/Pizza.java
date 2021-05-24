package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Pizza {
    //Класс Пиццы
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PIZZA_UID")
    private Long uid;

    private String pizzaName;

    private Long pizzaCount;

    private Long pizzaPrice;

    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private List<Orderlist> orderlists;

    @OneToMany(mappedBy = "pizza", cascade = {CascadeType.REMOVE})
    private List<Cartlist> cartlists;


    public void updateCount(PizzaUpdateCountDto pizzaUpdateCountDto) {
        this.pizzaCount = pizzaUpdateCountDto.getPizzaCount();
    }

    @Builder
    public Pizza(Long uid, String pizzaName, Long pizzaCount, Long pizzaPrice, List<Cartlist> cartlists, List<Orderlist> orderlists) {
        this.uid = uid;
        this.pizzaName = pizzaName;
        this.pizzaCount = pizzaCount;
        this.pizzaPrice = pizzaPrice;
        this.cartlists = cartlists;
        this.orderlists = orderlists;
    }

    public void updatePizza(PizzaUpdateDto pizzaUpdateDto) {
        this.pizzaName = pizzaUpdateDto.getPizzaName();
        this.pizzaCount = pizzaUpdateDto.getPizzaCount();
        this.pizzaPrice = pizzaUpdateDto.getPizzaPrice();
    }
}
