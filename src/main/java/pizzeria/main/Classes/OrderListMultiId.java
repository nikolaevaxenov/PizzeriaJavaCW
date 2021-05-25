package pizzeria.main.Classes;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class OrderListMultiId implements Serializable {
    private Long ordersUid;

    private Long pizzaUid;
}
