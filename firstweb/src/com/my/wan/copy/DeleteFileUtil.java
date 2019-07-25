package com.my.wan.copy;

import java.io.File;

public class DeleteFileUtil {

    public static void main(String[] args) {
        File f = new File("E:\\java\\aa");
        deleteAllFile(f);
    }

    /**
     * 删除一个文件夹及里面的所有的内容
     * @param deleteFile
     */
    public static void deleteAllFile(File deleteFile){
        if(deleteFile.isDirectory()){
            File[] files = deleteFile.listFiles();
            for(File f : files){
                if(f.isFile()){
                   f.delete();
                }else{
                    deleteAllFile(f);
                }
            }
        }
        //删除空的文件夹或文件
        deleteFile.delete();
    }



}
