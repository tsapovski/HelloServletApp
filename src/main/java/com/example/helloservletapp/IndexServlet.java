package com.example.helloservletapp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Index", value = "/index-servlet")
public class IndexServlet extends HelloServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("flag", true);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

}
