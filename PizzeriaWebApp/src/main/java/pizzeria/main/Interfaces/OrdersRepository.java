package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAllByOrderByUidDesc();
    List<Orders> findAllByUsers_Id(String userId);
}
