<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Music Record</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: linear-gradient(135deg, #ff7e5f, #feb47b);
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .container {
                background-color: #fff;
                padding: 40px;
                border-radius: 12px;
                box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
                text-align: center;
            }
            h1 {
                color: #ff7e5f;
                font-size: 24px;
                margin-bottom: 20px;
                text-transform: uppercase;
            }
            label {
                font-weight: bold;
                color: #333;
                display: block;
                margin-bottom: 10px;
                font-size: 16px;
                text-align: left;
            }
            input[type="text"] {
                width: 100%;
                padding: 12px;
                margin: 8px 0 20px 0;
                border: 2px solid #ff7e5f;
                border-radius: 8px;
                font-size: 16px;
                color: #333;
                box-sizing: border-box;
                background-color: #f9f9f9;
                transition: border-color 0.3s ease, background-color 0.3s ease;
            }
            input[type="submit"] {
                padding: 10px;
                width: 100%;
                background-color: #ff7e5f;
                color: white;
                border: none;
                font-size: 18px;
                cursor: pointer;
                border-radius: 8px;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #feb47b;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Edit Music Record</h1>
            <form action="EditMusicServlet" method="post">
                <!-- Hidden input to hold the ID -->
                <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="<%= request.getParameter("title") %>" required>

                <label for="artist">Artist:</label>
                <input type="text" id="artist" name="artist" value="<%= request.getParameter("artist") %>" required>

                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre" value="<%= request.getParameter("genre") %>" required>

                <label for="yearReleased">Year Released:</label>
                <input type="text" id="yearReleased" name="yearReleased" value="<%= request.getParameter("yearReleased") %>" required>

                <input type="submit" value="Update Record">

            </form>
        </div>
    </body>
</html>
