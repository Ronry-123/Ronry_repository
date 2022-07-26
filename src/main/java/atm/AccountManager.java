package atm;

import java.util.*;

public class AccountManager {
    //public static Account[] accounts = new Account[100];
    //也可以用List, Set, Map等集合类来更改accounts类型
    public static Map<String, Account> accountMap = new HashMap<>();
    public static Account currentAccount = null;


    //开户
    public static Account openAccount(String username, String password, String checkPassword) {
        if (!password.equals(checkPassword)) {
            System.out.println("两次输入的密码不一致.");
            return null;
        }
        if (username == null || username.length() == 0){
            System.out.println("用户不能输入空字符串.");
            return null;
        }
        Account account = new Account();
        account.username = username;
        account.password = password;
        account.accountId = getRandomAccountId();
        accountMap.put(account.accountId, account);
        return account;
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
        Account account = accountMap.get(accountId);
        if (account == null){
            System.out.println("账号不存在");
            return false;
        }
        if (!account.password.equals(password)){
            System.out.println("密码错误");
            return false;
        }
        currentAccount = account;  //老师代码中未执行这一步
        return true;
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
        if(newPsw == null || newCheckPsw == null){
            return false;
        }
        if(newPsw.length() == 0 || newCheckPsw.length() == 0){
            return false;
        }
        if(newPsw.equals(newCheckPsw)){
            currentAccount.password = newPsw;
            accountMap.put(currentAccount.accountId, currentAccount);
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
        Account account = accountMap.get(accountId);
        if (account == null){
            System.out.println("转账账户不存在.");
            return null;
        }
        if (!account.username.equals(username)){
            System.out.println("用户名错误.");
            return null;
        }
        return account;
    }

    public static void logout() {
        currentAccount = null;
    }
}
