package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findAllByUsers_Id(String userid);
}
