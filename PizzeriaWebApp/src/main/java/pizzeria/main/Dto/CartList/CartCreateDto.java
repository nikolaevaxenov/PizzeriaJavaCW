package pizzeria.main.Dto.CartList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Cart;
import pizzeria.main.Classes.Users;

@Getter
@Setter
@NoArgsConstructor
public class CartCreateDto {
    private Users users;
    private String createtime;
    private String modifytime;

    public Cart toEntity(){
        return Cart.builder()
                .users(users)
                .createtime(createtime)
                .modifytime(modifytime)
                .build();
    }
}
