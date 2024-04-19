package generic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import CustomExceptions.CustomException;

public interface NLP {
	public void OpenBrowser();

	public void NavigateToUrl(String URL);

	public void NavigateToUrl();
	
	public WebDriver getDriver();
	// general
	public void Click(Object[] elementWithName);
	public void enterInputIntoElemenet(Object[] elementWithName,String value);
	public boolean isDisplayed(Object[] elementWithName);
	public void clearTextFromInputField(Object[] elementWithName);
	
	// action NLp
	public void scrollTtillElementVisible(Object[] elementWithName);

	// EXCEL NLPS
	public void createWorkBook(String filePath) throws Exception ;

	public Workbook getWrokBook();

	public String getDataAtCell(String sheetName, int row, int column) throws Exception;

	public int getColomnCount(Workbook workbook, String sheeetName, int row);
	public  ArrayList<String> getRowData(Workbook workbook,String SheeetName, int row) ;
	
	
	// LIST NLP
	public String getValueAtIndex(ArrayList<String> values, int i) throws CustomException;
	public String[] convertStringToList(String values, String c) ;

}
