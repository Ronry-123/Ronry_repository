package atm;
import java.util.Random;

public class AccountManager {
    public static final Account[] accounts = new Account[100];
    public static int currentAccountIndex = 0;
    public static Account currentAccount = null;

    //开户
    public static Account openAccount(String username, String password, String checkPassword){
        if(!password.equals(checkPassword)){
            System.out.println("两次输入的密码不一致！");
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

    //随机生成账户Id
    private static String getRandomAccountId(){
        Random random = new Random();
        StringBuilder accountId = new StringBuilder("8888");
        for (int i=0; i<6; i++){
            int num = random.nextInt(10);
            accountId.append(num);
        }
        return accountId.toString();
    }

    //登陆账户
    public static boolean loginAccount(String accountId, String psw){
        for (int i = 0; i < currentAccountIndex; i++) {
            Account account = accounts[i];
            if(account == null) {
                continue;
            }
            if (account.accountId.equals(accountId) && account.password.equals(psw)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    //存钱
    public static double deposit(double amount){
        if(currentAccount == null){
            System.out.println("请先登录");
            Main.printMainMenu();
            return -1;
        }
        if (amount <= 0) {
            System.out.println("存入金额必须大于0");
            return -1;
        }
        currentAccount.balance += amount;
        return amount;
    }

    //取钱
    public static double withdraw(double amount){
        if(currentAccount == null){
            System.out.println("请先登录");
            Main.printMainMenu();
            return -1;
        }
        if (amount <= 0) {
            System.out.println("提现金额必须大于0");
            return -1;
        }
        if (amount >= currentAccount.balance) {
            System.out.println("余额不足");
            return -1;
        }
        currentAccount.balance -= amount;
        System.out.println("提现成功: " + amount + ", 当前余额为：" + currentAccount.balance);
        return amount;
    }

    //TODO 获取余额
    public static double getBalance(){
        if(currentAccount == null){
            System.out.println("请先登录");
            Main.printMainMenu();
            return -1;
        }
        return 0;
    }

    //转账
    public static boolean transfer(String toAccountId, String toUsername, double amount){
        if(currentAccount == null) {
            System.out.println("请先登录");
            Main.printMainMenu();
            return false;
        }
        // TODO 不能向自己转账
        Account toAccount = getAccountByIdAndUsername(toAccountId, toUsername);
        if (toAccount == null){
            System.out.println("账户不存在");
            return false;
        }
        if (amount <= 0) {
            System.out.println("转账金额必须大于0");
            return false;
        }
        if (amount >= currentAccount.balance) {
            System.out.println("余额不足");
            return false;
        }
        currentAccount.balance -= amount;
        //TODO 其他操作 比如记录转账记录
        toAccount.balance += amount;
        return true;
    }

    //获取转账对象
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

    //退出当前账户
    public static void logout(){
        currentAccount = null;
    }
}
