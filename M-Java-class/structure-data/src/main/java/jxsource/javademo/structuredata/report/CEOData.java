package jxsource.javademo.structuredata.report;

public class CEOData implements Comparable<CEOData>{
	private int company;
	private String ceo;
	public CEOData(String ceo, int company) {
		if(ceo == null) {
			throw new RuntimeException("CEOData constructor: ceo cannot be null.");
		}
		this.ceo = ceo;
		this.company = company;
	}
	public int getCompany() {
		return company;
	}
	public String getCeo() {
		return ceo;
	}
	public int compareTo(CEOData o) {
		if(!ceo.equals(o.ceo)) {
			return ceo.compareTo(o.ceo);
		}
		return company - o.company;
	}
	@Override
	public String toString() {
		return "CEOData [ceo=" + ceo + ", company=" + company + "]";
	}
}
