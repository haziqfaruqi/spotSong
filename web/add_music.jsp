<%-- 
    Document   : add_music
    Created on : Nov 25, 2024, 6:54:47 PM
    Author     : haziqfaruqi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Music</title>
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

            .form-container {
                background-color: #fff;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 12px 20px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
                text-align: center;
            }

            h1 {
                color: #ff7e5f;
                font-size: 28px;
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

            input[type="text"]:focus {
                border-color: #feb47b;
                background-color: #fff;
            }

            input[type="submit"] {
                background-color: #ff7e5f;
                color: white;
                border: none;
                padding: 14px;
                font-size: 18px;
                cursor: pointer;
                border-radius: 8px;
                width: 100%;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            input[type="submit"]:hover {
                background-color: #feb47b;
                transform: scale(1.05);
            }

            input[type="submit"]:active {
                background-color: #e97162;
            }

            .form-footer {
                margin-top: 20px;
                font-size: 14px;
            }

            .form-footer a {
                text-decoration: none;
                color: #ff7e5f;
                font-weight: bold;
                transition: color 0.3s ease;
            }

            .form-footer a:hover {
                color: #feb47b;
            }
    </style>
    </head>
    <body>
        <div class="form-container">
        <h1>Add Music</h1>
        <form action="add_music.jsp" method="post">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" required>

            <label for="artist">Artist:</label>
            <input type="text" name="artist" id="artist" required>

            <label for="genre">Genre:</label>
            <input type="text" name="genre" id="genre" required>

            <label for="yearReleased">Year Released:</label>
            <input type="text" name="yearReleased" id="yearReleased" required>

            <input type="submit" value="Add Music">
        </form>

        <div class="form-footer">
            <p><a href="ListMusicServlet">Back to Music List</a></p>
        </div>
    </div>

    </body>
</html>
