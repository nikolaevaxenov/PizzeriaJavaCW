package pizzeria.main.interfaces;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pizzeria.main.model.Order;

import java.util.List;

@Repository("OrderRepository")
public interface OrderRepository extends JpaRepository<Order,Long> {
    @NotNull
    List<Order> findAll();
}
