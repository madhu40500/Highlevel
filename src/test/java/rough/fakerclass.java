package rough;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.highlevel.utilities.Dpclassdata;

public class fakerclass {

	
	@Test(dataProvider = "teamDetails", dataProviderClass = Dpclassdata.class)
	void fake(Hashtable<String, String> data)
	{

		datarun(data);
	}
	
	void datarun(Hashtable<String,String> data)
	{
		System.out.println(data.get("Email"));
	}
	}	

