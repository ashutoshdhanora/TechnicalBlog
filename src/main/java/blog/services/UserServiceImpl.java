package blog.services;

import blog.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        return true;
    }

    @Override
    public boolean registerNewUser(User user) {
        return false;
    }

    @Override
    public User getUser(String userName) {
        return null;
    }
}
