package jxsource.javademo.structuredata.model.ceo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CEO {
	private String name;
	private Map<Integer, Company> companies = new HashMap<Integer, Company>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Company> getCompanies() {
		return companies.values();
	}
	public Company getCompany(int company) {
		return companies.get(company);
	}
	public Company createCompany(int company_id) {
		Company company = new Company();
		company.setCompany(company_id);
		companies.put(company_id, company);
		return company;
	}
}
