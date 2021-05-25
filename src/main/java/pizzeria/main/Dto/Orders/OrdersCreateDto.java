package pizzeria.main.Dto.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Orders;
import pizzeria.main.Classes.Users;

@Getter
@Setter
@NoArgsConstructor
public class OrdersCreateDto {
    private Users users;

    private String date;

    private Long amount;

    private String cardId;

    private String cardType;

    private String cardDate;

    private Long shippingNum;

    private String basicaddr;

    public Orders toEntity(){
        return Orders.builder()
                .users(users)
                .date(date)
                .amount(amount)
                .cardId(cardId)
                .cardType(cardType)
                .cardDate(cardDate)
                .shippingNum(shippingNum)
                .basicaddr(basicaddr)
                .build();
    }
}
