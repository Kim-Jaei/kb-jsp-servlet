package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        // 저장은 response, 꺼내는 건 request
        Cookie[] cookies = request.getCookies();

        // 쿠키가 있으면 모든 쿠키 출력
        if(cookies != null) {
            for(Cookie c : cookies){
                out.print(c.getName()+":"+c.getValue()+"\n");
            }
        }else{
            out.print("장바구니 비었음<br>");
        }
        // html 작성 및 출력
        out.print("<a href='cookie_session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete_cookie'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
