package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", value="/")
public class FrontControllerServlet extends DispatcherServlet {
    Map<String, Command> getMap; // get 요청 매핑
    Map<String, Command> postMap; // post 요청 매핑
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    public void init(){
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delte", todoController::postDelete);
    }

    private String getCommandName(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        // context명을 제외한 문자열 반환
        // 0~부터 length의 앞까지는 자르고 그 뒷부분들만 추출
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest request){
        String commandName = getCommandName(request);
        // Command 인터페이스
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
