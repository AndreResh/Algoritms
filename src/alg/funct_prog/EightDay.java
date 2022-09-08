package alg.funct_prog;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class EightDay {
    public static void main(String[] args) {
        Account account1 = new Account("Account1", "pro");
        Account account2 = new Account("Account2", "pro");
        Account account3 = new Account("Account3", "simple");
        Set usersSet = new HashSet();
        usersSet.add(new User("User1", account1));
        usersSet.add(new User("User2", account2));
        usersSet.add(new User("User3", account3));
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account1");//print User1
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account3");//doesn't print anything
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account22");//doesn't print anything
    }
}

class Rocket {
    private final NavigationModule navigationModule;

    public Rocket(NavigationModule navigationModule) {
        this.navigationModule = navigationModule;
    }

    public Optional<NavigationModule> getNavigationModule() {
        return Optional.ofNullable(navigationModule);
    }
}

class NavigationModule {
    private final String title;

    public NavigationModule(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        return users.stream()
                .filter(user -> user.getAccount()
                        .map(Account::getId)
                        .map(id::equals)
                        .orElse(false))
                .findAny();

//        return users.stream()
//                .filter(user -> user.getAccount()
//                        .map(Account::getId)
//                        .filter(id::equals)
//                        .isPresent())
//                .findAny();
    }
}

//class Account {
//    private final String id;
//
//    public Account(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }
//}
//
//class User {
//    private final String login;
//    private final Account account;
//
//    public User(String login, Account account) {
//        this.login = login;
//        this.account = account;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public Optional<Account> getAccount() {
//        return Optional.ofNullable(account);
//    }
//}
class PrintLoginQuiz {

    public static void printLoginIfPro(Set<User> users, String id) {
        users.stream()
                .filter(user -> user.getAccount().filter((o) -> o.getId().equals(id) && o.getType().equals("pro")).isPresent())
                .findFirst().ifPresent((o) -> System.out.println(o.getLogin()));
    }
}

class Account {
    private String id;
    private String type;

    public Account(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class User {
    private String login;
    private Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", account=" + account +
                '}';
    }
}