package org.scoula.ex06;

import org.scoula.ex06.command.Command;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;
    String prefix = "/WEB-INF/view/";
    String suffix = ".jsp";

    @Override
    public void init(){
        getMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        // 의미있는 uri만 뽑기
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request){
        // 요청 이름 추출
        String commandName = getCommandName(request);

        // 구체적 작업을 하는 model
        Command command;

        // 요청이 들어올 때 get인지 post인지 파악
        if(request.getMethod().equalsIgnoreCase("GET")){
            // 특정 키 값에 있는 정보 가져오기
            command = getMap.get(commandName);
        }else{
            // 특정 키 값에 있는 정보 가져오기
            command = postMap.get(commandName);
        }
        // Map 반환
        return command;
    }

    private void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")){
            response.sendRedirect(viewName.substring("redirect:".length()));
        }else{
            String view = prefix + viewName + suffix;
            RequstDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
