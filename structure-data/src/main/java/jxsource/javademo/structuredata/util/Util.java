package jxsource.javademo.structuredata.util;

import java.io.PrintStream;
import java.util.List;

import jxsource.javademo.structuredata.model.FlatData;

public class Util {
	public static void printFlatData(List<FlatData> listFlatData, PrintStream out) 
	{
		for(FlatData flatData: listFlatData) {
			out.format("%d,",flatData.getYear());
			out.format("%d,",flatData.getQtr());
			out.format("%d,",flatData.getCompany());
			out.format("%d,",flatData.getRegion());
			out.format("%s,",flatData.getType());
			out.format("%d,",flatData.getEmployee());
			out.format("%d,",flatData.getRevenue());
			out.format("%f,",flatData.getProfit());
			out.format("%s\n",flatData.getCeo());
		}
	}
}