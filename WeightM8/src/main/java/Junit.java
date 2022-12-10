

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test; 

class Junit
{
	  
	@Test                                               
	@DisplayName("SQL: Date Empty - time provided")   
	void sqlNoDateEntered() {

		String Date ="";
		String Time ="8:30";
		String sql = FilterSearch.setSQL(Date, Time); 
		assertTrue(sql.equals("SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND time=?"));
	}
	
	@Test                                               
	@DisplayName("SQL: Time Empty - date provided")   
	void sqlNoTimeEntered() {

		String Date ="12/9/2022";
		String Time ="";
		String sql = FilterSearch.setSQL(Date, Time); 
		assertTrue(sql.equals("SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND date=?"));
	}
	
	
	@Test                                               
	@DisplayName("SQL: Time and Date Empty")   
	void sqlNoTimeOrDate() {

		String Date ="";
		String Time ="";
		String sql = FilterSearch.setSQL(Date, Time); 
		assertTrue(sql.equals("SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=?;"));
	}
	
	
	@Test                                               
	@DisplayName("SQL: Time and Date provided")   
	void sqlTimeAndDateSupplied() {

		String Date ="12/9/2022";
		String Time ="1:30";
		String sql = FilterSearch.setSQL(Date, Time); 
		assertTrue(sql.equals("SELECT * FROM w8m8 WHERE gym=? AND muscleGroup=? AND date=? AND time=?"));
	}
	
	
	
	@Test                                               
	@DisplayName("NumTerms: Date Empty - Time provided")   
	void noDateEntered() {

		String Date ="";
		String Time ="8:30";
		assertEquals(3, FilterSearch.getSearchTerms(Date, Time)); 
	}
	
	@Test                                               
	@DisplayName("NumTerms: Time Empty - date provided")   
	void noTimeEntered() {

		String Date ="12/9/2022";
		String Time ="";
		assertEquals(3, FilterSearch.getSearchTerms(Date, Time)); 
	}
	
	
	@Test                                               
	@DisplayName("NumTerms: Time and Date Empty")   
	void noTimeOrDate() {

		String Date ="";
		String Time ="";
		assertEquals(2, FilterSearch.getSearchTerms(Date, Time)); 
	}
	
	
	@Test                                               
	@DisplayName("NumTerms: Time and Date Provided")   
	void timeAndDateSupplied() {

		String Date ="12/9/2022";
		String Time ="1:30";
		assertEquals(4, FilterSearch.getSearchTerms(Date, Time)); 
	}
	
	
	



}