package com.my.wan.copy;

import java.io.*;

public class HandleFile {
    public static void main(String[] args) throws IOException {
        test3();
    }


    static void test4() throws IOException{

    }

    static void test3() throws IOException{
        PrintWriter pw = new PrintWriter(new FileOutputStream("E:/java/c.txt"));
        pw.write("我是最大的");
        pw.close();
    }

    static void test2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\java\\bb.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\java\\aa.txt")));
        String line = reader.readLine();
        bw.append("12345678",2,5);
        bw.flush();
        bw.close();
        reader.close();
    }

    static void test1() throws IOException {
        File file = new File("E:\\java\\bb.txt");
//        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write("我是最棒的");
        bw.close();
        fos.close();
    }


}
