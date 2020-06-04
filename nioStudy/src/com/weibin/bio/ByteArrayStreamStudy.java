package com.weibin.bio;

import java.io.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class ByteArrayStreamStudy {


    public static void main(String[] args) {
        byte[] bytes = fileToByteArray("D:\\WriterDemo\\girl.jpg");
        System.out.println(bytes.length);
        byteArrayToFile("D:\\WriterDemo\\girl1.jpg",bytes);
    }

    static byte[] fileToByteArray(String filePath){
        File file = new File(filePath);
        if (!file.exists()){
            return null;
        }
        try (InputStream is = new BufferedInputStream(new FileInputStream(file))){
            try (ByteArrayOutputStream bis = new ByteArrayOutputStream()){
                    byte[] bytes = new byte[2048];
                    int len;
                    while ((len = is.read(bytes)) != -1){
                        bis.write(bytes,0,len);
                    }
                    bis.flush();
                return bis.toByteArray();
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static void byteArrayToFile(String filePath,byte[] bytes){
        if (filePath == null){
            return;
        }
        File file = new File(filePath);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
            try (OutputStream os = new BufferedOutputStream(new FileOutputStream(file))){
                byte[] segmentData = new byte[1024];
                int len = -1;
                while ((len = bis.read(segmentData)) != -1){
                    os.write(segmentData,0,len);
                }
                os.flush();
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
