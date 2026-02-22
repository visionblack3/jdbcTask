package com.idiot.jdbc;

/**
 * Hello world!
 */
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create Connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        // Create table
//        Statement st=con.createStatement();
//        st.execute("create table adobe(empcode int,empname varchar(33),empage int,empsal float)");
        //Insert values
        int index=0;
        int[] empCode={101,102,103,104,105};
        String[] empname={"Jenny","Jacky","Joe","John","Shameer"};
        int[] empage={25,30,20,40,25};
        float[] empsal={10000,20000,40000,80000,90000};
        PreparedStatement pst= con.prepareStatement("insert into adobe values(?,?,?,?)");
        while(index<empCode.length)
        {
            pst.setInt(1,empCode[index]);
            pst.setString(2,empname[index]);
            pst.setInt(3,empage[index]);
            pst.setFloat(4,empsal[index]);
            pst.execute();
            index++;
        }
        pst.close();
        con.close();
    }
}
