package jxsource.javademo.structuredata.model.company;

import java.util.List;

public class Year {
	private int year;
	private List<Qtr> listQtr;
	private Info info;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Qtr> getListQtr() {
		return listQtr;
	}
	public void setListQtr(List<Qtr> listQtr) {
		this.listQtr = listQtr;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
}
