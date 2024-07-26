package org.scoula.ex02;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// @WebServlet(name = "helloServlet", value = "/hello-servlet")
// @WebServlet(name = "helloServlet", value = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "안녕하세요";
        System.out.println(message);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href='/'>Home</a>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        message = "destroy!";
        System.out.println("<h1>" + message + "</h1>");
    }
}