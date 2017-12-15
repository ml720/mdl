package jxsource.javademo.structuredata.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jxsource.javademo.structuredata.model.FlatData;
import jxsource.javademo.structuredata.model.company.CEO;
import jxsource.javademo.structuredata.model.company.Company;
import jxsource.javademo.structuredata.model.company.Analyzer;
import jxsource.javademo.structuredata.model.company.FlatDataComparator;
import jxsource.javademo.structuredata.report.ReportPrinter;

public class CEOGenerator extends Analyzer {

	public List<FlatData> addCEO() throws IOException {
		build();
		Collections.sort(this.getCompanyList());
		for(Company company: this.getCompanyList()) {
			company.addCeo("CEO-"+company.getCompany(),
					company.getYears().get(0).getYear(),
					company.getYears().get(0).getListQtr().get(0).getQtr());
		}
		return this.getFlatDataList();
	}
	public static void main(String[] args) {
		try {
			CEOGenerator ceoGen = new CEOGenerator();
			List<FlatData> ceoList = ceoGen.addCEO();
			ReportPrinter printer = new ReportPrinter().setPrintStream(System.out);
			printer.printCEOReport(ceoGen, "CEO Report");
			FlatData.save(ceoList, "src/main/resources/ceo.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
