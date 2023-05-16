package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//RequestMappingHandlerMapping은 스프링 빈 중에서 @RequestMapping 또는 @Controller가 클래스 레벨에 붙어 있는 경우 매핑정보로 인식한다.

//@Controller 대신 @Component + @RequestMapping 으로 작성해도 동작된다.
@Controller //스프링이 자동으로 스프링 빈으로 등록한다. @controller안에 @Component가 있어서 @ComponentScan의 대상이 된다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")   //요청 정보를 매핑한다. 해당 URL이 호출되면 process() 실행
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
