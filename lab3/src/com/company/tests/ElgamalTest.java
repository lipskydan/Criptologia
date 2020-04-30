package com.company.tests;

import com.company.Elgamal;
import org.junit.Assert;

import java.math.BigInteger;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class ElgamalTest {

    @org.junit.jupiter.api.Test
    void decryption() {
        Elgamal a = new Elgamal(new BigInteger("1234"));
        a.encryption("77");
        a.decryption();

        Assert.assertEquals(new BigInteger("77"), a.ad);
    }
}