import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; 

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public servlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        
        Cookie[] cookies=request.getCookies();
        boolean f= false;
        String name="";
        
        if(cookies==null)
        {
        	    out.println("<h1>you are new user go to home page and submit name");
        	    return;
        }else
        {
        	    for(Cookie c: cookies)
        	    {
        	    	    String tname=c.getName();
        	    	    if(tname.equals("user_name"))
        	    	    {
        	    	    	
        	    	    	  f=true;
        	    	    	  name=c.getValue();
        	    	    	  }
        	    }
        }
        
        

       if(f) {
        
        out.println("<h1>Hello , " + name + " welcome back to my website...</h1>");
        out.println("<h1>Thankyou</h1>");
       }else
       {
    	   out.println("<h1>you are new user go to home page and submit name");
    	     
       }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}