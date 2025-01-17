package com.nt.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.entity.CitizenPlan;
import com.nt.repository.ICitizenPlanRepository;
import com.nt.searchrequest.SearchRequest;
import com.nt.util.ExcelUtil;
import com.nt.util.PdfUtil;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private ICitizenPlanRepository planRepo;
	@Autowired
	private ExcelUtil excel;
	@Autowired
	private PdfUtil pdf;

	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan cp = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName()))
			cp.setPlanName(request.getPlanName());

		if (null != request.getGender() && "" != request.getGender())
			cp.setGender(request.getGender());

		if (null != request.getPlanStatus() && "" != request.getPlanStatus())
			cp.setPlanStatus(request.getPlanStatus());

		if (null != request.getStartDate() && "" != request.getStartDate())
			cp.setStartDate(LocalDate.parse(request.getStartDate()));

		if (null != request.getEndDate() && "" != request.getEndDate())
			cp.setEndDate(LocalDate.parse(request.getEndDate()));

		System.out.println(cp);
		return planRepo.findAll(Example.of(cp));

	}

	@Override
	public boolean generateExcel(HttpServletResponse response) throws IOException {
		excel.generateExcel(response,planRepo.findAll());
		return false;
	}
	@Override
	public boolean generatePdf(HttpServletResponse response) throws Exception {
		pdf.generatePdf(response, planRepo.findAll());
		return false;
	}

}
