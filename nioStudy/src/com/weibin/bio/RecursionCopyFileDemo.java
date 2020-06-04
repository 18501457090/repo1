package com.weibin.bio;

import java.io.*;
import java.util.Objects;

/**
 * @Desc: 递归复制文件
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class RecursionCopyFileDemo {


    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.print(System.getProperty("file.separator"));

        //copyFile("D:\\app\\weChat\\WeChat Files\\WeChat Files\\zwb1310917497\\FileStorage\\File\\2020-02","D:/WriterDemo");
    }

    static void copyFile(String src,String dest) throws IOException {
        File srcFile = new File(src);
        if (!srcFile.exists()){
            return;
        }
        File destFile = new File(dest);
        if (!destFile.exists()){
            boolean newFile = destFile.mkdirs();
            if (!newFile){
                throw new IOException("文件夹创建失败！");
            }
        }
        File[] files = srcFile.listFiles();
        if (files != null && files.length > 0){
            int readBytes;
            byte[] bytes = new byte[1024];
            for (File file : files){
                // 如果是文件夹
                if (file.isDirectory()){
                    copyFile(file.getAbsolutePath(),dest + "/" + file.getName());
                } else {
                    // 是文件
                    String absolutePath = file.getAbsolutePath();
                    System.out.println("absolutePath : " + absolutePath);
                    try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(absolutePath))){
                        String destPath = dest + "/" + file.getName();
                        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(destPath))){
                            while ((readBytes = reader.read(bytes)) != -1){
                                writer.write(bytes,0,readBytes);
                                writer.flush();
                            }
                        } catch (IOException e){
                            e.printStackTrace();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }


    }


}
