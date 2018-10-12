import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdServlet", urlPatterns = "/ads")
public class AdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);

        // Use the factory to get the dao object
        Ads adsDao = DaoFactory.getAdsDao();
        // Use a method on the dao to get all the products
        List<Ad> products = adsDao.all();
        // Pass the data to the jsp
        request.setAttribute("ads", products);
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);

        }
    }
