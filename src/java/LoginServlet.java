import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try (PrintWriter out = response.getWriter()) {
            if("admin".equals(username) && "password".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("index.html");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Failed</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #ff7e5f, #feb47b); padding: 0; margin: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
                out.println("h1 { color: #000000; font-size: 36px; margin-bottom: 20px; text-transform: uppercase; letter-spacing: 1px; }");
                out.println(".container { background-color: #fff; padding: 30px; border-radius: 12px; box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1); max-width: 400px; margin: 20px; width: 100%; }");
                out.println("input[type='text'], input[type='password'] { padding: 12px; width: 100%; margin: 10px 0; border: 1px solid #ddd; border-radius: 8px; font-size: 16px; }");
                out.println("input[type='submit'] { padding: 12px; width: 100%; background-color: #ff7e5f; color: white; border: none; font-size: 18px; cursor: pointer; border-radius: 8px; transition: background-color 0.3s; }");
                out.println("input[type='submit']:hover { background-color: #feb47b; }");
                out.println(".error { background-color: #f8d7da; color: #721c24; padding: 15px; border-radius: 5px; margin-bottom: 15px; font-weight: bold; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");

                out.println("<div class='error'>Wrong Credentials. Please try again.</div>");

                out.println("<h1>Login</h1>");
                out.println("<form method='POST'>");
                out.println("<input type='text' name='username' placeholder='Username' required><br>");
                out.println("<input type='password' name='password' placeholder='Password' required><br>");
                out.println("<input type='submit' value='Login'>");
                out.println("</form>");

                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that handles user login";
    }
}
