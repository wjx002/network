package com.jiaxu.lesson05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws IOException {
        //下载地址
        URL url = new URL("https://m801.music.126.net/20210416005842/26a440ddd8500c5f41152bd182be33b2/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/8366666591/cac9/d94d/8948/e2b3eea69209862623657b08bb7d6d19.m4a");

        //连接这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("1.m4a"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer,0,len);

        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
