package pizzeria.main.Dto.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Users;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignInDto {
    private String id;
    private String pw;

    @Builder
    public UsersSignInDto(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public Users toEntity(){
        return Users.builder().id(id).pw(pw).build();
    }
}
