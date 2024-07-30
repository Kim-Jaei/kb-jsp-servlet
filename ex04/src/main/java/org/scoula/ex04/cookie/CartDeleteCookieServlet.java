package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for(Cookie c : cookies){
               c.setMaxAge(1);
               response.addCookie(c); // 쿠키 삭제 & 저장
            }
        }

        out.print("장바구니 비웠음!!");
        out.print("<a href='session_product.jsp'>상품 선택 이미지</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
