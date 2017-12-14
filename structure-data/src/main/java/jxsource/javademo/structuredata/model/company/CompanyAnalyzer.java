package jxsource.javademo.structuredata.model.company;

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

public class CompanyAnalyzer extends Model implements SummaryReport, CEOReport{
	private List<Company> companyList = new ArrayList<Company>();
	
	public List<Company> getCompanyList() {
		return companyList;
	}
	
	public void build() throws IOException {
		List<FlatData> listSrc = load();
		List<FlatData> listSort = new ArrayList<FlatData>(listSrc);
		Collections.sort(listSort, new CompanyComparator());
		int currentCompany = -99;
		int currentYear = -99;
		String currentCeo = null;
		Year currentYearObj = null;
		Company company = null;
		List<Year> currentYearList = null;
		List<Qtr> currentQtrList = null;
		for(FlatData flatData: listSort) {
			if(flatData.getCompany() != currentCompany) {
				currentYear = -99;
				currentCeo = null;
				company = new Company();
				company.setCompany(currentCompany = flatData.getCompany());
				company.setRegion(flatData.getRegion());
				company.setType(flatData.getType());
				currentYearList = new ArrayList<Year>();
				company.setYears(currentYearList);
				company.addCeo(currentCeo = flatData.getCeo(), flatData.getYear(), flatData.getQtr());
				companyList.add(company);
			}
			// there will be no duplicated records in company.ceos 
			// because its type is Set<String> 
			if(currentCeo != flatData.getCeo()) {
				company.addCeo(currentCeo = flatData.getCeo(), flatData.getYear(), flatData.getQtr());				
			}
			if(flatData.getYear() != currentYear) {
				currentYearObj = new Year();
				currentYearObj.setYear(currentYear = flatData.getYear());
				currentQtrList = new ArrayList<Qtr>();
				currentYearObj.setListQtr(currentQtrList);
				currentYearList.add(currentYearObj);
			}
			Qtr qtr = new Qtr();
			qtr.setQtr(flatData.getQtr());
			Info info = new Info();
			info.setEmployee(flatData.getEmployee());
			info.setProfit(flatData.getProfit());
			info.setRevenue(flatData.getRevenue());
			qtr.setInfo(info);
			currentQtrList.add(qtr);
		}
	}

	public SummaryData summaryReport() {
		Map<Object, Info> report = new TreeMap<Object, Info>();
		for(Company company: companyList) {
			float profit = 0;
			int employee = 0;
			long revenue = 0;
			int qtrs = 0;
			
			for(Year year: company.getYears()) {
				qtrs += year.getListQtr().size();
				for(Qtr qtr: year.getListQtr()) {
					profit += qtr.getInfo().getProfit();
					revenue += qtr.getInfo().getRevenue();
					employee += qtr.getInfo().getEmployee();
				}
			}
			Info info = new Info();
			if(qtrs > 0) {
				info.setEmployee(employee/qtrs);
			}
			info.setProfit(profit);
			info.setRevenue(revenue);
			report.put(company.getCompany(), info);
		}
		return new SummaryData().setSummary(report).setCategory("Company");
	}

	public List<CEOData> ceoReport() {
		List<CEOData> ceoList = new ArrayList<CEOData>();
		for(Company company: companyList) {
			for(CEO ceo: company.getCeos()) {
				ceoList.add(new CEOData(ceo.name, company.getCompany()));
			}
		}
		return ceoList;
	}

	@Override
	protected List<FlatData> getFlatDataList() {
		List<FlatData> fdList = new ArrayList<FlatData>();
		for(Company company: companyList) {
			for(Year year: company.getYears()) {
				for(Qtr qtr: year.getListQtr()) {
					Info info = qtr.getInfo();
					FlatData fd = new FlatData();
					fd.setCompany(company.getCompany());
					fd.setType(company.getType());
					fd.setRegion(company.getRegion());
					fd.setCeo(company.getCEO(year.getYear(), qtr.getQtr()));
					fd.setYear(year.getYear());
					fd.setQtr(qtr.getQtr());
					fd.setEmployee(info.getEmployee());
					fd.setProfit(info.getProfit());
					fd.setRevenue(info.getRevenue());
					fdList.add(fd);
				}
			}
		}
		return fdList;
	}
	public Company getCompany(int companyId) {
		for(Company company: companyList) {
			if(company.getCompany() == companyId) {
				return company;
			}
		}
		return null;
	}
}
