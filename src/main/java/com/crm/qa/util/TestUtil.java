package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public TestUtil() throws IOException {
		super();
	}

	public static String TEST_DATA_SHEETPATH = "C:\\Users\\2905p\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Logintest.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(TEST_DATA_SHEETPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			//book = WorkbookFactory.create(fis);
             book=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenshotATEndOfTest() throws IOException {
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir =System.getProperty("user.dir");
		FileUtils.copyFile(file, new File(currentDir + "/screenshots"+ System.currentTimeMillis()+".png"));
		
	}
}
