package com.example.study_servlets.controlls;

import java.io.IOException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.51:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String quary = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(quary);
            while(resultSet.next()){
               
                System.out.println( 
                resultSet.getString("COMPANY_ID")
                +resultSet.getString("COMPANY"));
            }

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
