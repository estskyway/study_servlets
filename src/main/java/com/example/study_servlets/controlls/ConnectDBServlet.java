package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.51:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // 클라이언트에 html 화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>COMPANY_ID</th>\r\n" + //
                    "                    <th>COMPANY</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" ;
                           

            // - query Edit
            Statement statement = connection.createStatement();
            String quary = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(quary);
            while(resultSet.next()){
               
                System.out.println( 
                resultSet.getString("COMPANY_ID")
                +resultSet.getString("COMPANY"));
                contents =  contents +  
                    "            <tbody>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <td>"+resultSet.getString("COMPANY_ID")+"</td>\r\n" + //
                    "                    <td>"+resultSet.getString("COMPANY")+"</td>\r\n" + //
                    "                </tr>\r\n" ;
                    
            }

            contents =  contents +  
                    "          </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" + //
                    "\r\n" + //
                    "</html>";

            // 클라이언트에 html 화면 제공
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;

            quary = "SELECT COUNT(*) AS CNT FROM factorys";
             resultSet = statement.executeQuery(quary);
             int totalCount = 0;
              while(resultSet.next()){
               
                System.out.println( 
                resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }

            // INSERT INTO factorys 
            // (COMPANY_ID,COMPANY)
            // VALUE
            // ('CAR-01', 'AUDI');
            String companyId = "CAR-01";
            String company = "AUDI";
            quary = "INSERT INTO factorys " +
                    "(COMPANY_ID,COMPANY) " +
                    "VALUE " +
                    "('"+companyId+"', '"+company+"') ";
            // int count = statement.executeUpdate(quary);

            // UPDATE factorys 
            // SET COMPANY = '페러리'
            // WHERE COMPANY_ID = 'CAR-01' ;

            String set_company = "페러리";
            String update_company_id = "CAR-01";
            quary = "UPDATE factorys " +
                    "SET COMPANY = '" + set_company + "' " +
                    "WHERE COMPANY_ID = '" + update_company_id + "' ";
            int count = statement.executeUpdate(quary);


            // DELETE FROM factorys
            // WHERE COMPANY_ID = 'CAR-01' ;

            String delete_company_id = "CAR-01";
            quary= "DELETE FROM factorys " +
                    "WHERE COMPANY_ID = '" + delete_company_id + "' " ;
            count = statement.executeUpdate(quary);
            System.out.println();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println();
        // return 0;
    }
}
