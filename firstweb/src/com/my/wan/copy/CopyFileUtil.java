package com.my.wan.copy;


import java.io.*;

/**
 * copy一个文件夹到另一个文件夹下
 */
public class CopyFileUtil {


    public static void main(String[] args) {
        String a = "D:\\360安全浏览器下载\\jetbrains最新破解补丁和激活码";
        String b = "E:\\java";
        copyDirToDir(a, b);
    }

    public static void copyDirToDir(String srcPath, String destPath) {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        srcPath = srcPath.substring(0, srcPath.lastIndexOf("\\"));
        copy(srcFile, destFile, srcPath, destPath);
    }

    /**
     * 这已经是主要的代码了，再进行封装一次就完善了
     *
     * @param srcFile
     * @param destFile
     * @param srcPath
     * @param destPath
     */
    static void copy(File srcFile, File destFile, String srcPath, String destPath) {
        if (srcFile.isDirectory()) {
            File fileSrc = new File(srcFile.getAbsolutePath().replace(srcPath, destPath));
            if (!fileSrc.exists()) {
                fileSrc.mkdirs();
            }
            File[] listFiles = srcFile.listFiles();
            for (File f : listFiles) {
                //递归
                copy(f, destFile, srcPath, destPath);
            }
        } else {
            copyFileToDir(srcFile, srcFile.getAbsolutePath().replace(srcPath, destPath));
        }

    }

    /**
     * 复制一个文件到指定文件夹
     */
    static void copyFileToDir(File file, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(destPath);
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
