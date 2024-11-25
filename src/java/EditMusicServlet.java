import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditMusicServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");

        String title = "";
        String artist = "";
        String genre = "";
        String yearReleased = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MusicLibraryDB", "app", "app");
            String query = "SELECT * FROM Music WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id)); 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                title = rs.getString("title");
                artist = rs.getString("artist");
                genre = rs.getString("genre");
                yearReleased = rs.getString("yearReleased");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Edit Music Record</title>");
        out.println("<style>");
        
        out.println("body {");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("    background: linear-gradient(135deg, #ff7e5f, #feb47b);");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    height: 100vh;");
        out.println("    margin: 0;");
        out.println("}");

        out.println(".container {");
        out.println("    background-color: #ffffff;");
        out.println("    padding: 40px;");
        out.println("    border-radius: 12px;");
        out.println("    box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1);");
        out.println("    max-width: 500px;");
        out.println("    width: 100%;");
        out.println("    text-align: center;");
        out.println("}");

        out.println("h1 {");
        out.println("    color: #ff7e5f;");
        out.println("    font-size: 28px;");
        out.println("    margin-bottom: 20px;");
        out.println("    text-transform: uppercase;");
        out.println("}");

        out.println("label {");
        out.println("    font-weight: bold;");
        out.println("    color: #333;");
        out.println("    display: block;");
        out.println("    margin-bottom: 8px;");
        out.println("    font-size: 16px;");
        out.println("    text-align: left;");
        out.println("}");

        out.println("input[type='text'] {");
        out.println("    width: 100%;");
        out.println("    padding: 12px;");
        out.println("    margin-bottom: 20px;");
        out.println("    border: 2px solid #ff7e5f;");
        out.println("    border-radius: 8px;");
        out.println("    font-size: 16px;");
        out.println("    color: #333;");
        out.println("    box-sizing: border-box;");
        out.println("    background-color: #f9f9f9;");
        out.println("    transition: border-color 0.3s ease, background-color 0.3s ease;");
        out.println("}");

        out.println("input[type='text']:focus {");
        out.println("    border-color: #feb47b;");
        out.println("    background-color: #fff8e1;");
        out.println("}");

        out.println("input[type='submit'] {");
        out.println("    background-color: #ff7e5f;");
        out.println("    color: #fff;");
        out.println("    border: none;");
        out.println("    padding: 14px;");
        out.println("    font-size: 18px;");
        out.println("    cursor: pointer;");
        out.println("    border-radius: 8px;");
        out.println("    width: 100%;");
        out.println("    transition: background-color 0.3s ease, transform 0.2s ease;");
        out.println("}");

        out.println("input[type='submit']:hover {");
        out.println("    background-color: #feb47b;");
        out.println("    transform: scale(1.05);");
        out.println("}");

        out.println("input[type='submit']:active {");
        out.println("    background-color: #e97162;");
        out.println("}");

        out.println(".form-footer {");
        out.println("    margin-top: 20px;");
        out.println("    font-size: 14px;");
        out.println("}");

        out.println(".form-footer a {");
        out.println("    text-decoration: none;");
        out.println("    color: #ff7e5f;");
        out.println("    font-weight: bold;");
        out.println("    transition: color 0.3s ease;");
        out.println("}");

        out.println(".form-footer a:hover {");
        out.println("    color: #feb47b;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        
        out.println("<body>");
        
        out.println("<div class='container'>");
        out.println("<h1>Edit Music Record</h1>");
        out.println("<form action='EditMusicServlet' method='post'>");

        out.println("<input type='hidden' name='id' value='" + id + "'>");

        out.println("<label for='title'>Title:</label>");
        out.println("<input type='text' id='title' name='title' value='" + title + "' required><br><br>");

        out.println("<label for='artist'>Artist:</label>");
        out.println("<input type='text' id='artist' name='artist' value='" + artist + "' required><br><br>");

        out.println("<label for='genre'>Genre:</label>");
        out.println("<input type='text' id='genre' name='genre' value='" + genre + "' required><br><br>");

        out.println("<label for='yearReleased'>Year Released:</label>");
        out.println("<input type='text' id='yearReleased' name='yearReleased' value='" + yearReleased + "' required><br><br>");

        out.println("<input type='submit' value='Update Record'>");
        out.println("</form>");
        
        out.println("<div class='form-footer'>");
        out.println("<p><a href='ListMusicServlet'>Back to Music List</a></p>");
        out.println("</div>");
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String artist = request.getParameter("artist");
        String genre = request.getParameter("genre");
        String yearReleased = request.getParameter("yearReleased");

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MusicLibraryDB", "app", "app");
            String query = "UPDATE Music SET title = ?, artist = ?, genre = ?, yearReleased = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, artist);
            stmt.setString(3, genre);
            stmt.setInt(4, Integer.parseInt(yearReleased));
            stmt.setInt(5, Integer.parseInt(id));
            stmt.executeUpdate(); 

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("list_music.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet that edits music records in the MusicLibraryDB";
    }
}
