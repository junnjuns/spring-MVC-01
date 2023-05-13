package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.contorller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.contorller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.contorller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();  // key - 매핑 URL, value - 호출될 컨트롤러

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();    //http://localhost:8080 이후의 주소()를 받아와서
        ControllerV1 controller = controllerMap.get(requestURI);    //주소에 맞는 객체 반환한다.

        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);  //인터페이스 호출


    }
}
