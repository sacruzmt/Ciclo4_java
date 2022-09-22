package co.com.perfumeszorrillo.tienda.catalogo.app.services;

import co.com.perfumeszorrillo.tienda.catalogo.app.models.User;
import co.com.perfumeszorrillo.tienda.catalogo.app.repository.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User getById(Integer id){
        return repository.findById(id);
    }

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public void delete(User user){
        repository.delete(user);
    }
    public User save(User user){
        if(user.getId() == null){
            return repository.save(user);
        } else{
            if(repository.findById(user.getId()) == null){
                return repository.save(user);
            } else{
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            User newUser = repository.findById(user.getId());
            if (newUser != null) {
                if (user.getName() != null) {
                    newUser.setName(user.getName());
                }
                if (user.getEmail() != null) {
                    newUser.setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    newUser.setPassword(user.getPassword());
                }

                return repository.save(newUser);

            } else {
                return user;
            }

        } else {
            return user;
        }
    }

    public Boolean getByEmail(String email){
        List<User> userList = repository.findByEmail(email);
        if (userList.size() == 1){
            return true;
        } else {
            return false;
        }
    }

    public User loginUser(String email, String password){
        Boolean verifyUserExistence = getByEmail(email);
        User usuarioNoValido = new User();

        usuarioNoValido.setEmail(email);
        usuarioNoValido.setPassword(password);
        usuarioNoValido.setName("NO DEFINIDO");

        if (!verifyUserExistence){
            return usuarioNoValido;
        } else {
            List<User> userList = repository.findByEmail(email);
            User targetUser = userList.get(0);

            if(targetUser.getPassword().equals(password)){
                return targetUser;
            } else {
                return usuarioNoValido;
            }
        }
    }
}
