package atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printWelcome();
        printMainMenu();
    }

    public static void printWelcome(){
        System.out.println("=== Welcome to the ATM System ===");
    }

    public static void printMainMenu(){
        System.out.println("=== 主菜单 ===");
        System.out.println("1.开设账户");
        System.out.println("2.登录账户");
        System.out.println("3.退出");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        switch (choice){
            case "1":
                System.out.println("=== 开设账户 ===");
                System.out.println("请输入 姓名: ");
                String userName = in.next();
                System.out.println("请输入 密码: ");
                String password = in.next();
                System.out.println("请输入 确认密码: ");
                String checkPassword = in.next();
                Account result = AccountManager.openAccount(userName, password, checkPassword);
                if (result != null){
                    System.out.println("开户成功!!!");
                    System.out.println("账号: " + result.accountId);
                }else{
                    System.out.println("开户失败!!!");
                }
                printMainMenu();
                break;
            case "2":
                System.out.println("=== 登录账户 ===");
                System.out.println("请输入 账号: ");
                String accountId = in.next();
                System.out.println("请输入 密码: ");
                String pwd = in.next();
                boolean isLogin = AccountManager.loginAccount(accountId, pwd);
                if (isLogin) {
                    System.out.println("登录成功!!!");
                    printUserMenu();
                }else {
                    System.out.println("登录失败!!!");
                    printMainMenu();
                }
                break;
            case "3":
                System.out.println("=== 退出 ===");
                break;
            default:
                System.out.println("输入错误!!!");
                printMainMenu();
                break;
        }
    }

    private static void printUserMenu() {
        System.out.println("=== 用户菜单 ===");
        System.out.println("1.取款");
        System.out.println("2.存款");
        System.out.println("3.转账");
        System.out.println("4.更改密码");
        System.out.println("5.查询余额");
        System.out.println("6.查询存取款记录");
        System.out.println("7.查询转账记录");
        System.out.println("8.退出");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        switch (choice){
            case "1":
                System.out.println("=== 取款 ===");
                System.out.println("请输入 取款金额: ");
                double amount = in.nextDouble();
                double balance = AccountManager.withdraw(amount);
                if (balance != -1){
                    System.out.println("取款成功，金额为: " + amount + ", 您的余额为: " + balance);
                }else {
                    System.out.println("取款失败.");
                }
                printUserMenu();
                break;
            case "2":
                System.out.println("=== 存款 ===");
                System.out.println("请输入 存款金额: ");
                amount = in.nextDouble();
                balance = AccountManager.deposit(amount);
                if(balance == -1){
                    System.out.println("存款失败.");
                }else{
                    System.out.println("存款成功，您的余额为: " + balance);
                }
                printUserMenu();
                break;
            case "3":
                System.out.println("=== 转账 ===");
                System.out.println("请输入 转账账号: ");
                String toAccountId = in.next();
                System.out.println("请输入 转账用户名: ");
                String toUserName = in.next();
                System.out.println("请输入 转账金额: ");
                amount = in.nextDouble();
                boolean result = AccountManager.transfer(toAccountId, toUserName, amount);
                if (result){
                    System.out.println("转账成功!!!");
                }else{
                    System.out.println("转账失败!!!");
                }
                printUserMenu();
                break;
            case "4":
                System.out.println("=== 修改密码 ===");
                System.out.println("请输入 新的密码：");
                String newPassword = in.next();
                System.out.println("请再此输入 新的密码：");
                String newCheckPassword = in.next();
                boolean bool = AccountManager.changePassword(newPassword, newCheckPassword);
                if(bool){
                    System.out.println("更改密码成功!请重新登录您的账户.");
                    printMainMenu();
                }else {
                    System.out.println("更改密码失败!两次密码输入不一致.");
                    printUserMenu();
                }
                break;
            case "5":
                System.out.println("=== 查询余额 ===");
                balance = AccountManager.getBalance();
                System.out.println("您的余额为: " + balance);
                printUserMenu();
                break;
            case "6":
                System.out.println("=== 查询存取款记录 ===");
                AccountManager.printCashOrders();
                printUserMenu();
                break;
            case "7":
                System.out.println("=== 查询转账记录 ===");
                AccountManager.printTransferOrders();
                printUserMenu();
                break;
            case "8":
                System.out.println("=== 退出 ===");
                AccountManager.logout();
                printMainMenu();
                break;
            default:
                System.out.println("输入错误!!!");
                printUserMenu();
                break;
        }
    }

}
