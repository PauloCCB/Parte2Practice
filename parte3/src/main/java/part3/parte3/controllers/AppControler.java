package part3.parte3.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import part3.parte3.models.domain.User;
import part3.parte3.services.UserService;

@RestController
@RequestMapping("/app")
public class AppControler {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        //int value=100/0;
        int value=Integer.parseInt("10");
        System.out.println(value);
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name="id") Long id){

        return service.findByid(id);
    }
}
