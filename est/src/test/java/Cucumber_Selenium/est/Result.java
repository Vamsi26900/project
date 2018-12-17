package Cucumber_Selenium.est;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	
	
	String PorF; String Lable;
	
	Result(String PorF, String Lable)
	{
		PorF = this.PorF;
		Lable = this.Lable;
		
	}

	public String getResult() {
		// TODO Auto-generated method stub
		return PorF;
	}

	public String getResultText() {
		// TODO Auto-generated method stub
		return Lable;
	}
	
	
}
