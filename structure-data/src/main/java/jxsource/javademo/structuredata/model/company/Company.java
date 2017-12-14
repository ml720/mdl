package jxsource.javademo.structuredata.model.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jxsource.javademo.structuredata.model.FlatData;

public class Company implements Comparable<Company>{
	private int company;
	private int region;
	private String type;
	private Set<CEO> ceos = new HashSet<CEO>();
	private List<Year> listYear;
	public String getCEO(int year, int qtr) {
		String name = null;
		for(CEO ceo: ceos) {
			if(ceo.year == year) {
				if(ceo.qtr <= qtr) {
					name = ceo.name;
					break;
				}
			} else 
			if(ceo.year < year){
				name = ceo.name;
				break;
			}
		}
		if(name == null) {
			throw new RuntimeException("CEO cannot be null.");
		}
		return name;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Year> getYears() {
		return listYear;
	}
	public void setYears(List<Year> time) {
		this.listYear = time;
	}
	public void addCeo(String ceo, int startYear, int startQtr) {
		if(ceo != null && ceo.length() > 0) {
			ceos.add(new CEO(ceo, startYear, startQtr));
		}
	}
	public Set<CEO> getCeos() {
		return ceos;
	}
	public void setCeos(Set<CEO> ceos) {
		this.ceos = ceos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + company;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (company != other.company)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Company [company=" + company + ", region=" + region + ", type=" + type + ", ceos=" + ceos
				+ ", listYear=" + listYear + "]";
	}
	public int compareTo(Company o) {
		return company - o.company;
	}
}
