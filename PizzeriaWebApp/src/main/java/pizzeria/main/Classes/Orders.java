package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Orders {
    //Класс заказов
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    private String date;

    private Long amount;

    private String cardId;

    private String cardType;

    private String cardDate;

    private Long shippingNum;

    private String basicaddr;

    @OneToMany(mappedBy = "orders", orphanRemoval = true)
    private List<OrderList> orderlists;


    @Builder
    public Orders(Long uid, Users users, String date, Long amount, String cardId, String cardType, String cardDate, Long shippingNum, String basicaddr, List<OrderList> orderlists){
        this.uid= uid;
        this.users = users;
        this.date = date;
        this.amount = amount;
        this.cardId = cardId;
        this.cardType = cardType;
        this.cardDate= cardDate;
        this.shippingNum = shippingNum;
        this.basicaddr = basicaddr;
        this.orderlists = orderlists;
    }

}
