package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Elgamal {

    public BigInteger p, g, y;
    public BigInteger a,b;
    public BigInteger M,k;
    public BigInteger ad;
    public BigInteger x = new BigInteger("1234");
    public Random sc = new SecureRandom();

    public Elgamal(BigInteger x){
        this.x = x;
        generKeys();
    }

    public Elgamal(){
        generKeys();
        System.out.print("Введите сообщение (большое число) --> ");
        String s = new Scanner(System.in).next();
        encryption(s);
        decryption();
        getInfo();
    }

    private void generKeys(){
        p = BigInteger.probablePrime(64, sc);
        g = new BigInteger("3");
        y = g.modPow(x, p);
    }

    public void encryption(String s){
        M = new BigInteger(s);
        k = new BigInteger(64, sc);

        b = M.multiply(y.modPow(k, p)).mod(p);
        a = g.modPow(k, p);
    }

    public void decryption(){
        BigInteger crmodp = a.modPow(x, p);
        BigInteger d = crmodp.modInverse(p);
        ad = d.multiply(b).mod(p);
    }

    private void getInfo(){
        System.out.println("secretKey = " + x);
        System.out.println("p = " + p);
        System.out.println("g = " + g);
        System.out.println("y = " + y);

        System.out.println("Сообщение = " + M);
        System.out.println("целое число k такое, что 1 < k < (p − 1) ---> k = " + k);
        System.out.println("a = g^k mod p = " + a);
        System.out.println("b = y^k * M mod p = " + b);

        System.out.println("Дешифрованное сообщение: " + ad);



    }

}
