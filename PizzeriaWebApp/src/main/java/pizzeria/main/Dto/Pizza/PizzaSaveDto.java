package pizzeria.main.Dto.Pizza;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Pizza;

@Getter
@Setter
@NoArgsConstructor
public class PizzaSaveDto {

    private String pizzaName;

    private Long pizzaCount;

    private Long pizzaPrice;

    @Builder
    public PizzaSaveDto(String pizzaName, Long pizzaCount, Long pizzaPrice){
        this.pizzaName = pizzaName;
        this.pizzaCount = pizzaCount;
        this.pizzaPrice = pizzaPrice;
    }

    public Pizza toEntity(){
        return Pizza.builder().pizzaName(pizzaName).pizzaCount(pizzaCount).pizzaPrice(pizzaPrice).build();
    }
}
