package com.example.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet_test")
public class HellowWorldServlet_test extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("HellowWorldServlet - doGet()");
            try {
                String firstName = "yoju" ;
                String secondName = "Lab" ;
               PrintWriter printWriter = response.getWriter();   // 네트워크에 getwrite를 함
                //String contents = "Yoju Lab !";
               String contents = "<!DOCTYPE html>\r\n" + //
                       "<html lang=\"en\">\r\n" + //
                       "<head>\r\n" + //
                       "    <meta charset=\"UTF-8\">\r\n" + //
                       "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                       "    <title>Hello World !</title>\r\n" + //
                       "</head>\r\n" + //
                       "<body>\r\n" + //
                       "    <div>\r\n" + //
                       "        first Name : "+firstName+" \r\n" + //
                       "    </div>\r\n" + //
                       "    <div>\r\n" + //
                       "        second Name : "+secondName+" \r\n" + //
                       "    </div>\r\n" + //
                       "</body>\r\n" + //
                       "</html>";
               printWriter.println(contents);
               printWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
             System.out.println("HellowWorldServlet - doGet() done.");

        }
}
