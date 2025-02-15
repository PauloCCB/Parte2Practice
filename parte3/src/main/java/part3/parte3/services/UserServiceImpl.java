package part3.parte3.services;

import org.springframework.stereotype.Service;
import part3.parte3.models.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List <User> users;
    public UserServiceImpl() {
        this.users=new ArrayList<>();
        users.add(new User(1L,"Paulo","Calderon"));
        users.add(new User(2L,"Sayumi","Calderon"));
        users.add(new User(3L,"Cesar","Calderon"));
        users.add(new User(4L,"Nadia","Calderon"));
    }

    @Override
    public List<User> findAll() {

        return users;
    }


    @Override
    public User findByid(Long id) {
        User user=null;
        for (User u:users){
            if(u.getId().equals(id)){
                user=u;
                break;
            }
        }
        return user;
    }
}
