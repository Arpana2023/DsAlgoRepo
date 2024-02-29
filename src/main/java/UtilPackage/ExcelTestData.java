package UtilPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData 
{
	public static void writeExcelSheetData() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet workbook1 = workbook.createSheet("Credentials");
		XSSFSheet workbook2 = workbook.createSheet("Register");
		XSSFSheet workbook3 = workbook.createSheet("Pythoncode Sheet");
		//String path = System.getProperty("user.dir")+"/src/test/resources/ExcelSheetData/DSAlgo_LoginTestng.xlsx";
		String path = System.getProperty("user.dir")+ Constants.excelPath;

		File Excelfile = new File(path);
		FileOutputStream Fos = null;
		try
		{
			Fos = new FileOutputStream(Excelfile);
			workbook.write(Fos);
			workbook.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			Fos.close();
		}
	}
	public static void readExcelSheetValue() throws IOException
	{
		//String path = System.getProperty("user.dir")+"/src/test/resources/ExcelSheetData/DSAlgo_LoginTestng.xlsx";
		String path = System.getProperty("user.dir")+Constants.excelPath;
		File Excelfile = new File(path);
		FileInputStream Fis = new FileInputStream(Excelfile);//creating object of FileInputStream to read data
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);//creating a workbook instance(.xlsx file)
		XSSFSheet sheet = workbook.getSheet("Pythoncode Sheet");
			
		Iterator<Row> row = sheet.rowIterator();
		while(row.hasNext())
		{
			Row currRow = row.next();
			Iterator<Cell> cell =currRow.cellIterator();
				
			while(cell.hasNext())
			{
				Cell currCell = cell.next();
				System.out.println(currCell.getStringCellValue() +  " ~ ");
			}
			System.out.println();
		}
		FileOutputStream Fos = new FileOutputStream(Excelfile);//creating object of FileOutputStream to write data
		workbook.write(Fos);
		workbook.close();
	}
	public static Object[][] getDataFromSheet(String workbookLocation, String workSheetName) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/" + workbookLocation);
		XSSFSheet worksheet = workbook.getSheet(workSheetName);
		int noOfRows = worksheet.getLastRowNum();
		int noOfColumns = worksheet.getRow(0).getLastCellNum();
			
		Object[][] dataTable = new Object[noOfRows][noOfColumns];
		for(int i=0; i< noOfRows;i++)
		{
			for(int j=0; j< noOfColumns;j++)
			{
				dataTable[i][j] = worksheet.getRow(i+1).getCell(j).toString();
			}
		}
		workbook.close();
		return dataTable;
	}
	public static void main(String[] args) throws IOException 
	{
		writeExcelSheetData();
		//readExcelSheetValue();
	}
}

