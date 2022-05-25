package base.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class baseStudents extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:6666/postgres", "postgres", "3353");
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,firstname,lastname,grupa,datee FROM student");

            while(rs.next()){
                writer.print(rs.getString("id"));
                writer.print(rs.getString("firstname"));
                writer.print(rs.getString("lastname"));
                writer.print(rs.getString("grupa"));
                writer.println(rs.getString("datee"));

            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students.db", "postgres", "3353");
//            Statement statement = connect.createStatement();
//            ResultSet rs = statement.executeQuery(" INSERT INTO student (firstname, lastname, grupa,datee)\n" +
//                    "VALUES ('John','Smith','147','02.08.2000')");
//            while(rs.next())
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
}
