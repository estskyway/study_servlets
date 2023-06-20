package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameRequestServlet")
public class MynameRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter printWriter = response.getWriter();
            String contents = "<body>\r\n" + //
                    "    <div>input your name</div>\r\n" + //
                    "    <form action=\"/getRequestParamsServlet\" method=\"get\">\r\n" + //
                    "        <div>\r\n" + //
                    "            first name : <input type=\"text\" name=\"first_name\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div>\r\n" + //
                    "            second name : <input type=\"text\" name=\"second_name\">\r\n" + //
                    "        </div>\r\n" + //
                    "        <div>\r\n" + //
                    "            <button type=\"submit\">\uBCF4\uB0B4\uAE30</button>\r\n" + //
                    "        </div>\r\n" + //
                    "    </form>\r\n" + //
                    "</body>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}