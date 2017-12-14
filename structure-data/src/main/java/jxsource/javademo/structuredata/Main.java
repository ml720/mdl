package jxsource.javademo.structuredata;

import java.io.IOException;
import java.util.List;

import jxsource.javademo.structuredata.model.FlatData;
import jxsource.javademo.structuredata.model.Model;
import jxsource.javademo.structuredata.model.ceo.CEOAnalyzer;
import jxsource.javademo.structuredata.model.company.Company;
import jxsource.javademo.structuredata.model.company.CompanyAnalyzer;
import jxsource.javademo.structuredata.model.timeseries.TimeSeries;
import jxsource.javademo.structuredata.report.ReportPrinter;
import jxsource.javademo.structuredata.util.CEOGenerator;

public class Main {
	public static void main(String[] args) {
		try {
			ReportPrinter printer = new ReportPrinter().setPrintStream(System.out);
			CompanyAnalyzer companyAnalyzer = new CompanyAnalyzer();
			companyAnalyzer.build();
			printer.printSummaryReport(companyAnalyzer, "Company Summary Report");
			printer.printCEOReport(companyAnalyzer, "Company CEO Report");
			TimeSeries timeSeries = new TimeSeries();
			timeSeries.build();
			printer.printSummaryReport(timeSeries, "Year Summary Report");
			CEOAnalyzer ceoAnalyzer = new CEOAnalyzer();
			ceoAnalyzer.build();
			printer.printCEOSummayReport(ceoAnalyzer, "CEO Summary Report");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
