package jxsource.javademo.structuredata.model.timeseries;

import java.util.List;

import jxsource.javademo.structuredata.model.timeseries.Company;

public class Year {
	private int year;
	private List<Company> listCompany;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Company> getListCompany() {
		return listCompany;
	}
	public void setListCompany(List<Company> listCompany) {
		this.listCompany = listCompany;
	}
	
}
