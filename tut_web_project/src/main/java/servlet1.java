import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; // Import sahi hai

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public servlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Content type set karna mat bhoolna
        response.setContentType("text/html");

        // 2. 'out' ko humesha method ke ANDAR define karte hain
        PrintWriter out = response.getWriter();
        
        // 3. Data lena
        String name = request.getParameter("name");
         
        // 4. Output dikhana
        out.println("<h1>Hello , " + name + " welcome to my website...</h1>");
        out.println("<h1><a href='servlet2'>Go to servlet 2</a></h1>");
        
        // create cookie
        Cookie c = new Cookie("user_name", name);
        
        response.addCookie(c);
    }
    
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}