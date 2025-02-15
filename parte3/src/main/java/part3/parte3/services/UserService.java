package part3.parte3.services;

import part3.parte3.models.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByid(Long id);
}
