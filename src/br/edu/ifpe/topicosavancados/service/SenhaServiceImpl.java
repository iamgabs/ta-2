package br.edu.ifpe.topicosavancados.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

import br.edu.ifpe.topicosavancados.interfaces.HashI;
public class SenhaServiceImpl implements HashI {

    public SenhaServiceImpl() {}

    @Override
    public StringBuilder getHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger hex = new BigInteger(1, messageDigest);
            StringBuilder md5String = new StringBuilder(hex.toString(16));

            while (md5String.length() < 32) {
                md5String.insert(0, "0");
            }

            return md5String;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
