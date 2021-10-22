package com.bein.gescoapi.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

@Service
public class ShaHashImpl implements ShaHash {

    private String plaintext;
    private String hash;

    @Override
    public synchronized String hash(String plaintext) {
        this.plaintext = plaintext;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            md.update(this.plaintext.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] raw = md.digest();
        this.hash = new BASE64Encoder().encode(raw);
        return this.hash;
    }

    public String getPlaintext() {
        return this.plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
