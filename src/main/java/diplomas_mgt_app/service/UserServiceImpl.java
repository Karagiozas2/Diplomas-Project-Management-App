package diplomas_mgt_app.service;
import java.util.List;
import java.util.Optional;

import diplomas_mgt_app.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import diplomas_mgt_app.dao.UserDAO;
import diplomas_mgt_app.model.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDAO.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = userDAO.findByUsername(user.getUsername());
        return storedUser.isPresent();
    }

    //TODO FINDBYID
    @Override
    public List<User> findById() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", username)
                ));
    }

}

