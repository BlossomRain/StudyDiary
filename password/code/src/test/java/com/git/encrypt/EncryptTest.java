package com.git.encrypt;


import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class EncryptTest {


    // 测试对称加密
    @Test
    public void testDES() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String origin = "这是一个测试文本";
        // 必须是8位
        String key = "12345789";
        String transformation = "DES";
        Cipher cipher = Cipher.getInstance(transformation);
        // 加密规则
        String algorithm = "DES";
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);


        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] bytes = cipher.doFinal(origin.getBytes());
        //  -----找不到就会乱码
        System.out.println(new String(bytes));

        // base64编码
        byte[] encode = Base64.getEncoder().encode(bytes);
        System.out.println(new String(encode));
    }


    // 测试凯撒加密/解密
    @Test
    public void testCaesar() {
        // 原文
        String code = "abcdefg hieeeeeee";
        // 右移三位
        int key = 3;
        String caesorEncrpt = CaesarEncrypt(code, key);
        System.out.println(caesorEncrpt);
        System.out.println("-------------------");
        System.out.println(CaesarDecrypt(caesorEncrpt));

    }

    // 凯撒解密---默认左移
    public String CaesarDecrypt(String code) {
        char[] chars = code.toCharArray();
        // 获取有序的map
        List<Map.Entry<Character, Integer>> keys = getKey(code);

        // 假定最多次数是e  则依次取最多
        int key = 'e' - keys.get(0).getKey();
        System.out.println("max " + keys.get(0).getKey() + "  key " + key);
        return CaesarEncrypt(code, key);
    }

    private List<Map.Entry<Character, Integer>> getKey(String code) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list;
    }

    // 凯撒加密--默认右移
    private String CaesarEncrypt(String code, int key) {
        // 抽取
        char[] chars = code.toCharArray();
        StringBuilder bu = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            bu.append((char) (chars[i] + key));
        }

        return bu.toString();
    }


    // 测试ASCII 码
    @Test
    public void testAscii() {
        for (int i = 0; i < 127; i++) {
            System.out.print((char) i);
            if (i % 40 == 0) System.out.println();
        }

        String code = "abcd";
        char[] chars = code.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print((int) chars[i] + " ");
        }

    }


}
