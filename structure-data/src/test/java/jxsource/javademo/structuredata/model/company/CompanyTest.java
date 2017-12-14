package jxsource.javademo.structuredata.model.company;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import jxsource.javademo.structuredata.model.FlatData;

public class CompanyTest {

	@Test
	public void test() throws IOException {
		List<FlatData> fdList = FlatData.load("src/main/resources/data.csv");
		CompanyAnalyzer companyAnalyzer = new CompanyAnalyzer();
		companyAnalyzer.build();
		int count = 0;
		for(Company c:companyAnalyzer.getCompanyList()) {
			for(Year year: c.getYears()) {
				for(Qtr qtr: year.getListQtr()) {
					count++;
				}
			}
		}
		assertTrue(count == fdList.size());
	}
}
