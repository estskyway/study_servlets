package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlets.commons.Commons;

public class OptionInforsDao {
    public int UpdateWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "update option_infors\n" + //
                    "set OPTION_NAME = '회전기어'\n" + //
                    "where OPTION_INFOR_ID = 'OI001';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int InsertWithUniqueID(String Unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "insert into option_infors\n" + //
                    "(OPTION_INFOR_ID, OPTION_NAME)\n" + //
                    "values\n" + //
                    "('"+commons.generateUUID()+"', '전진기어');";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "delete from option_infors\n" + //
                    "where OPTION_INFOR_ID = '" + unique_id + "';";
            count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInforList = new ArrayList<>();
        try {
            if (search == null) {
                search = "";
            }
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "SELECT *\n" + //
                    "FROM option_infors \n" + //
                    "WHERE OPTION_NAME like '" + search + "%';";
            ResultSet resultset = statement.executeQuery(query);

            HashMap optionInforRecord = new HashMap<>();
            while (resultset.next()) {
                optionInforRecord = new HashMap<>();
                optionInforRecord.put("OPTION_INFOR_ID", resultset.getString("OPTION_INFOR_ID"));
                optionInforRecord.put("OPTION_NAME", resultset.getString("OPTION_NAME"));

                optionInforList.add(optionInforRecord);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforList;
    }
}
