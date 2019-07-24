package com.my.wan.copy;

import java.io.File;
import java.io.IOException;

public class DirectUtil {

    public static void main(String[] args) throws IOException {
        copyFile("E:\\java\\aa","E:\\java\\dest");
    }


    //copy一个文件夹到
    //这个要判断是不是文件，还是文件夹，如果是文件夹就要递归再进行copy。

    /**
     * copy 文件从src到dest
     * @param src
     * @param dest
     * 例 把E:\java\aa 文件夹copy到 E:\java\dest文件夹下
     */
    public static void copyFile(String src,String dest) throws IOException {
        File srcFile = new File(src);
        File destFile = new File(dest);
        if(srcFile.isDirectory()){
            String aa = src.substring(src.lastIndexOf("\\") + 1);
            File file = new File(dest+"\\"+aa);
            file.mkdir();
        }
    }

}
