package com.example.helloservletapp;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Error", value = "/error")
public class Error extends HelloServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String message;

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "   \n" +
                "    <title>Exception</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Exception occurred while processing the request</h2>\n" +
                "<p>Type:  exception </p>\n" +
                "<p>Message:  \"деление на ноль\" </p>\n" +
                "</body>\n");
        out.println("Let's go back to <a href=\""
                + response.encodeURL(
                "http://localhost:8080/HelloServletApp_war_exploded/hello-servlet")
                + "\">Home Page</a>.");
    }
}
