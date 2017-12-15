package jxsource.javademo.structuredata;

import java.io.IOException;

import jxsource.javademo.structuredata.report.ReportPrinter;

public class Main {
	public static void main(String[] args) {
		try {
			ReportPrinter printer = new ReportPrinter().setPrintStream(System.out);
			jxsource.javademo.structuredata.model.company.Analyzer companyAnalyzer 
				= new jxsource.javademo.structuredata.model.company.Analyzer();
			companyAnalyzer.build();
			printer.printSummaryReport(companyAnalyzer, "Company Summary Report");
			printer.printCEOReport(companyAnalyzer, "Company CEO Report");
			jxsource.javademo.structuredata.model.timeseries.Analyzer timeSeries 
				= new jxsource.javademo.structuredata.model.timeseries.Analyzer();
			timeSeries.build();
			printer.printSummaryReport(timeSeries, "Year Summary Report");
			jxsource.javademo.structuredata.model.ceo.Analyzer ceoAnalyzer 
				= new jxsource.javademo.structuredata.model.ceo.Analyzer();
			ceoAnalyzer.build();
			printer.printCEOSummayReport(ceoAnalyzer, "CEO Summary Report");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
