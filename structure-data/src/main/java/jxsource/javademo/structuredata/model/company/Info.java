package jxsource.javademo.structuredata.model.company;

public class Info {
	private int employee;
	private long revenue;
	private float profit;
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	public long getRevenue() {
		return revenue;
	}
	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "Info [profit=" + profit + ", revenue=" + revenue + ", employee=" + employee + "]";
	}

}
