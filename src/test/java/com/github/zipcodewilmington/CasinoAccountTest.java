package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTest {
    CasinoAccount account = new CasinoAccount("Angela", "password", 1000);

    @Test
    public void getUserNameTest() {
        String expected = "Angela";
        Assert.assertEquals(expected, account.getUserName());
    }

    @Test
    public void getPasswordTest() {
        String expected = "password";
        Assert.assertEquals(expected, account.getPassword());
    }


    @Test
    public void checkBalanceTest1() {
        Assert.assertTrue(account.checkBalance(1000));
    }

    @Test
    public void checkBalanceTest2() {
        Assert.assertTrue(account.checkBalance(500));
    }
}
