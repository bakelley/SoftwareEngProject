
public class FilterSearch {


	public static String setSQL(String date, String time) 
	{
		String sql = ""; 
		//Logic to process fields searched by user
		if(date == "" && time == "")//if user only enters gym and activity
		{
			sql = "SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=?;";

		}
		else if(date == "" && time != "")//if user enters gym, activity, and time
		{
			sql = "SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND time=?";

		}
		else if(date != "" && time == "")//if user enters gym, activity, and date
		{
			sql = "SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND date=?";

		}
		else if(date != "" && time != "")//user enters date, time, gym, and activity
		{
			sql = "SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND date=? AND time=?";

			
		}
		return sql; 
	}
	
	
	public static int getSearchTerms(String date, String time)
	{
		int num = 2; //default 2 search terms
	
		if((date != "" && time == "") || (date == "" && time != ""))//three search terms
		{
			num = 3; 
		}
		else if(date != "" && time != "")//four search terms
		{
			num = 4; 
		}
		
		return num; 
	}
	

}