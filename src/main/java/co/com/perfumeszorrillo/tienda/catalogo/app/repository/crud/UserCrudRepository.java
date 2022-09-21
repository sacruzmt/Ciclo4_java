package co.com.perfumeszorrillo.tienda.catalogo.app.repository.crud;

import co.com.perfumeszorrillo.tienda.catalogo.app.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    public List<User> findAllByEmail(String email);
}
