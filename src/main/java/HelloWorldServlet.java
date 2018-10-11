import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter; <---Only needed if you utilize PrintWriter

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String output = "World!";

        if(name != null){
            output = name;
        }

        response.getWriter().println("<h1>Hello, " + output + "</h1>");
        response.getWriter().println("<h2>This should be an H2</h2>");



    }
}

