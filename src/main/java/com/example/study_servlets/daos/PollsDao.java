package com.example.study_servlets.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.study_servlets.commons.Commons;

public class PollsDao {
    public int Insert(HashMap<String, Object> map){
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "insert into statistics\n" + //
                    "(STATISTICS_ID, RESPONDENTS_ID, QUESTIONS_ID, CHOICE_ID)\n" + //
                    "values\n" ;//
                    
                    // print map
                    int loops = 1;
                    String userId = "R1";   // from session
                    
                    for(String key : map.keySet()){
                        String uuid = commons.generateUUID();
                        if(loops > 1){
                            query = query + ", ";
                        }
                    query = query + "('"+uuid+"', '"+userId+"', '"+key+"', '"+map.get(key)+"')\n" ;
                    loops = loops + 1;
                }
                query = query + ";\n" ;
                count = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    

     public ArrayList SelectWithSearch(String search) { //메서드의 리턴타입 확인할 수 있음 (arraylist)
        ArrayList InforList = new ArrayList<>();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // Editor in Workbanch
            String query = "SELECT T_QC.QUESTIONS_ID, T_QC.CHOICE_ID, T_Q.QUESTIONS, T_C.CHOICE\n" + //
                    "FROM question_choice AS T_QC\n" + //
                    "\tINNER JOIN questions AS T_Q\n" + //
                    "    ON T_QC.QUESTIONS_ID = T_Q.QUESTIONS_ID\n" + //
                    "    INNER JOIN choice AS T_C\n" + //
                    "    ON T_QC.CHOICE_ID = T_C.CHOICE_ID\n" + //
                    "ORDER BY T_QC.QUESTIONS_ID, T_QC.CHOICE_ID;";
            ResultSet resultSet = statement.executeQuery(query);  //resultSet 으로 결과값이 오는데 사용할 수 없으므로 HashMap에 담아준다

            HashMap InforRecord = new HashMap<>();
            while (resultSet.next()) {
                InforRecord = new HashMap<>();
                InforRecord.put("QUESTIONS_ID", resultSet.getString("QUESTIONS_ID"));
                InforRecord.put("CHOICE_ID", resultSet.getString("CHOICE_ID"));
                InforRecord.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                InforRecord.put("CHOICE", resultSet.getString("CHOICE"));


                InforList.add(InforRecord);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return InforList;
    }
}

// SelectWithSearch는 arraylist형태로 값을 던져준다. 압축파일을 던져준다고 생각하자
// 그럼 이 메서드를 받은 class에서는 압축된 list를 풀어줘야 하는 것이다.
// 메서드는 리턴을 하는데 InforList가 어떤 타입인지 모르기 때문에 메서드의 리턴타입이 무엇인지 확인할 것!