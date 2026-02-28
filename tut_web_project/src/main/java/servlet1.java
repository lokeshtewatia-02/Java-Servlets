import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public servlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        
        out.println("<h1>Hello , " + name + " welcome to my website...</h1>");
        out.println("<h1><a href='servlet2'>Go to servlet 2</a></h1>");
        
        Cookie c = new Cookie("user_name", name);
        
        response.addCookie(c);
    }
    
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}