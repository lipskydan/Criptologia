package com.company;

import org.junit.Assert;

import java.util.Arrays;

import static com.company.Main.hexStringToByteArray;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @org.junit.jupiter.api.Test
    void encryption() {
        String tempString = "01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe";
        String text_data = "02 13 24 35 46 57 68 79 8a 9b ac bd ce df e0 f1";

        tempString=tempString.replace(" ", "");
        text_data=text_data.replace(" ", "");

        byte[] key=hexStringToByteArray(tempString);
        byte[] W=hexStringToByteArray(text_data);
        Main.S=new Main().keySchedule(key);
        byte[] encrypt=new Main().encryption(W);
        String encrypted_text=Main.byteArrayToHex(encrypt);

        String real_encrypted="c8241816f0d7e48920ad16a1674e5d48";

        Assert.assertEquals(real_encrypted,encrypted_text);
    }

    @org.junit.jupiter.api.Test
    void decryption() {

        String tempString = "c8 24 18 16 f0 d7 e4 89 20 ad 16 a1 67 4e 5d 48";
        String text_data = "02 13 24 35 46 57 68 79 8a 9b ac bd ce df e0 f1";

        tempString=tempString.replace(" ", "");
        text_data=text_data.replace(" ", "");

        byte[] key2=hexStringToByteArray(tempString);
        byte[] X=hexStringToByteArray(text_data);
        Main.S=new Main().keySchedule(key2);
        byte[] decrypt=new Main().decryption(X);
        String decrypted_text=Main.byteArrayToHex(decrypt);

        String real_dencrypted="dd 0d 54 00 be 0e 4c 71 18 e4 a8 f4 23 9b 31 15";
        real_dencrypted=real_dencrypted.replace(" ","");

        Assert.assertEquals(real_dencrypted,decrypted_text);

    }
}