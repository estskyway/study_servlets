package com.example.study_servlets.controlls;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mynameRequestServletJSP") // 파라미터는 필요하지 않음. 화면에 띄우기만 할 것이라서
public class MynameRequestServletJSP extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      //RequestDispatcher는 중간다리 역할  // URL의 정보를 바꿔서 경로를 바꿔서 보낸다 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myname_request.jsp");
        requestDispatcher.forward(request, response);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
