package jxsource.javademo.structuredata.report;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jxsource.javademo.structuredata.model.company.Info;

public class ReportPrinter {
	private PrintStream out;
	public ReportPrinter setPrintStream(PrintStream out) {
		this.out = out;
		return this;
	}
	public void printSummaryReport(SummaryReport report, String title) {
		out.println("---------- "+title+" ----------");
		SummaryData summary = report.summaryReport();
		for(Map.Entry<Object, Info> entry: summary.getSummary().entrySet()) {
			Info info = entry.getValue();
			out.format("%3d(%s): %15d(revenue) %15.2f(profit) %10d(employee)\n", entry.getKey(), summary.getCategory(), info.getRevenue(), info.getProfit(), info.getEmployee());
		}
		out.println();
	}
	private Map<String, Set<Integer>> sort(CEOReport report) {
		Map<String, Set<Integer>> map = new TreeMap<String, Set<Integer>>();
		List<CEOData> ceoDataList = report.ceoReport();
		Collections.sort(ceoDataList);
		for(CEOData ceoData: ceoDataList) {
			String ceo = ceoData.getCeo();
			Set<Integer> companies = map.get(ceo);
			if(companies == null) {
				companies = new HashSet<Integer>();
				map.put(ceo, companies);
			}
			companies.add(ceoData.getCompany());
		}
		return map;
	}
	public void printCEOReport(CEOReport report, String title) {
		Map<String, Set<Integer>> map = sort(report);
		out.println("---------- "+title+" ----------");
		for(String ceo: map.keySet()) {
			out.format("CEO: %s, Company(s): ", ceo);
			for(Integer company:map.get(ceo)) {
				out.format("%d ", company);
			}
			out.println();
		}
		out.println();
	}
	
	public void printCEOSummayReport(CEOReport report, String title) {
		out.println("---------- "+title+" ----------");
		Map<Integer, List<String>> countMap = new HashMap<Integer, List<String>>();
		Map<String, Set<Integer>> map = sort(report);
		for(Map.Entry<String, Set<Integer>> entry: map.entrySet()) {
			int companyCount = entry.getValue().size();
			List<String> ceoList = countMap.get(companyCount);
			if(ceoList == null) {
				ceoList = new ArrayList<String>();
			}
			ceoList.add(entry.getKey());
			countMap.put(companyCount,ceoList);
		}
		for(Map.Entry<Integer, List<String>> entry: countMap.entrySet()) {
			out.format("CEOs works for %d company(s): %s\n", entry.getKey(), entry.getValue());
		}
		out.println();
		
	}

} 
