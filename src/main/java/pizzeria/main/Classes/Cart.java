package pizzeria.main.Classes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart {
    //Класс корзины
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    private String createtime;

    private String modifytime;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.REMOVE})
    private List<CartList> cartlists;

    @Builder
    public Cart(Long uid, Users users, String createtime, String modifytime, List<CartList> cartlists){
        this.uid = uid;
        this.users = users;
        this.createtime = createtime;
        this.modifytime = modifytime;
        this.cartlists = cartlists;
    }

    public void updateModifytime(String modifytime){
        this.modifytime = modifytime;
    }
}