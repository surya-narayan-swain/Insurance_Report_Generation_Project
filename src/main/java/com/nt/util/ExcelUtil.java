package com.nt.util;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.nt.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelUtil {

	public boolean generateExcel(HttpServletResponse response,List<CitizenPlan> plans) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Devraj");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Holder Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Start Date");
		headerRow.createCell(5).setCellValue("End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");
		
		int dataRowIndex=1;
		for(CitizenPlan plan : plans) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(dataRowIndex);
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			dataRow.createCell(4).setCellValue(plan.getStartDate()+"");
			dataRow.createCell(5).setCellValue(plan.getEndDate()+"");
			if(null!=plan.getBenefitAmount())
			dataRow.createCell(6).setCellValue(plan.getBenefitAmount());
			dataRowIndex++;
		}
		workbook.write(response.getOutputStream());
		workbook.close();
		//File file=new File("Plans.xls");
		return true;
	}
}














