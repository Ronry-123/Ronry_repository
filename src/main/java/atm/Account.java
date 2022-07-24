package atm;

import java.util.Date;

public class Account {
    public String accountId;
    public String username;
    public String password;
    public double balance = 0;

    /** 记录开户时间 */
    public Date createTime = new Date();
    }