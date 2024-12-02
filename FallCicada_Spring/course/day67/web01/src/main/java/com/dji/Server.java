package com.dji;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @program: demo
 * @description:
 * @author: fallcicada
 * @create: 2024-12-02  16:21
 **/
/*
 * 自定义web服务器，收取浏览器请求并解析，然后做出响应
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 启动服务器，绑定8081端口
        ServerSocket ss = new ServerSocket(8081);
        System.out.println("server is running...");
        // 接收客户端的连接
        while (true){
            Socket socket = ss.accept();
            System.out.println("connected from " +
                    socket.getRemoteSocketAddress());
            //为客户端专门开启线程，处理其请求
            Thread t = new Handler(socket);
            t.start();
        }
    }
}
class Handler extends Thread {
    Socket socket;
    public Handler(Socket sock) {
        this.socket = sock;
    }
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {
            //处理请求
            handle(input, output);
        } catch (Exception e) {
            try {
                socket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("client disconnected.");
        }
    }
    //请求处理，注意：一定要遵循HTTP协议
    private void handle(InputStream input, OutputStream output)
            throws IOException {
        // 1.对IO流进行包装
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input,
                        StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(output,
                        StandardCharsets.UTF_8));
        boolean requestOk = false;
        // 2.读取HTTP请求行
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestOk = true;
        }
        // 3.逐行读取请求头
        for (;;) {
            String header = reader.readLine();
            // 4.读取到空行时, HTTP Header读取完毕
            if (header.isEmpty()) {
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");
                // 5.按照HTTP协议封装响应数据，返回给浏览器
        if (!requestOk) {
            // 5.1 发送错误响应
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        } else {
            // 5.2 发送成功响应
            //读取html文件，转换为字符串
            InputStream is =
                    Server.class.getClassLoader().getResourceAsStream("html/a.html");
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(is));
            StringBuilder data = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();
            // 获取html文件长度
            int length =
                    data.toString().getBytes(StandardCharsets.UTF_8).length;
            // 具体响应体封装
            // 响应行
            writer.write("HTTP/1.1 200 OK\r\n");
            // 响应头s
            writer.write("Connection: keep-alive\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            // 响应空行(标识Header和Body的分隔)
            writer.write("\r\n");
            // 响应体数据
            writer.write(data.toString());
            writer.flush();
        }
    }
}