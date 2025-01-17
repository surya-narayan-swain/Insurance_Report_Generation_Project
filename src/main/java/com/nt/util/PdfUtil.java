package com.nt.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfUtil {
	public boolean generatePdf(HttpServletResponse response, List<CitizenPlan> plans) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Paragraph p = new Paragraph("Citizen Plans Info");
		document.add(p);
		PdfPTable table = new PdfPTable(8);
		table.addCell("ID");
		table.addCell("Holder Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Gender");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amount");
		int index = 1;
		for (CitizenPlan plan : plans) {
			table.addCell(index + "");
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getGender());
			table.addCell(plan.getStartDate() + "");
			table.addCell(plan.getEndDate() + "");
			table.addCell(plan.getBenefitAmount() + "");
			index++;
		}
		document.add(table);
		document.close();
		return true;
	}
}
