package pizzeria.main.Dto.Pizza;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Pizza;

@Getter
@Setter
@NoArgsConstructor
public class PizzaDeleteDto {
    private Long uid;

    private String pizzaName;

    private Long pizzaCount;

    private Long pizzaPrice;

    public Pizza toEntity(){
        return Pizza.builder().uid(uid).pizzaName(pizzaName).pizzaCount(pizzaCount).pizzaPrice(pizzaPrice).build();
    }
}
