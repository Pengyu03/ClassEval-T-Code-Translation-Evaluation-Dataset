package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Bank_Account_SystemTest {

    @org.junit.Test
    @Test
    public void testDeposit() {
        Bank_Account_System account1 = new Bank_Account_System();
        int ret = account1.deposit(1000);
        assertEquals(1000, ret);
    }

    @Test
    public void testDeposit2() {
        Bank_Account_System account1 = new Bank_Account_System();
        account1.deposit(1000);
        int ret = account1.deposit(2000);
        assertEquals(3000, ret);
    }

    @Test
    public void testDeposit3() {
        Bank_Account_System account1 = new Bank_Account_System();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.deposit(-1000);
        });
        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    public void testDeposit4() {
        Bank_Account_System account1 = new Bank_Account_System();
        int ret = account1.deposit(0);
        assertEquals(0, ret);
    }

    @Test
    public void testDeposit5() {
        Bank_Account_System account1 = new Bank_Account_System();
        account1.deposit(1000);
        int ret = account1.deposit(1000);
        assertEquals(2000, ret);
    }

    @Test
    public void testWithdraw() {
        Bank_Account_System account1 = new Bank_Account_System(1000);
        int ret = account1.withdraw(200);
        assertEquals(800, ret);
    }

    @Test
    public void testWithdraw2() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.withdraw(1000);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testWithdraw3() {
        Bank_Account_System account1 = new Bank_Account_System();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.withdraw(-1000);
        });
        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    public void testWithdraw4() {
        Bank_Account_System account1 = new Bank_Account_System(1000);
        int ret = account1.withdraw(500);
        assertEquals(500, ret);
    }

    @Test
    public void testWithdraw5() {
        Bank_Account_System account1 = new Bank_Account_System(1000);
        int ret = account1.withdraw(1000);
        assertEquals(0, ret);
    }

    @Test
    public void testViewBalance() {
        Bank_Account_System account1 = new Bank_Account_System();
        assertEquals(0, account1.viewBalance());
    }

    @Test
    public void testViewBalance2() {
        Bank_Account_System account1 = new Bank_Account_System(1000);
        assertEquals(1000, account1.viewBalance());
    }

    @Test
    public void testViewBalance3() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        assertEquals(500, account1.viewBalance());
    }

    @Test
    public void testViewBalance4() {
        Bank_Account_System account1 = new Bank_Account_System(1500);
        assertEquals(1500, account1.viewBalance());
    }

    @Test
    public void testViewBalance5() {
        Bank_Account_System account1 = new Bank_Account_System(2000);
        assertEquals(2000, account1.viewBalance());
    }

    @Test
    public void testTransfer() {
        Bank_Account_System account1 = new Bank_Account_System(800);
        Bank_Account_System account2 = new Bank_Account_System(1000);
        account1.transfer(account2, 300);
        assertEquals(500, account1.viewBalance());
        assertEquals(1300, account2.viewBalance());
    }

    @Test
    public void testTransfer2() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        Bank_Account_System account2 = new Bank_Account_System();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.transfer(account2, 600);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testTransfer3() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        Bank_Account_System account2 = new Bank_Account_System(1000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account1.transfer(account2, -600);
        });
        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    public void testTransfer4() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        Bank_Account_System account2 = new Bank_Account_System(1000);
        account1.transfer(account2, 500);
        assertEquals(0, account1.viewBalance());
        assertEquals(1500, account2.viewBalance());
    }

    @Test
    public void testTransfer5() {
        Bank_Account_System account1 = new Bank_Account_System(500);
        Bank_Account_System account2 = new Bank_Account_System(1000);
        account1.transfer(account2, 200);
        assertEquals(300, account1.viewBalance());
        assertEquals(1200, account2.viewBalance());
    }

    @Test
    public void testAll() {
        Bank_Account_System account1 = new Bank_Account_System();
        Bank_Account_System account2 = new Bank_Account_System();
        account1.deposit(1000);
        account1.withdraw(200);
        account1.transfer(account2, 300);
        assertEquals(500, account1.viewBalance());
        assertEquals(300, account2.viewBalance());
    }

    @Test
    public void testAll2() {
        Bank_Account_System account1 = new Bank_Account_System();
        Bank_Account_System account2 = new Bank_Account_System();
        account1.deposit(1000);
        account1.withdraw(200);
        account1.transfer(account2, 300);
        account2.withdraw(100);
        assertEquals(500, account1.viewBalance());
        assertEquals(200, account2.viewBalance());
    }
}