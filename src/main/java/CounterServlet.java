import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;
    //    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean reset = Boolean.valueOf(request.getParameter("reset"));

        if (reset){
            counter = 0;
        }

        counter += 1;
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");



    }
}

