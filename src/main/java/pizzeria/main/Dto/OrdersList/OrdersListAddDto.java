package pizzeria.main.Dto.OrdersList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.OrderList;
import pizzeria.main.Classes.OrderListMultiId;
import pizzeria.main.Classes.Orders;
import pizzeria.main.Classes.Pizza;

@Getter
@Setter
@NoArgsConstructor
public class OrdersListAddDto {
    private OrderListMultiId orderlistMultiid;

    private Long  count;

    private Orders orders;

    private Pizza pizza;

    public OrderList toEntity(){
        return OrderList.builder()
                .orderlistMultiid(orderlistMultiid)
                .count(count)
                .orders(orders)
                .pizza(pizza)
                .build();
    }
}
