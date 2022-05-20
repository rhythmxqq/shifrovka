package com.company;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("stih.txt");
            String x = "";
            int k = 0;
            while ((k = fr.read()) != -1) {
                x += (char) k;
            }
            String text = x.toLowerCase(Locale.ROOT);
            String forIndex = text.replace("\r\n", " ");
            FileWriter fileWriter = new FileWriter("zpis.txt");
            fileWriter.write(text);
            fileWriter.flush();
            Scanner in = new Scanner(System.in);
            System.out.print("Введите слово: ");
            String word = in.nextLine().toLowerCase(Locale.ROOT);
            char[] qxqx = word.toCharArray();
            String result = "";
            char[] word1 = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                String kk = word1[i] + "";
                String first = (int)find(kk) + "";
                int index = forIndex.indexOf(qxqx[i]);
                String second = index+1 + "";
                result += "(" + first + " ; " + second + ") ";
                if (result.contains("-")){
                    result = "символ не найден";
                    break;
                }
            }
            System.out.println(result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    static int find(String bukovka) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("zpis.txt"));
            String SS = null;
            int i = 0;
            while ((SS = reader.readLine()) != null) {
                i++;
                if (SS.contains(bukovka)) {
                    return i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}