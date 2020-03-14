package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.Product;
import pl.edu.wszib.domain.User;

import java.util.List;

@RestController          // to oznacza że nie bedziemy korzystali z thymeleafea' tylko wysyłamy zapytania restowe na zewnątrz i wymian danych za pomocą jsonów
@RequestMapping("api")
@CrossOrigin
public class RestShopController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @GetMapping("products")
    public List<Product> products(){
        return productDao.getProducts();
    }

    @DeleteMapping("products/remove/{id}")
    public void removeProduct(@PathVariable Long id){
        productDao.removeProduct(id);
    }

    @PostMapping("products/save")
    public void saveProduct(@RequestBody Product product){
        productDao.saveProduct(product);
    }

    @GetMapping("products/single/{id}")
    public Product getProduct(@PathVariable Long id){
        return productDao.getById(id);
    }
    
// ------------------------
    @GetMapping("users")
    public List<User> users(){
        return userDao.getUser();
    }

    @DeleteMapping("users/remove/{id}")
    public void removeUser(@PathVariable Long id){
        userDao.removeUser(id);
    }

    @PostMapping("users/save")
    public void saveUser(@RequestBody User user){
        userDao.saveUser(user);
    }

    @GetMapping("users/single/{id}")
    public User getUser(@PathVariable Long id){
        return userDao.getById(id);
    }


}
