package pizzeria.main.Dto.CartList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Cart;
import pizzeria.main.Classes.CartList;
import pizzeria.main.Classes.MultiId;
import pizzeria.main.Classes.Pizza;


@Getter
@Setter
@NoArgsConstructor
public class CartListAddDto {
    private MultiId multiId;
    private Long pizzaCount;
    private Cart cart;
    private Pizza pizza;

    public CartList toEntity(){
        return CartList.builder()
                .multiId(multiId)
                .pizzaCount(pizzaCount)
                .pizza(pizza)
                .cart(cart)
                .build();
    }
}
