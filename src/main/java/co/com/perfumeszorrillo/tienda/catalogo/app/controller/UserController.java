package co.com.perfumeszorrillo.tienda.catalogo.app.controller;

import co.com.perfumeszorrillo.tienda.catalogo.app.models.User;
import co.com.perfumeszorrillo.tienda.catalogo.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{email}")
    public Boolean getByEmail(@PathVariable("email") String email){
        return service.getByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User loginUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.loginUser(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@Valid @RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User update (@Valid @RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestBody User user){
        service.delete(user);
    }

}
