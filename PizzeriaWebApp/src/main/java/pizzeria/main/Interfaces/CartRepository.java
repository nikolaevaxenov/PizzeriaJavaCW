package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUsers_Id(String id);
}