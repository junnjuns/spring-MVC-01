package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// /hello로 오면 HelloServlet 실행
// name : 서블릿 이름
@WebServlet(name ="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //getParameter로 쿼리 파라미터 조회할 수 있다.
        System.out.println("username = " + username);

        response.setContentType("text/plain");  //text를 보낼 것이다.
        response.setCharacterEncoding("utf-8"); //인코딩 정보 utf-8
        response.getWriter().write("hello " + username); // Http body에 데이터가 들어간다.

    }
}
