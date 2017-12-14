package jxsource.javademo.structuredata.report;

import java.util.Map;

import jxsource.javademo.structuredata.model.company.Info;

public class SummaryData {
	private String category;
	private Map<Object, Info> summary;
	public String getCategory() {
		return category;
	}
	public SummaryData setCategory(String title) {
		this.category = title;
		return this;
	}
	public Map<Object, Info> getSummary() {
		return summary;
	}
	public SummaryData setSummary(Map<Object, Info> summary) {
		this.summary = summary;
		return this;
	}
	
}
