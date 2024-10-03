package vladislav.naujava.UserService;


import vladislav.naujava.User.User;


public interface UserInterface {

    void createUser(Long id, String login);

    User findById(Long id);

    void deleteById(Long id);

    void updatePrivilege(Long id, boolean newPrivilege);
}
