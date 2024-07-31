package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 1. 파라미터 추출 (400 에러, 클라이언트 측)
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");
        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        // 2. 비즈니스 로직 실행 (500 에러, 서버 측)
        // 3. 결과 request scope 저장
        // 4. forwarding / redirect
        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);
        request.setAttribute("login", loginDTO);

        // 로그인 처리
        HttpSession session = request.getSession();
        Member member = new Member("홍길동", "hong");
        session.setAttribute("user", member);

        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
