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

        String name = req.getParameter("firstname");
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
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:6666/postgres", "postgres", "3353")){

                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT INTO student (firstname, lastname, grupa,datee) VALUES ('iPhone X', 'wwd',1, '12-10-25')," +
                        "('Galaxy S9', '45000',1,'12-10-25')");
                System.out.printf("Added %d rows", rows);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }



    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:6666/postgres", "postgres", "3353")){

                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT student (firstname, lastname, grupa,datee) VALUES ('iPhone X', 'wwd','iPhone X', 'wwd')," +
                        "('Galaxy S9', '45000','dasd','dasdas')");
                System.out.printf("Added %d rows", rows);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }




    }
}
