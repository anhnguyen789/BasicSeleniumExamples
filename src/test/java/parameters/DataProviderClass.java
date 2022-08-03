package parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="SearchProvider")
	public static Object[][] getDataFromProvider(){
		return new Object[][] {
			{"user a","India"},
			{"user b","UK"},
			{"user c","USA"}
		};
				
	}

}
