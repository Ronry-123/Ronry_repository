package atm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void openAccountTest() {
        Account account = AccountManager.openAccount("zhangsan", "123", "123");
        assertNotNull(account);
        assertNotNull(account.accountId);
    }
    @Test
    void loginAccountTest(){
        Account account = AccountManager.openAccount("zhangsan", "1234", "1234");
        assertTrue(AccountManager.loginAccount(account.accountId, "1234"));
        assertFalse(AccountManager.loginAccount(account.accountId, "123456"));
        assertFalse(AccountManager.loginAccount(account.accountId, null));
        assertFalse(AccountManager.loginAccount(null, "1234"));
        assertFalse(AccountManager.loginAccount("", "123456"));
    }
    @Test
    void transferTest(){
        Account account1 = AccountManager.openAccount("zhangsan", "123", "123");
        Account account2 = AccountManager.openAccount("lisi", "456", "456");
        AccountManager.loginAccount(account1.accountId, account1.password);
        account1.balance = 100;
        assertTrue(AccountManager.transfer(account2.accountId, account2.username, 100));
        assertFalse(AccountManager.transfer(account2.accountId, account2.username, 1));
        AccountManager.logout();

        AccountManager.loginAccount(account2.accountId, account2.password);
        assertTrue(AccountManager.transfer(account1.accountId, account1.username, 50));
        assertFalse(AccountManager.transfer("","",5));
        assertFalse(AccountManager.transfer(null, "", 2));
        assertFalse(AccountManager.transfer(account1.accountId, account1.username, 0));
    }
    @Test
    void changePasswordTest(){
        Account account1 = AccountManager.openAccount("zhangsan","123","123");
        AccountManager.loginAccount(account1.accountId, account1.password);
        assertTrue(AccountManager.changePassword("123456","123456"));
        assertFalse(AccountManager.changePassword("",""));
        assertFalse(AccountManager.changePassword(null,null));
        assertFalse(AccountManager.changePassword("12345","123456"));
        assertFalse(AccountManager.changePassword(null,""));
    }
}