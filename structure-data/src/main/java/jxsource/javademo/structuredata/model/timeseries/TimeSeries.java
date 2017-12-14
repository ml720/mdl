package jxsource.javademo.structuredata.model.timeseries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jxsource.javademo.structuredata.model.FlatData;
import jxsource.javademo.structuredata.model.Model;
import jxsource.javademo.structuredata.model.company.Info;
import jxsource.javademo.structuredata.model.company.Qtr;
import jxsource.javademo.structuredata.report.SummaryReport;
import jxsource.javademo.structuredata.report.SummaryData;

public class TimeSeries extends Model implements SummaryReport{
	private List<Year> yearList = new ArrayList<Year>();
	public void build() throws IOException {
		List<FlatData> listSrc = load();
		List<FlatData> listSort = new ArrayList<FlatData>(listSrc);
		Collections.sort(listSort, new TimeComparator());
		int currentCompany = -99;
		int currentYear = -99;
		int qtrs = 0;
		Company currentCompanyObj = null;
		List<Company> currentCompanyList = null;
		List<Year> currentYearList = null;
		Info info = null;
		for(FlatData flatData: listSort) {
			if(flatData.getYear() != currentYear) {
				Year year = new Year();
				year.setYear(currentYear = flatData.getYear());
				currentCompanyList = new ArrayList<Company>();		
				year.setListCompany(currentCompanyList);
				yearList.add(year);
			}
			if(flatData.getCompany() != currentCompany) {
				currentCompanyObj = new Company();
				currentCompanyObj.setCompany(currentCompany = flatData.getCompany());
				currentCompanyObj.setRegion(flatData.getRegion());
				currentCompanyObj.setType(flatData.getType());
				currentCompanyObj.setCeo(flatData.getCeo());
				if(info != null) {
					// skip for the first company
					info.setEmployee(info.getEmployee()/qtrs);
				}
				info = new Info();
				currentCompanyObj.setInfo(info);
				currentCompanyList.add(currentCompanyObj);
				// reset qtrs
				qtrs = 0;
			}
			qtrs++;
			info.setProfit(info.getProfit()+flatData.getProfit());
			info.setRevenue(info.getRevenue()+flatData.getRevenue());
			info.setEmployee(info.getEmployee()+flatData.getEmployee());
		}
		// average employee for the last company
		info.setEmployee(info.getEmployee()/qtrs); 
	}

	public SummaryData summaryReport() {
		Map<Object, Info> report = new TreeMap<Object, Info>();
		for(Year year: yearList) {
			float profit = 0;
			int employee = 0;
			long revenue = 0;
			
			for(Company company: year.getListCompany()) {
				profit += company.getInfo().getProfit();
				revenue += company.getInfo().getRevenue();
				employee += company.getInfo().getEmployee();
			}
			Info info = new Info();
			info.setEmployee(employee);
			info.setProfit(profit);
			info.setRevenue(revenue);
			report.put(year.getYear(), info);
		}
		return new SummaryData().setSummary(report).setCategory("Year");
	}

	@Override
	protected List<FlatData> getFlatDataList() {
		// TODO Auto-generated method stub
		return null;
	}

}
