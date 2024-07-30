package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save")
public class CartSaveServlet extends HttpServlet {

    // request: 클라이언트로부터 요청 정보를 담고 있음
    // response: 서버가 클라이언트에게 응답할 정보를 담고 있음
    // jsp 파일에서 GET 방식을 썼기 때문에 doGet() 실행
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서버 -> 클라이언트 응답의 콘텐츠 타입 : html 형식, 한글 포함
        response.setContentType("text/html;charset=UTF-8");

        // 서버 -> 클라이언트 텍스트 데이터를 보내기 위한 객체 형성
        // PrintWriter: 쓰기 편한 출력 스트림
        PrintWriter out = response.getWriter();

        // 클라이언트의 요청에서 product라는 매개변수 값을 가져오기
        // ex) naver.com?product=apple이라면, product 변수에는 "apple" 저장
        String product = request.getParameter("product");

        // 현재 클라이언트와 연결된 세션을 가져오기
        // 세션: 클라이언트와 서버가 통신할 때 여러 요청을 하나의 연속된 대화로 인식
        // 클라이언트의 정보를 서버 측에서 저장하고 관리하게 해줌
        // getSession(): 현재 연결된 세션 반환, 없다면 새로운 세션 반환
        HttpSession session = request.getSession();

        // product에 저장된 속성을 가져와 list에 저장 없으면 null 반환
        // String 변환 이유 : 세션에 담긴 애들은 Object 타입인데 그대로 사용하면 메서드 이용 불가능
        // 가장 유연한 String으로 변환해서 사용함
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");


        // list에 아무것도 없으면 새로운 list를 만들기
        // 새로만든 list는 클라이언트가 선택할 제품을 저장할 카트
        // session.setAttribute("속성 이름", 저장할 객체);

        if(list == null) {
            list = new ArrayList<>();
            session.setAttribute("product", list);
        }

        // String product = request.getParameter("product"); 여기서 클라이언트의 요청을 받아옴
        // 그 요청에 담긴 값을 list에 추가
        list.add(product);

        // 잘 추가했으면 다음과 같은 html 화면 띄우기
        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        // 클릭시 상품 선택 페이지
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        // 클릭시 선택했던 상품들 보는 페이지
        out.print("<a href='cart_view'>장바구니 보기</a><br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
