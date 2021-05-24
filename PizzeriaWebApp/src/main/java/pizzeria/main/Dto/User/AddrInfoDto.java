package pizzeria.main.Dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Address;
import pizzeria.main.Classes.Users;

@Getter
@Setter
@NoArgsConstructor
public class AddrInfoDto {
    private Long uid;
    private String basic_addr;
    private String detail_addr;
    private Long shipping_num;
    private Users users;

    public Address toEntity(){
        return Address.builder().uid(uid).basicAddr(basic_addr).shippingNum(shipping_num).users(users).build();
    }
}