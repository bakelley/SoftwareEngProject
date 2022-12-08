import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Fetch data
/**
 * Servlet implementation class demo3
 */
@WebServlet("/FindM8")
public class FindM8 extends HttpServlet {
    private static final long serialVersionUID = 1 ;

    String dns = "ec2-54-89-167-130.compute-1.amazonaws.com";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindM8() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql;
        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        String keyword = request.getParameter("keyword");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "WORKOUT SEARCH RESULTS";
        String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title>"
            		+ "<link rel=\"stylesheet\" href=\"styles.css\">"
            		+ "</head>\n" + //
            "<body>\n" + //
            "<	<div class=\"title\">Weight Mate</div>\r\n"
            + "	<header>\r\n"
            + "		<nav>\r\n"
            + "			<a href=\"Welcome.html\">Home Page</a>\r\n"
            + "			<a href=\"LocateWeightMate.html\">Find Mate</a>\r\n"
            + "			<a href=\"NewWorkout.html\">Create Workout</a>\r\n"
            + "		</nav>\r\n"
            + "	</header><br>"
            + " <div class='content'>");


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dns + ":3306/test", "admin", "admin");
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            System.out.println("Connection Failed!:\n" + e2.getMessage());
        }
        System.out.println("SUCCESS!!!! You made it, take control of your database now!");
        System.out.println("Creating statement...");

        sql = "SELECT * FROM w8m8 WHERE gym=?";
        try {

            statement1 = connection.prepareStatement(sql);
            //String theUserName = keyword;
            //statement1.setString(1, theUserName);
     
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {

            rs = statement1.executeQuery();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        out.println("<table border=1 width=100% height=20%>");
        out.println("<tr><th>Workout ID</th><th>Name</th><th>Phone</th><th>Gym</th><th>Date</th><th>Time</th><th>Muscle Group</th>");
        try {
            while (rs.next()) {
                //Retrieve by column name
                String call = rs.getString("activityID");
                String booktitle = rs.getString("name");
                String author = rs.getString("phone");
                String genre = rs.getString("gym");
                String isbn = rs.getString("date");
                String summary = rs.getString("time");
                String muscleGroup = rs.getString("muscleGroup");
                out.println("<tr><td>" + call + "</td><td>" + booktitle + "</td><td>" + author + "</td><td>" 
                + genre + "</td><td>" + isbn +  "</td><td>" + summary +  "</td><td>" + muscleGroup + "</td></tr>");
            }
            out.println("</div></body></html>");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}