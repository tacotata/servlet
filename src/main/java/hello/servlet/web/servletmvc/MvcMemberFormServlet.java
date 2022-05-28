package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//controller야
//mvc 패턴은 항상 컨트롤러 거쳐서 view 들어감
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //컨트롤러에서 뷰로 이동할때 사용 RequestDispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //이걸 호출하면 서블릿에서 jsp를 호출할 수 있음
        dispatcher.forward(request, response);

    }
}
