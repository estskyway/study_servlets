package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameRequestServlet")
public class MynameRequestServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      PrintWriter printWriter = response.getWriter();
      String contents = "<!DOCTYPE html>\r\n" + //
          "<html lang=\"en\">\r\n" + //
          "<head>\r\n" + //
          "  <meta charset=\"UTF-8\">\r\n" + //
          "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
          "  <title>Document</title>\r\n" + //
          "</head>\r\n" + //
          "<body>\r\n" + //
          "  <div>input your name</div>\r\n" + //
          "  <form action=\"http://192.168.0.221:8080/getRequestParamsServlet\" method=\"get\">\r\n" + //
          "  <div>first name : <input type=\"text\" name=\"first_name\"></div>\r\n" + //
          "  <div>second name : <input type=\"text\" name=\"second_name\"></div>\r\n" + //
          "  <div><button type=\"submit\">\uBCF4\uB0B4\uAE30</button></div>\r\n" + //
          "</form>\r\n" + //
          "</body>\r\n" + //
          "</html>";
      printWriter.println(contents);
      printWriter.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
