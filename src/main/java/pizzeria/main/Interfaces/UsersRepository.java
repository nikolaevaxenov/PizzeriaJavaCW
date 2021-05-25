package pizzeria.main.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pizzeria.main.Classes.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
}
