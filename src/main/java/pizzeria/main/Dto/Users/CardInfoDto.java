package pizzeria.main.Dto.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pizzeria.main.Classes.Card;
import pizzeria.main.Classes.Users;

@Getter
@Setter
@NoArgsConstructor
public class CardInfoDto {
    private String id;
    private Users users;
    private String datetime;
    private String type;

    @Builder
    public CardInfoDto(String id, Users users, String datetime, String type){
        this.id = id;
        this.users = users;
        this.datetime = datetime;
        this.type =type;
    }

    public Card toEntity(){
        return Card.builder().id(id).users(users).datetime(datetime).type(type).build();
    }
}
