package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


///front-controller/v1/* 하위호출은 서블릿이 다 호출되는거임
@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //실제는 log로 찍어
        System.out.println("FrontControllerServletV1.service");

        //uri받을 수 있어
        // /front-controller/v1/members
        String requestURI = request.getRequestURI();
        // 이 키를 넣으면/front-controller/v1/members", 이 값이 꺼내지겠죠 new MemberListControllerV1()
        //다형성의해서 인터페이스로 받을 수 있는거야
        ControllerV1 controller = controllerMap.get(requestURI);
        //예외 처리
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //잘 가져오면 인터페이스 호출
        controller.process(request, response);

    }
}
