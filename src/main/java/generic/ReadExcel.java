package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import static extentReporter.ExtentLogger.*;

public class ReadExcel implements FrameworkConstants{
	public static Workbook workbook;
	
	public  Workbook getWrokBook() {
		return  workbook;
	}
	public  void createWorkBook(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fis);
	}
	public  String getDataAtCell(String sheetName ,int row,int column) throws EncryptedDocumentException, IOException {
		
		String data=null;
		try {
			data = workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
			pass(data +" is retrived from the work book with given sheetname :"+sheetName+"  row : "+row+" column :"+column);
		} catch (Exception e) {
			fail(" failed retrived from the work book with given sheetname :"+sheetName+"  row : "+row+" column :"+column +"  "+ e.toString());
		}
		
		
		return data;
	}
	public  ArrayList<String> getRowData(Workbook workbook,String SheeetName, int row) {
		int countOfCells=getColomnCount(workbook,SheeetName, row);
		ArrayList<String> values=new ArrayList<String>();
		Row rowVal = workbook.getSheet(SheeetName).getRow(row);
		DataFormatter format=new DataFormatter();
		for(int i=0;i<countOfCells;i++) {
			String value ="";
			try {
				Cell cell = rowVal.getCell(i);
				if(i==5) {// this will fetch the numeric values also into the numebr formate
					
					 value=format.formatCellValue(cell);
					values.add(value);
					
				}
			
				else {
					value= rowVal.getCell(i).toString();
				values.add(value);
				}
				//System.out.println(i+"="+value);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				values.add("null");
			}
		}
		pass("Excel data fetched from the sheet "+SheeetName+" at row index is : "+row+" "+ values);
		return values;
	}
	public  int getColomnCount(Workbook workbook,String sheeetName, int row) {
		return (workbook.getSheet(EXCEL_SHEETNAME).getRow(0).getPhysicalNumberOfCells());
	}
	public String getData(String filePath,String sheetName,int row,int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public static Object[][] getMultipleData(String filePath,String sheetName,int start,int end) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(filePath);
		System.out.println(filePath);
		workbook = WorkbookFactory.create(fis);
		int row_count = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		System.out.println("row"+row_count);
		int col_count=workbook.getSheet(sheetName).getRow(row_count-1).getPhysicalNumberOfCells();
		System.out.println(col_count);
		
		Object[][] data=new Object[end-start+1][col_count];
		for(int r=start, i=0;r<=end;r++) {
			 Row row = workbook.getSheet(sheetName).getRow(r);
			 
			for(int c=0;c<row.getPhysicalNumberOfCells();c++) {
				data[i][c]=row.getCell(c).getRichStringCellValue();
				//System.out.println(i+" "+c+" "+data[i][c]);
				i++;
			}
		}
		//System.out.println("end loop");
		return data;
	}

}
