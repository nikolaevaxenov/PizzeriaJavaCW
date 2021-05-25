package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
public class OrderList implements Serializable {
    //Класс списка заказов
    @EmbeddedId
    private OrderListMultiId orderlistMultiid;

    private Long count;

    @MapsId("ordersUid")
    @ManyToOne
    @JoinColumn(name = "ORDERS_UID")
    private Orders orders;

    @MapsId("pizzaUid")
    @ManyToOne
    @JoinColumn(name = "PIZZA_UID")
    private Pizza pizza;

    @Builder
    public OrderList(OrderListMultiId orderlistMultiid, Long count, Orders orders, Pizza pizza) {
        this.orderlistMultiid = orderlistMultiid;
        this.count = count;
        this.orders = orders;
        this.pizza = pizza;
    }
}