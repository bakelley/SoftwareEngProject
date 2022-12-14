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

	String dns = "ec2-34-229-76-26.compute-1.amazonaws.com";

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
		// TODO Auto-generated method stub
		String sql;
		Connection connection = null;
		Statement statement = null;
		PreparedStatement statement1 = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String gym = request.getParameter("Gym");
		String activity = request.getParameter("Activity");
		String date = request.getParameter("Date");
		String time = request.getParameter("Time");
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
		System.out.println("Database query successful");
		System.out.println("");

		sql = FilterSearch.setSQL(date, time); 
		int numSearchTerms = FilterSearch.getSearchTerms(date, time); 
	
		String[] terms = {gym, activity, date, time};

		try {

			statement1 = connection.prepareStatement(sql);
			for(int i = 1; i <= numSearchTerms; i++)
			{
				if(terms[i-1]!= "")
				{		
					statement1.setString(i, terms[i-1]);
				}
				else
				{
					statement1.setString(i, terms[i]); 
				}
			}

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
				String ID = rs.getString("activityID");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String theGym = rs.getString("gym");
				String theDate = rs.getString("date");
				String theTime = rs.getString("time");
				String muscleGroup = rs.getString("muscleGroup");
				out.println("<tr><td>" + ID + "</td><td>" + name + "</td><td>" + phone + "</td><td>"
						+ theGym + "</td><td>" + theDate +  "</td><td>" + theTime +  "</td><td>" + muscleGroup + "</td></tr>");
			}
	        out.println("<p> </p>");
	        out.println("<p> </p>");
	        out.println("<p>Post a workout<br><a href=\"NewWorkout.html\"><button>Post Workout</button></a></p>");
	        out.println("<p>Or</p>");
	        out.println("<p></p><p>Search again<br><a href=\"LocateWeightMate.html\"><button>Find Workout</button></a></p>"
	        		+ "    <div class='footer'>Weight Mate 2022</div>"
	        		+ "</div>");
			out.println("</body></html>");
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