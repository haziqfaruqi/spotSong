<%-- 
    Document   : login
    Created on : Nov 25, 2024, 2:59:24 PM
    Author     : haziqfaruqi
--%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: linear-gradient(135deg, #ff7e5f, #feb47b);
                padding: 0;
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            h1 {
                color: #000000;
                font-size: 36px;
                margin-bottom: 20px;
                text-transform: uppercase;
                letter-spacing: 1px;
            }
            .container {
                background-color: #fff;
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0 12px 25px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                margin: 20px;
                width: 100%;
            }
            input[type='text'], input[type='password'] {
                padding: 12px;
                width: 100%;
                margin: 10px 0;
                border: 1px solid #ddd;
                border-radius: 8px;
                font-size: 16px;
            }
            input[type='submit'] {
                padding: 12px;
                width: 100%;
                background-color: #ff7e5f;
                color: white;
                border: none;
                font-size: 18px;
                cursor: pointer;
                border-radius: 8px;
                transition: background-color 0.3s;
            }
            input[type='submit']:hover {
                background-color: #feb47b;
            }
            .error-message {
                color: red;
                font-size: 14px;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <form action="login.jsp" method="post">
                <input type="text" name="username" placeholder="Username" required><br>
                <input type="password" name="password" placeholder="Password" required><br>
                <input type="submit" value="Login">
            </form>
            <% 
                // Process login when the form is submitted
                if ("POST".equalsIgnoreCase(request.getMethod())) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    
                    if ("admin".equals(username) && "password".equals(password)) {
                        session.setAttribute("username", username);
                        response.sendRedirect("list_music.jsp");
                    } else {
            %>
                        <div class="error-message">Invalid login. Please try again.</div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
