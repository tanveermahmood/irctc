package domestictest;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.air_irctc.DomesticTestPage;
import com.air_irctc.GmailTestPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class Xml_readTest extends WebDriverTestCase
{
	/*@BeforeTest()
	public void scenario4() throws InterruptedException {
		GmailTestPage gm = new GmailTestPage();
		gm.launchPage(null);
	}
	
	@DataProvider(name="branchdata")
	public Object[][] domesticForm()
	{
		
		return Excel_loap.getExcelContents("data.xlsx","data");
	}
	
	
	@Test(priority=1,dataProvider="branchdata")
	public void verifyDomesticForm() throws InterruptedException
	{
		Domestic_Scenario df = new Domestic_Scenario();
		df.scenario1();
	}*/
	@QAFDataProvider(key="search.data")
	@Test(groups = { "SMOKE" }, description = "fill domestic form")
	public void scenario2(Map<String, String> data) throws InterruptedException {
		DomesticTestPage df = new DomesticTestPage();
		Generic1 generic1=new Generic1(getDriver());
		df.launchPage(null);
		generic1.kw_click_link(df.getRadioOneWay());
		generic1.kw_enter_text(df.getTextOrigin(), data.get("from"));
		generic1.kw_moveToElement(df.getOrigin_value());
		generic1.kw_enter_text(df.getTextDestination(), data.get("to"));
		generic1.kw_moveToElement(df.getDestination_value());
		Thread.sleep(3000);
		df.getCalender().click();
		df.getDate().click();
		/*QAFWebElement fname = new QAFExtendedWebElement("select.child");
		Select s = new Select(fname); 
		s.selectByIndex(2);*/
		generic1.kw_dropdown(df.getSelectAdult(), 2);
		generic1.kw_dropdown(df.getSelectChild(), 1);
		generic1.kw_dropdown(df.getSelectInfant(), 3);
		generic1.kw_dropdown(df.getSelectClass(), 2);
		generic1.kw_dropdown(df.getSelectPreference(),2);
		df.getSearch();
	}
}