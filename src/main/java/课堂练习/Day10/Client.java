package 课堂练习.Day10;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 8888);
            //构建IO
            InputStream inputStream = s.getInputStream();
            OutputStream outputStream = s.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            //向客户端发送消息
            bufferedWriter.write("此用来测试客户端和服务端的通信，服务器接收到消息返回客户端\n");
            bufferedWriter.flush();
            //读取服务器返回的消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String mess = bufferedReader.readLine();
            System.out.println("服务器："+mess);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
