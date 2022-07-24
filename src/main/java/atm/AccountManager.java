package atm;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Random;


public class AccountManager {
    public static Account[] accounts = new Account[100];
    public static int currentAccountIndex = 0;
    public static Account currentAccount = null;


    //开户
    public static Account openAccount(String username, String password, String checkPassword) {
        if (!password.equals(checkPassword)) {
            System.out.println("两次输入的密码不一致.");
            return null;
        }
        Account account = new Account();
        account.username = username;
        account.password = password;
        account.accountId = getRandomAccountId();
        accounts[currentAccountIndex] = account;
        currentAccountIndex ++;
        return account;
    }

    //账户扩容
    private static void reSize(){
        Account[] newAccounts = new Account[accounts.length * 2];
        for (int i = 0; i < accounts.length; i++) {
            newAccounts[i] = accounts[i];
        }
        accounts = newAccounts;
    }

    //随机获取账号Id
    private static String getRandomAccountId() {
        Random random = new Random();
        StringBuilder id = new StringBuilder("888");
        for (int i = 0; i < 7; i++) {
            int num = random.nextInt(10);
            id.append(num);
        }
        return id.toString();
    }

    //登陆账户
    public static boolean loginAccount(String accountId, String password) {
        for (int i = 0; i < currentAccountIndex; i++) {
            Account account = accounts[i];
            if(account == null) {
                continue;
            }
            if (account.accountId.equals(accountId) && account.password.equals(password)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    // 取款
    public static double withdraw(double amount) {
        if(currentAccount == null){
            System.out.println("请先登录.");
            Main.printMainMenu();
            return -1;
        }
        if (amount <= 0) {
            System.out.println("取款金额必须大于0.");
            return -1;
        }
        if (amount >= currentAccount.balance) {
            System.out.println("余额不足.");
            return -1;
        }
        CashOrder currentOrder = new CashOrder(currentAccount.accountId, CashEnum.WITHDRAW, amount, true);
        currentAccount.addCashOrder(currentOrder);
        currentAccount.balance -= amount;
        return currentAccount.balance;
    }

    // 存款
    public static double deposit(double amount) {
        if(currentAccount == null){
            System.out.println("请先登录.");
            Main.printMainMenu();
            return -1;
        }
        if (amount <= 0) {
            System.out.println("存入金额必须大于0.");
            return -1;
        }
        CashOrder currentOrder = new CashOrder(currentAccount.accountId, CashEnum.DEPOSIT, amount, true);
        currentAccount.addCashOrder(currentOrder);
        currentAccount.balance += amount;
        return currentAccount.balance;
    }

    //转账
    public static boolean transfer(String toAccountId, String toUsername, double amount) {
        if(currentAccount == null){
            System.out.println("请先登录.");
            Main.printMainMenu();
            return false;
        }
        if(currentAccount.accountId == toAccountId  && currentAccount.username == toUsername){
            System.out.println("不能向自己转账.");
            return false;
        }
        Account toAccount = getAccountByIdAndUsername(toAccountId, toUsername);
        if (toAccount == null){
            System.out.println("转账账户不存在.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("转账金额必须大于0.");
            return false;
        }
        if (amount > currentAccount.balance) {
            System.out.println("余额不足.");
            return false;
        }
        TransferOrder currentOrder = new TransferOrder(currentAccount.accountId, toAccountId, amount);
        currentAccount.addTransferOrder(currentOrder);
        currentAccount.balance -= amount;
        toAccount.balance += amount;
        return true;
    }

    //更改密码
    public static boolean changePassword(String newPsw, String newCheckPsw){
        if(newPsw.equals(newCheckPsw)){
            currentAccount.password = newPsw;
            accounts[currentAccountIndex] = currentAccount;
            return true;
        }
        return false;
    }
    //查询余额
    public static double getBalance() {
        if(currentAccount == null){
            System.out.println("请先登录.");
            Main.printMainMenu();
            return -1;
        }
        double balance = currentAccount.balance;
        return balance;
    }

    //查询存取款交易信息
    public static void printCashOrders(){
        CashOrder[] cashOrders;
        cashOrders = currentAccount.getCashOrders();
        if (cashOrders == null){
            System.out.println("交易信息为空.");
        }else {
            for(int i=0; i<currentAccount.getCashOrderIndex(); i++){
                System.out.println(cashOrders[i].toString());
            }
        }
    }

    //查询转账记录
    public static void printTransferOrders(){
        TransferOrder[] transferOrders = currentAccount.getTransferOrders();
        if(transferOrders == null){
            System.out.println("交易信息为空.");
        }else{
            for(int i=0; i<currentAccount.getTransferOrderIndex(); i++){
                System.out.println(transferOrders[i].toString());
            }
        }
    }


    //获取账户(通过Id和Name)
    private static Account getAccountByIdAndUsername(String accountId, String username) {
        for (int i = 0; i < currentAccountIndex; i++) {
            Account account = accounts[i];
            if(account == null) {
                continue;
            }
            if (account.accountId.equals(accountId) && account.username.equals(username)) {
                return account;
            }
        }
        return null;
    }

    public static void logout() {
        currentAccount = null;
    }
}
