package com.music.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import com.music.model.MusicItem;

public class ListLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<MusicItem> musics = new ArrayList<>();
        musics.add(new MusicItem("Cardigan", "2020", "Indie Folk", "Taylor Swift"));
        musics.add(new MusicItem("Someone like you", "2011", "Pop/Soul", "Adele"));
        musics.add(new MusicItem("Fight Song", "2015", "Pop", "Rachel Platten"));

        String sort = request.getParameter("sort");
        if ("year".equalsIgnoreCase(sort)) {
            musics.sort(Comparator.comparing(MusicItem::getYear));
        } else if ("artist".equalsIgnoreCase(sort)) {
            musics.sort(Comparator.comparing(MusicItem::getArtist));
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>My Music Library</title>");
            out.println("<style>");
            
            out.println("body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #ff7e5f, #feb47b); padding: 0; margin: 0; display: flex; justify-content: center; align-items: center; height: 100vh; color: #000000; text-align: center; }");
            out.println("h1 { color: #000000; font-size: 36px; margin-bottom: 20px; text-transform: uppercase; letter-spacing: 1px; }");
            out.println("p { font-size: 18px; color: #333; }");

            out.println(".container { background-color: #fff; padding: 30px; border-radius: 12px; box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1); max-width: 800px; margin: 20px; width: 100%; }");

            out.println("table { width: 100%; margin: 20px 0; border-collapse: collapse; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("th, td { padding: 12px; text-align: left; border: 1px solid #ddd; font-size: 16px; }");
            out.println("th { background-color: #ff7e5f; color: white; font-weight: bold; text-transform: uppercase; }");
            out.println("tr:nth-child(even) { background-color: #f9f9f9; }");

            out.println("tr:hover { background-color: #ffe0b3; }");

            out.println("a { color: #ff7e5f; text-decoration: none; font-weight: bold; transition: color 0.3s ease; font-size: 18px; }");
            out.println("a:hover { color: #feb47b; }");
            out.println(".sort-links { font-size: 18px; margin-top: 20px; }");
            out.println(".sort-links a { margin: 0 10px; padding: 8px 15px; background-color: #fff; border-radius: 8px; transition: background-color 0.3s ease; }");
            out.println(".sort-links a:hover { background-color: #feb47b; }");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>My Music Library</h1>");
            out.println("<p>You currently have <b>" + musics.size() + "</b> music items in your collection.</p>");

            out.println("<div class='sort-links'>");
            out.println("<p>Sort by: <a href=\"?sort=year\">Year</a> | <a href=\"?sort=artist\">Artist</a></p>");
            out.println("</div>");

            out.println("<table>");
            out.println("<tr><th>Title</th><th>Artist</th><th>Genre</th><th>Year</th></tr>");
            
            for (MusicItem item : musics) {
                out.println("<tr>");
                out.println("<td>" + item.getTitle() + "</td>");
                out.println("<td>" + item.getArtist() + "</td>");
                out.println("<td>" + item.getGenre() + "</td>");
                out.println("<td>" + item.getYear() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<a href='add_music.html'>Add Music Item</a>");
            out.println("</div>"); 
            out.println("</body>");
            out.println("</html>");
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
        return "Servlet that displays a list of music items in a styled table with sorting options";
    }
}
