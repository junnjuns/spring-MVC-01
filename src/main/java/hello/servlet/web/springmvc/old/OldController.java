package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller") //스프링 Bean의 이름을 url 패턴으로 맞춘다.
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        //스프링부트가 InternalResourceViewResolver 라는 뷰 리졸버를 자동으로 등록하는데
        // application.properties에 등록한 prefix, suffix 설정정보를 사용해서 등록한다.
        return new ModelAndView("new-form");
    }
}
