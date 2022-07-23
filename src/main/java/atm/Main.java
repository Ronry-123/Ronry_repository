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
        System.out.println("2.登陆账户");
        System.out.println("3.退出");
        Scanner sc = new Scanner(System.in);
        //避免非预期用户输入
        String choice = sc.next();
        switch(choice){
            case "1":
                System.out.println("=== 开设账户 ===");
                System.out.println("请输入姓名：");
                String username = sc.next();
                System.out.println("请输入密码：");
                String password = sc.next();
                System.out.println("请确认密码：");
                String checkPassword = sc.next();
                Account result = AccountManager.openAccount(username, password, checkPassword);
                if (result != null){
                    System.out.println("开户成功！");
                    System.out.println("账户信息："+result.accountId);
                }else {
                    System.out.println("开户失败！");
                }
                printMainMenu();
                break;
            case "2":
                System.out.println("=== 登陆账户 ===");
                System.out.println("请输入账户：");
                String accountId = sc.next();
                System.out.println("请输入密码：");
                String psw = sc.next();
                boolean isLogin = AccountManager.loginAccount(accountId, psw);
                if (isLogin){
                    System.out.println("登陆账户成功！");
                    printUserMenu();
                    //TODO 账户信息
                }else {
                    System.out.println("登录失败");
                    printMainMenu();
                }
                break;
            case "3":
                System.out.println("退出成功！");
                break;
            default:
                System.out.println("输入错误！");
                printMainMenu();
        }
    }

    private static void printUserMenu(){
        System.out.println("=== 用户菜单 ===");
        System.out.println("1.提现");
        System.out.println("2.存钱");
        System.out.println("3.转账");
        System.out.println("4.查询余额");
        System.out.println("5.退出");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        switch (choice){
            case "1":
                System.out.println("=== 提现 ===");
                System.out.println("请输入 提现金额: ");
                double amount = sc.nextDouble();
                double balance = AccountManager.withdraw(amount);
                System.out.println("取现成功，金额为: " + amount + ", 余额为: " + balance);
                printUserMenu();
                break;
            case "2":
                System.out.println("=== 存钱 ===");
                System.out.println("请输入 存钱金额: ");
                amount = sc.nextDouble();
                balance = AccountManager.deposit(amount);
                System.out.println("您的余额为: " + balance);
                printUserMenu();
                break;
            case "3":
                System.out.println("=== 转账 ===");
                System.out.println("请输入 转账账号: ");
                String toAccountId = sc.next();
                System.out.println("请输入 转账用户名: ");
                String toUserName = sc.next();
                System.out.println("请输入 转账金额: ");
                amount = sc.nextDouble();
                boolean result = AccountManager.transfer(toAccountId, toUserName, amount);
                if (result){
                    System.out.println("转账成功!!!");
                }else{
                    System.out.println("转账失败!!!");
                }
                printUserMenu();
                break;
            case "4":
                System.out.println("=== 查询余额 ===");
                balance = AccountManager.getBalance();
                System.out.println("您的余额为: " + balance);
                printUserMenu();
                break;
            case "5":
                System.out.println("=== 退出 ===");
                printMainMenu();
                break;


        }
    }
}
