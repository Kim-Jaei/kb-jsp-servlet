package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        String product = request.getParameter("product");

        Cookie[] cookies = request.getCookies();
        Cookie c = null;

        // 쿠키가 없으면 새로운 쿠키 만들기
        if (cookies == null || cookies.length == 0) {
            c = new Cookie("product", product);
        // 쿠키가 있으면 새로운 쿠키에 길이 하나 더 해주고 업데이트
        }else{
            c = new Cookie("product" + (cookies.length+1), product);
        }

        // 쿠키를 응답 처리
        // c.setMaxAge(60*60); -> OS 파일
        response.addCookie(c); // 브라우저 메모리

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
