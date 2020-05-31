package project_deliverable_1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;

public class FindRecentData {

	public static Instant data;
	public static Integer data1;
	
	
	
	
	/*
-La data del commit in cui si trova il bug è: 2019-12-09T21:54:33Z

 in millisecondi: 
1575928473*/
	
	
	
	public static int findData(ArrayList<Integer> list ) {
	
		data = Instant.ofEpochSecond(Collections.max(list));
		data1 = Collections.max(list);
		//System.out.println("\nLa data più recente è\r" + data );
		System.out.println("\nLa data più recente è\r" + data1 );

		return data1;
		
	}
	
	public static YearMonth convertData(int data) {
		LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(data), ZoneOffset.UTC);
		int anno = ldt.getYear();
		int mese = ldt.getMonthValue();
		YearMonth data1 = YearMonth.of(anno,mese);
		System.out.println(data1);
		return data1;
	}
	
	
	
	
	public static void main(String[] args) {

		System.out.println("data più recente è" + data );
}
}
