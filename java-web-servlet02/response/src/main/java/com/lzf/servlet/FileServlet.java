package com.lzf.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//（1）要获取下载文件的路径
//        String realPath = this.getServletContext().getRealPath("F:\\Program\\java-web-servlet02\\response\\src\\main\\resources\\JAVA后端.jpeg");
        String realPath = "F:\\Program\\java-web-servlet02\\response\\src\\main\\resources\\JAVA后端.jpeg";
        System.out.println("下载文件的路径"+ realPath);
//（2）下载的文件名是啥
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
//（3）设置想办法让浏览器能够支持下载我们需要的东西,中文文件名URLEncoder.encode编码，否则有可能乱码（经典解决方法）
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8")); //面向百度查询（web下载文件的头信息）attachment（附件）
//（4）获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
//（5）创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//（6）获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
//（7）将FileOutputStream流写入到buffer缓冲区,(8）使用OutputStream将缓冲区种的数据输出到客户端
        while((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
//(9) 关闭流
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
