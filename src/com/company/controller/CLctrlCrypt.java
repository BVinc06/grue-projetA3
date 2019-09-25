package com.company.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLctrlCrypt {

    public void ecrireFichierSimple(String path, String texte) {
        try {
            String str = texte;
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String lireFichierSimple(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedReader buf = new BufferedReader(new InputStreamReader(fis));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            String fileAsString = sb.toString();
            return fileAsString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String crypter(String msg, String key) {

        String encrypHexa = "";
        int keyItr = 0;
        for (int i = 0; i < msg.length(); i++) {
            // XOR Operation
            int temp = msg.charAt(i) ^ key.charAt(keyItr);

            encrypHexa += String.format("%02x", (byte) temp);
            keyItr++;
            if (keyItr >= key.length()) {
                // once all of key's letters are used, repeat the key
                keyItr = 0;
            }

        }

        return encrypHexa;

    }

    public String decrypter(String msg, String key) {

        String hexToDeci = "";
        for (int i = 0; i < msg.length() - 1; i += 2) {
            // splitting hex into a pair of two
            String output = msg.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            hexToDeci += (char) decimal;
        }

        // decryption
        String decrypText = "";
        int keyItr = 0;
        for (int i = 0; i < hexToDeci.length(); i++) {
            // XOR Operation
            int temp = hexToDeci.charAt(i) ^ key.charAt(keyItr);

            decrypText += (char) temp;
            keyItr++;
            if (keyItr >= key.length()) {
                // once all of key's letters are used, repeat the key
                keyItr = 0;
            }



        }
        return decrypText;
    }
}

