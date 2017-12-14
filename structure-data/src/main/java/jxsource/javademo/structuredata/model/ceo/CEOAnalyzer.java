package jxsource.javademo.structuredata.model.ceo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jxsource.javademo.structuredata.model.FlatData;
import jxsource.javademo.structuredata.model.Model;
import jxsource.javademo.structuredata.report.SummaryReport;
import jxsource.javademo.structuredata.report.CEOData;
import jxsource.javademo.structuredata.report.CEOReport;
import jxsource.javademo.structuredata.report.SummaryData;

public class CEOAnalyzer extends Model implements CEOReport{
	private List<CEO> ceoList = new ArrayList<CEO>();
	
	public List<CEO> getCompanyList() {
		return ceoList;
	}
	
	public void build() throws IOException {
		List<FlatData> listSrc = load();
		List<FlatData> listSort = new ArrayList<FlatData>(listSrc);
		Collections.sort(listSort, new CEOComparator());
		int companyId = -99;
		int prevYear = -99;
		int prevQtr = -99;
		CEO currentCeo = null;
		for(FlatData flatData: listSort) {
			if(!flatData.getCeo().equals(currentCeo)) {
				ceoList.add(currentCeo = new CEO());
				currentCeo.setName(flatData.getCeo());
				companyId = -99;
				prevYear = -99;
				prevQtr = -99;
			}
			if(companyId != flatData.getCompany()) {
				// companyId is for previous company
				Company company = currentCeo.getCompany(companyId);
				if(company != null) {
					company.setEndYear(prevYear)
						.setEndQtr(prevQtr);
				}
				// change companyId to new Company
				companyId = flatData.getCompany();
				company = currentCeo.createCompany(companyId)
						.setStartYear(flatData.getYear())
						.setStartQtr(flatData.getQtr());
			}
			prevYear = flatData.getYear();
			prevQtr = flatData.getQtr();
		}
	}


	public List<CEOData> ceoReport() {
		List<CEOData> ceoList = new ArrayList<CEOData>();
		// Note the difference between ceoList and this.ceoList
		for(CEO ceo: this.ceoList) {
			for(Company company: ceo.getCompanies()) {
				ceoList.add(new CEOData(ceo.getName(), company.getCompany()));
			}
		}
		return ceoList;
	}

	@Override
	protected List<FlatData> getFlatDataList() {
		throw new RuntimeException("CEOAanlyzer does not support getFlatDataList() method.");
	}
}
