package vladislav.naujava.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vladislav.naujava.User.User;
import java.util.stream.Collectors;

@Component
public class UserRepository implements DataCRUD<User, Long> {
    private List<User> userContainer;

    @Autowired
    public UserRepository(List<User> userContainer) {
        this.userContainer = userContainer;
    }

    @Override
    public void create(User user) {
        userContainer.add(user);
    }

    @Override
    public User read(Long id) {
        User userId = userContainer.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

        return userId;
    }

    @Override
    public void update(User user) {
        userContainer = userContainer.stream()
                .map(u -> u.getId() == user.getId() ? user : u)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        userContainer = userContainer.stream()
                .filter(u -> u.getId() != id)
                .collect(Collectors.toList());
    }
}
