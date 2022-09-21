package co.com.perfumeszorrillo.tienda.catalogo.app.repository;

import co.com.perfumeszorrillo.tienda.catalogo.app.models.User;
import co.com.perfumeszorrillo.tienda.catalogo.app.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }
    public User findById(Integer id){
        return repository.findById(id).orElse(null);
    }
    public User save(User user) {
        return repository.save(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    public List<User> findByEmail(String email){
        return repository.findAllByEmail(email);
    }
}
