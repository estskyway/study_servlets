package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.FactorysDao;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // 클라이언트에 html 화면 제공
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>bootstrap_tables</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "\r\n" + //
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
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n"; //

            // - query Edit
            FactorysDao factorysDao = new FactorysDao();
            ArrayList factoryList = new ArrayList<>();
            factoryList = factorysDao.selectAll();
            for (int i = 0; i < factoryList.size(); i = i + 1) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) factoryList.get(i);
                contents = contents + "<tr>\r\n " + //
                        " <td>" + hashMap.get("COMPANY_ID") + "</td>\r\n" + //
                        " <td>" + hashMap.get("COMPANY") + "</td>\r\n" + //
                        " </tr>\r\n"; // ";
            }
            contents = contents + "</tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";

            // 클라이언트에 html 화면 제공
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();

            // SELECT COUNT(*) AS CNT FROM factorys;
            // query = "SELECT COUNT(*) AS CNT FROM factorys";
            // resultSet = statement.executeQuery(query);
            // resultSet.next();
            // int totalCount = 0;
            // while (resultSet.next()) {
            // System.out.println(resultSet.getInt("CNT"));
            // totalCount = resultSet.getInt("CNT");
            // } // while문 없어도 작동하지만 그래도 통일성 있게 주는거임

            // INSERT INTO factorys
            // (COMPANY_ID, COMPANY)
            // VALUE
            // ('CAR-01', 'AUDI') ; 테이블 없이 아웃풋 나옴
            // 변수로 만들어주고 query에 넣는게 좋음. 쿼리 뒤에 띄어쓰기 한번씩 하기

            // String companyId = "CAR-01";
            // String company = "AUDI";
            // //query = "INSERT INTO factorys " +
            // "(COMPANY_ID, COMPANY) " +
            // " VALUE " +
            // "('" + companyId + "', '" + company + "') ";

            // int count = statement.executeUpdate(query); // intert update delete는
            // executeupdate쓴다. select문
            // 빼고.

            // update factorys
            // SET COMPANY = '패러리'
            // WHERE COMPANY_ID = 'CAR-01' ;

            // companyId = "CAR-01";
            // company = "패러리";

            // query = "UPDATE factorys " +
            // "SET COMPANY = ('" + company + "') " +
            // "WHERE COMPANY_ID = ('" + companyId + "') ";

            // count = statement.executeUpdate(query);

            // DELETE FROM factorys
            // WHERE COMPANY_ID = 'CAR-01'

            // companyId = "CAR-01";

            // query = "DELETE FROM factorys " +
            // "WHERE COMPANY_ID = ('" + companyId + "') ";

            // count = statement.executeUpdate(query);

            // System.out.println();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}