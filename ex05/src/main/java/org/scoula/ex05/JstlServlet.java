package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Member> members = new ArrayList<>();
        for(int i=0; i<10; i++){
            Member member = new Member("홍길동_" + i, "hong_" + i);
            members.add(member);
        }

        request.setAttribute("members", members);
        request.setAttribute("role", "ADMIN");
        request.setAttribute("today", new Date()); // java.util 필요

        request.getRequestDispatcher("jstl_ex.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
