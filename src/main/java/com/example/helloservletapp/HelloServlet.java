package com.example.helloservletapp;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "   <body>\n" +
                "      <form action = \"hello-servlet\" method = \"POST\">\n" +
                "         Введите первое число: <input type = \"text\" name = \"number1\">\n" +
                "         Введите второе  число: <input type = \"text\" name = \"number2\">\n" +
                "<tr>\n" +
                "        <td>Выберите действие</td>\n" +
                "        <td>\n" +
                "            <select name = \"action\">\n" +
                "                <option value = \"*\">*</option>\n" +
                "                <option value = \"/\">/</option>\n" +
                "                <option value = \"+\">+</option>\n" +
                "                <option value = \"-\">-</option>\n" +
                "            </select>\n" +
                "        </td>\n" +
                "    </tr>" +
                "         <br />\n" +
                "         <input type = \"submit\" value = \"Submit\" />\n" +
                "      </form>\n" +
                "   </body>\n" +
                "</html>");

        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String action = request.getParameter("action");
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int res = 0;
        double resD = 0;
        if (action.equals("*")) {
            res = num1 * num2;
            message = String.valueOf(res);
        }
        if (action.equals("/")) {
            if (num1 == 0 || num2 == 0) {
                String path = "/error";
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            } else
                resD = num1 / num2;
            message = String.valueOf(resD);
        }

        if (action.equals("+")) {
            res = num1 + num2;
            message = String.valueOf(res);
        }
        if (action.equals("-")) {
            res = num1 - num2;
            message = String.valueOf(res);
        }
        out.println("<html>\n" +
                "   <body>\n" +
                "   <h1>" + message +
                "   </h1>\n" +
                "   </body>\n" +
                "</html>");

        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}