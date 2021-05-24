package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Address {
    //Класс Адреса
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    private Long shippingNum;

    private String basicAddr;

    @Builder
    public Address(Long uid, Users users, Long shippingNum, String basicAddr){
        this.uid = uid;
        this.users = users;
        this.shippingNum = shippingNum;
        this.basicAddr = basicAddr;
    }
}
