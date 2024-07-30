package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("장바구니 리스트");

        // false: 세션이 존재하지 않을 때 새로운 세션을 생성하지 않도록 함 -> null 반환
        // 세션 유무만 확인
        // 20초 동안 세션에 아무런 활동이 없으면 무효화(삭제)
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(20); // 20초

        // 세션 존재하면 product 출력하고
        // 세션 없으면 세션 없음이라고 출력
//        if(session != null) {
//            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
//            out.print("상품: " + list + "<br>");
//        }else{
//            out.print("세션 없음" + "<br>");
//        }

        if (session != null) {
            System.out.println("기존 세션 사용: " + session.getId());
            session.setMaxInactiveInterval(20); // 20 seconds
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

            if (list != null && !list.isEmpty()) {
                out.print("Product: " + list + "<br>");
            } else {
                out.print("Product: null<br>");
            }
        } else {
            System.out.println("세션 없음");
            out.print("No session<br>");
        }

        // 클릭하면 해당 페이지 이동
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
