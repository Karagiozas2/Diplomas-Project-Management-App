package diplomas_mgt_app.service;


import diplomas_mgt_app.model.Professor;
import org.springframework.stereotype.Service;

import diplomas_mgt_app.model.User;

import java.util.List;

@Service
public interface UserService {
    public void saveUser(User user);
    public boolean isUserPresent(User user);

    public List<User> findById();


}
