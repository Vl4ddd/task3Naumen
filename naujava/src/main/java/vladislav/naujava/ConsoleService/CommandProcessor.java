package vladislav.naujava.ConsoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladislav.naujava.UserService.UserService;

@Component
public class CommandProcessor {
    private final UserService userService;

    @Autowired
    public CommandProcessor(UserService userService) {
        this.userService = userService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0]) {
            case "create" -> {
                userService.createUser(Long.valueOf(cmd[1]), cmd[2]);
                System.out.println("Пользователь успешно добавлен...");
            }
            case "delete" -> {
                userService.deleteById(Long.valueOf(cmd[1]));;
                System.out.println("Пользователь успешно удален...");
            }
            case "update" -> {
                userService.updatePrivilege(Long.valueOf(cmd[1]), false);
                System.out.println("Пользователь успешно обновлен...");
            }
            case "read" -> {
                userService.findById(Long.valueOf(cmd[1]));
                System.out.println("Пользователь с id: " + (String) userService.findById(Long.valueOf(cmd[1])).getLogin());
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}