package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
public class CartList implements Serializable {
    //Класс списка корзины
    @EmbeddedId
    private MultiId multiId;

    private Long pizzaCount;

    @MapsId("cartUid")
    @ManyToOne
    @JoinColumn(name = "CART_UID")
    private Cart cart;

    @MapsId("bookUid")
    @ManyToOne
    @JoinColumn(name = "BOOK_UID")
    private Pizza pizza;

    @Builder
    public CartList(MultiId multiId, Long pizzaCount, Cart cart, Pizza pizza) {
        this.multiId = multiId;
        this.pizzaCount = pizzaCount;
        this.pizza = pizza;
        this.cart = cart;
    }
}
