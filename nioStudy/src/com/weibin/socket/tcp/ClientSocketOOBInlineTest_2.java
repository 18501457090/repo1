package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ClientSocketOOBInlineTest_2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream out = socket.getOutputStream();
        // 必须使用OutputStreamWriter类才出现预期的效果
        OutputStreamWriter writer = new OutputStreamWriter(out);
        socket.sendUrgentData(97);
        writer.write("zzzzzzzzzzzzzzzzzzzzzzzzz!");
        socket.sendUrgentData(98);
        socket.sendUrgentData(99);
        // 必须使用flush()，不然不会出现预期的效果
        writer.flush();
        socket.sendUrgentData(100);
        out.close();
        socket.close();
    }

}
