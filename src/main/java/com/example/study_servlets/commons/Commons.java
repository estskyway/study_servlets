package com.example.study_servlets.commons;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Commons {

        public Statement getStatement(){
        String url = "jdbc:mysql://192.168.0.51:3306/db_survey";
        String user = "yojulab";
        String password = "!yojulab*";

        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

        public String getGeneratorID(){
        Date date = new Date(0);  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");  
        String strDate = formatter.format(date);
        return strDate;
    }
        public String generateUUID() {
        return UUID.randomUUID().toString();

    }
}

