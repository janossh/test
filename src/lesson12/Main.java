package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 10, usBank);
        User user2 = new User(1002, "Taras", 2200, 42, "DMG", 10, usBank);

        Bank euBank = new EUBank(1223, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user3 = new User(1003, "John", 1000, 32, "GMD", 10, euBank);
        User user4 = new User(1004, "Sara", 2500, 12, "GMD", 10, euBank);

        Bank chBank = new EUBank(1224, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user5 = new User(1005, "Ivan", 560, 14, "GMD", 10, chBank);
        User user6 = new User(1006, "Oleg", 390, 33, "GMD", 10, chBank);

        BankSystem bankSystem = new UkranianBankSystem();

        //bankSystem.withdraw(user1, 150);
        runMyMetod(new User[] {user1, user2,user3,user4, user5,user6}, bankSystem);

    }

    private static void runMyMetod(User[] users, BankSystem bankSystem) {

        for (int i = 0; i < users.length; i++) {
            bankSystem.withdraw(users[i], 150);
            bankSystem.fund(users[i], 150);
            bankSystem.paySalary(users[i]);
            bankSystem.transferMoney(users[i], users[i == users.length - 1 ? i : 0], 150);

        }

        for (User el: users)
            el.toString();

    }
}
