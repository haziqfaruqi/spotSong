import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListMusicServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Music Library</title>");
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

        out.println(".table-container {");
        out.println("    background-color: #ffffff;");
        out.println("    padding: 40px;");
        out.println("    border-radius: 12px;");
        out.println("    box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1);");
        out.println("    max-width: 900px;");
        out.println("    width: 100%;");
        out.println("    text-align: center;");
        out.println("}");

        out.println("h1 {");
        out.println("    color: #ff7e5f;");
        out.println("    font-size: 32px;");
        out.println("    margin-bottom: 20px;");
        out.println("    text-transform: uppercase;");
        out.println("}");

        out.println("table {");
        out.println("    width: 100%;");
        out.println("    border-collapse: collapse;");
        out.println("}");

        out.println("th, td {");
        out.println("    padding: 12px;");
        out.println("    text-align: left;");
        out.println("    border-bottom: 1px solid #ddd;");
        out.println("}");

        out.println("th {");
        out.println("    background-color: #ff7e5f;");
        out.println("    color: white;");
        out.println("}");

        out.println("tr:nth-child(even) {");
        out.println("    background-color: #f9f9f9;");
        out.println("}");

        out.println(".button {");
        out.println("    background-color: #ff7e5f;");
        out.println("    color: #fff;");
        out.println("    padding: 10px 20px;");
        out.println("    font-size: 18px;");
        out.println("    cursor: pointer;");
        out.println("    border-radius: 8px;");
        out.println("    text-decoration: none;");
        out.println("    transition: background-color 0.3s ease, transform 0.2s ease;");
        out.println("}");

        out.println(".button:hover {");
        out.println("    background-color: #feb47b;");
        out.println("    transform: scale(1.05);");
        out.println("}");

        out.println(".button:active {");
        out.println("    background-color: #e97162;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        
        out.println("<body>");
        
        out.println("<div class='table-container'>");
        out.println("<h1>Music Library</h1>");
        
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Title</th>");
        out.println("<th>Artist</th>");
        out.println("<th>Genre</th>");
        out.println("<th>Year Released</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MusicLibraryDB", "app", "app");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Music";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String genre = rs.getString("genre");
                int yearReleased = rs.getInt("yearReleased");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + artist + "</td>");
                out.println("<td>" + genre + "</td>");
                out.println("<td>" + yearReleased + "</td>");
                out.println("<td><a href='EditMusicServlet?id=" + id + "' class='button'>Edit</a></td>");
                out.println("</tr>");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error retrieving music data: " + e.getMessage() + "</p>");
        }

        out.println("</table>");
        out.println("<br>");
        out.println("<a href='add_music.html' class='button'>Add New Music</a>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
        out.close();
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
        return "Servlet that lists music items from the MusicLibraryDB";
    }
}
