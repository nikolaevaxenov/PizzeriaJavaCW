package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.OrderList;
import pizzeria.main.Classes.OrderListMultiId;

public interface OrderListRepository extends JpaRepository<OrderList, OrderListMultiId> {

}