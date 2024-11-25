<%-- 
    Document   : list_music
    Created on : Nov 25, 2024, 2:48:40 PM
    Author     : haziqfaruqi
--%>

<%@page import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Music Library</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background: linear-gradient(135deg, #ff7e5f, #feb47b);
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }

            .table-container {
                background-color: #ffffff;
                padding: 40px;
                border-radius: 12px;
                box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1);
                max-width: 900px;
                width: 100%;
                text-align: center;
            }

            h1 {
                color: #ff7e5f;
                font-size: 32px;
                margin-bottom: 20px;
                text-transform: uppercase;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #ff7e5f;
                color: white;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            .button {
                background-color: #ff7e5f;
                color: #fff;
                padding: 10px 20px;
                font-size: 18px;
                cursor: pointer;
                border-radius: 8px;
                text-decoration: none;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            .button:hover {
                background-color: #feb47b;
                transform: scale(1.05);
            }

            .button:active {
                background-color: #e97162;
            }
            
            .action-links a {
                text-decoration: none;
                padding: 5px 10px;
                margin: 0 5px;
                border-radius: 6px;
                color: white;
                background-color: #ff7e5f;
                transition: background-color 0.3s ease;
            }

            .action-links a:hover {
                background-color: #feb47b;
            }
        </style>
    </head>
    <body>
        <div class="table-container">
            <h1>Music Library</h1>
            <% 
                // Check if the user is logged in by verifying the session
                if (session == null || session.getAttribute("username") == null) {
                    response.sendRedirect("login.jsp"); // No session, redirect to login page
                    return;
                }

                // Display a message if there is any (e.g., after adding new music)
                String message = (String) request.getAttribute("message");
                if (message != null) {
            %>
                    <div style="color: green;"><%= message %></div>
            <%
                }
            %>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Genre</th>
                    <th>Year Released</th>
                    <th>Actions</th>
                </tr>
                <%
                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;

                    try {
                        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MusicLibraryDB", "app", "app");
                        String query = "SELECT * FROM Music";
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();

                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String title = rs.getString("title");
                            String artist = rs.getString("artist");
                            String genre = rs.getString("genre");
                            int yearReleased = rs.getInt("yearReleased");
                %>
                            <tr>
                                <td><%= id %></td>
                                <td><%= title %></td>
                                <td><%= artist %></td>
                                <td><%= genre %></td>
                                <td><%= yearReleased %></td>
                                <td class="action-links">
                                    <a href="edit_music.jsp?id=<%= id %>&title=<%= title %>&artist=<%= artist %>&genre=<%= genre %>&yearReleased=<%= yearReleased %>">
                                        Edit
                                    </a>
                                </td>
                            </tr>

                <%
                        }
                    } catch (SQLException e) {
                        out.println("<p style='color: red;'>Error retrieving music records: " + e.getMessage() + "</p>");
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                        if (stmt != null) try { stmt.close(); } catch (SQLException ignored) {}
                        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
                    }
                %>
            </table>
            <br>
            <a href="add_music.jsp" class="button">Add New Music</a>
        </div>
    </body>
</html>
