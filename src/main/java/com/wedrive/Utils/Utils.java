package com.wedrive.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Utils {
    private static final float TAXE = 0.092f;
    public String cryptPassword(String password)
    {
        byte[] keyData = DatatypeConverter.parseHexBinary("83014C46494E2E56414C45524546");

        Key secretKey = new SecretKeySpec(keyData, "Blowfish");
        byte[] ciphertext = null;
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            ciphertext = cipher.doFinal(password.getBytes());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        String encrypted = DatatypeConverter.printHexBinary(ciphertext);
        return encrypted;
    }

    public float generateAmount(LocalDateTime startDate, LocalDateTime endDate, float pricePerDay) {
        float amount;
        try{
            long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            amount = pricePerDay*noOfDaysBetween;
            amount*=(1 + TAXE);
        }catch (Exception e){
            amount = 0;
        }
        return amount;
    }

}
