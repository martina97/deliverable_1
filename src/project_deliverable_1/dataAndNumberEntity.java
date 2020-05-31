package project_deliverable_1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Comparator;

public class dataAndNumberEntity implements Comparator<dataAndNumberEntity>{

	private YearMonth data;
	private int count;
	
	public dataAndNumberEntity() {} /*YearMonth data, int count) {
		this.data = data;
		this.count = count;
	}
	*/
	
		public void setData(YearMonth myData) {this.data = myData;}
		public void setCount(int myCount) {this.count = myCount;}

		
		public YearMonth getData() {
			return this.data;
		}
		
		
		public int getCount() {
			return this.count;
		}
	
	
	
	public static YearMonth convertData(int data) {
		LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(data), ZoneOffset.UTC);
		int anno = ldt.getYear();
		int mese = ldt.getMonthValue();
		YearMonth data1 = YearMonth.of(anno,mese);
		System.out.println(data1);
		return data1;
	}
	
	
	public int compare(dataAndNumberEntity a, dataAndNumberEntity b) {
		return a.data.compareTo(b.data);
	}
	
}
