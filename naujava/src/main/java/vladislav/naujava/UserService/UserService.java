package vladislav.naujava.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vladislav.naujava.repository.UserRepository;
import vladislav.naujava.User.User;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(Long id, String login) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setLogin(login);
        userRepository.create(newUser);
    }

    @Override
    public User findById(Long id) {
        return userRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void updatePrivilege(Long id, boolean newPrivilege) {
        User user = new User();
        user.setId(id);
        user.setPrivilege(newPrivilege);
        userRepository.update(user);
    }

}
