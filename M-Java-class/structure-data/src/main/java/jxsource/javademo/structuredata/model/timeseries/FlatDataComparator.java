package jxsource.javademo.structuredata.model.timeseries;

import java.util.Comparator;

import jxsource.javademo.structuredata.model.FlatData;

public class FlatDataComparator implements Comparator<FlatData>{

	public int compare(FlatData f0, FlatData f1) {
		if(f0.getYear() != f1.getYear()) {
			return f0.getYear() - f1.getYear();
		} else 
		if(f0.getCompany() != f1.getCompany()){
			return f0.getCompany() - f1.getCompany();			
		} else {
			return f0.getQtr() - f1.getQtr();
		}
	}

}
