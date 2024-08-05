package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap; // get 요청 매핑
    Map<String, Command> postMap; // post 요청 매핑
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    public void init(){
        getMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        // context명을 제외한 문자열 반환
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request){
        String commandName = getCommandName(request);

        Command command;
        // get 요청일 때는 일반적으로 forward
        if(request.getMethod().equalsIgnoreCase("GET")){
            command = getMap.get(commandName);
            // post 요청일 떄는 redirect
        }else{
            command = postMap.get(commandName);
        }
        return command;
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewName = command.execute(request, response);

        if(viewName.startsWith("redirect:")){ // redirect 처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        }else{
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if(command != null){
            execute(command, request, response);
        }else{
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}

