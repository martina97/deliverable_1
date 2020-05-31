package project_deliverable_1;

import java.io.FileWriter;
import java.util.ArrayList;


public class CSVWriter {
	
	
	
	
	
	public static void writeCsv(String filePath, ArrayList<dataAndNumberEntity> array) {
		 
		
		//String filePath = "D:\\Programmi\\Java\\csv\\deliverable_1.csv ";
		  
		  System.out.println("starting write user.csv file: " + filePath);
		  FileWriter fileWriter = null;
		  try {
		   fileWriter = new FileWriter(filePath);
		   
		   fileWriter.append("Data (YearMonths); Count\n");
		   for(dataAndNumberEntity u: array) {
		    fileWriter.append(String.valueOf(u.getData()));
		    fileWriter.append(";");
		    fileWriter.append(String.valueOf(u.getCount()));
		    fileWriter.append("\n");
		   }
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  } finally {
		   try {
		    fileWriter.flush();
		    fileWriter.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		 }
	
	
	
	
	public static void main(String[] args) {
		 
		 // writeCsv(filePath);
		  
		  //System.out.println("starting read user.csv file");
		  //readCsv(filePath);
		 }
		 
		 
}
