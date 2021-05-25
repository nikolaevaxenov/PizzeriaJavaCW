package pizzeria.main.Classes;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class MultiId implements Serializable {

    private Long cartUid;

    private Long pizzaUid;
}
