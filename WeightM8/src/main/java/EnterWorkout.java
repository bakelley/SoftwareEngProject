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
@WebServlet("/EnterWorkout")
public class EnterWorkout extends HttpServlet {
    private static final long serialVersionUID = 1;

    String dns = "ec2-184-72-85-38.compute-1.amazonaws.com";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterWorkout() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String sql;
        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        String name = request.getParameter("Name");
        String phone = request.getParameter("Phone");
        String zip = request.getParameter("Zip");
        String gym = request.getParameter("Gym");
        String date = request.getParameter("Date");
        String time = request.getParameter("Time");
        String muscleGroup = request.getParameter("MuscleGroup"); 

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Activity Posted!";
        String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor = \"#f8d058\">\n" + //
            "<h1 align = \"center\">" + title + "</h1>\n");


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
        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
        System.out.println("Creating statement...");

        sql = "insert into w8m8 (name,phone,zip,gym,date,time,muscleGroup) values(?,?,?,?,?,?,?);";

        try {

            statement1 = connection.prepareStatement(sql);
            String userName = name;
            String userPhone = phone;
            String userZip = zip;
            String theGym = gym;
            String theDate = date;
            String theTime = time;
            String theActivity = muscleGroup; 
            statement1.setString(1, userName);
            statement1.setString(2, userPhone);
            statement1.setString(3, userZip);
            statement1.setString(4, theGym);
            statement1.setString(5, theDate);
            statement1.setString(6, theTime);
            statement1.setString(7, theActivity);
            

        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {

            statement1.executeUpdate();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        out.println("Thank you. Your activity has been posted");
        out.println("<p> </p>");
        out.println("<p>Post another workout<br><a href=\"NewWorkout.html\"><button>Post Workout</button></a></p>");
        out.println("<p></p><p>Search for Workouts to Join<br><a href=\"LocateWeightMate.html\"><button>Find Workout</button></a></p>");
        out.println("</body></html>");
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    

}