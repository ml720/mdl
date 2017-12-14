package jxsource.javademo.structuredata.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import jxsource.javademo.structuredata.util.Util;

public class FlatData {
	private static String[] header;
	private int year;
	private int qtr;
	private int company;
	private int region;
	private String type;
	private int employee;
	private long revenue;
	private String ceo;
	private float profit;
	
	public static void save(List<FlatData> listFlatData, String file) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream(file));
		for(int i=0; i<header.length-1; i++) {
			out.print(header[i]+",");
		}
		out.println(header[header.length-1]);
		Util.printFlatData(listFlatData, out);
	}
	public static List<FlatData> load(String file) throws IOException {
		InputStream in = new FileInputStream(file);
		BufferedReader r = new BufferedReader( new InputStreamReader(in));
		String line = null;
		boolean skipHeader = false;
		List<FlatData> list = new ArrayList<FlatData>();
		while((line = r.readLine()) != null) {
			String[] fields = line.split(",");
			if(fields.length > 1) {
				if(!skipHeader) {
					header = fields;
					skipHeader = true;
				} else {
					FlatData data = new FlatData();
					data.year = Integer.parseInt(fields[0]);
					data.qtr = Integer.parseInt(fields[1]);
					data.company = Integer.parseInt(fields[2]);
					data.region = Integer.parseInt(fields[3]);
					data.type = fields[4];
					data.employee = Integer.parseInt(fields[5]);
					data.revenue = Long.parseLong(fields[6]);
					data.profit = Float.parseFloat(fields[7]);
					if(fields.length == 9) {
						data.ceo = fields[8];
					} else {
						
					}
					list.add(data);
				}
			}
		}
		in.close();
		return list;	
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQtr() {
		return qtr;
	}
	public void setQtr(int qtr) {
		this.qtr = qtr;
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

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "FlatData [year=" + year + ", qtr=" + qtr + ", company=" + company + ", region=" + region + ", type="
				+ type + ", employee=" + employee + ", revenue=" + revenue + ", profit=" + profit + ", ceo=" + ceo
				+ "]";
	}

	
}
