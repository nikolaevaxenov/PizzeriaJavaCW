package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.Pizza;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByPizzaNameIgnore(String name);
}
