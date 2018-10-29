package jxsource.javademo.structuredata.model.ceo;

public class Company {
	private int company;
	private int startYear; 
	private int startQtr; 
	private int endYear;
	private int endQtr;
	public int getCompany() {
		return company;
	}
	public Company setCompany(int company) {
		this.company = company;
		return this;
	}
	public int getStartYear() {
		return startYear;
	}
	public Company setStartYear(int startYear) {
		this.startYear = startYear;
		return this;
	}
	public int getStartQtr() {
		return startQtr;
	}
	public Company setStartQtr(int startQtr) {
		this.startQtr = startQtr;
		return this;
	}
	public int getEndYear() {
		return endYear;
	}
	public Company setEndYear(int endYear) {
		this.endYear = endYear;
		return this;
	}
	public int getEndQtr() {
		return endQtr;
	}
	public Company setEndQtr(int endQtr) {
		this.endQtr = endQtr;
		return this;
	}
}
