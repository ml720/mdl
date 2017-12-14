package jxsource.javademo.structuredata.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class Model {
	private static List<FlatData> flatDataSrc;
	protected static List<FlatData> load() throws IOException {
		if(flatDataSrc == null) {
			flatDataSrc= FlatData.load("src/main/resources/data.csv");
		}
		return flatDataSrc;
	}
	public static void setFlatData(List<FlatData> flatDatalist) {
		flatDataSrc = flatDatalist;
	}
	protected abstract List<FlatData> getFlatDataList();
	
	protected void save() throws FileNotFoundException {
		FlatData.save(getFlatDataList(), "src/main/resources/newData.csv");
	}
}
 