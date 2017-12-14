package jxsource.javademo.structuredata.model.ceo;

import java.util.Comparator;

import jxsource.javademo.structuredata.model.FlatData;

public class CEOComparator implements Comparator<FlatData>{

	public int compare(FlatData f0, FlatData f1) {
		if(!f0.getCeo().equals(f1.getCeo())) {
			return f0.getCeo().compareTo(f1.getCeo());
		} else
		if(f0.getCompany() != f1.getCompany()) {
			return f0.getCompany() - f1.getCompany();
		} else
		if(f0.getYear() != f1.getYear()) {
			return f0.getYear() - f1.getYear();
		} else {
			return f0.getQtr() - f1.getQtr();
		} 
	}

}
