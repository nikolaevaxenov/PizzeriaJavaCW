package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.CartList;
import pizzeria.main.Classes.MultiId;

import java.util.List;

public interface CartListRepository extends JpaRepository<CartList, MultiId> {
    List<CartList> findAllByCart_Uid(Long uid);
}

