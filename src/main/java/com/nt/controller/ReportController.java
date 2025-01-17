package com.nt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.searchrequest.SearchRequest;
import com.nt.service.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	@Autowired
	private ReportServiceImpl reportService;


	@GetMapping("/")
	public String indexpage(Model model) {
		model.addAttribute("search", new SearchRequest());
		sendModel(model);
		return "index";
	}

	private void sendModel(Model model) {
		// model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", reportService.getPlanNames());
		model.addAttribute("status", reportService.getPlanStatus());
	}

	@PostMapping("/search")
	public String search(@ModelAttribute("search") SearchRequest sr, Model model) {
		sendModel(model);
		System.out.println(sr);
		// System.out.println(reportService.search(sr));
		model.addAttribute("plans", reportService.search(sr));
		return "index";
	}
	

	@GetMapping("/excel")
	public void excelDownload(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition", "attachment;filename=Plans.xls");
		reportService.generateExcel(response);
	}

	@GetMapping("/pdf")
	public void pdfDownload(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("content-Disposition", "attachment;filename=Plans.pdf");
		reportService.generatePdf(response);
	}

}
