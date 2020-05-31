package project_deliverable_1;

import java.time.YearMonth;
import java.util.ArrayList;

public class ListDataNumber {

	private ArrayList<dataAndNumberEntity> dNE; //= new ArrayList<dataAndNumberEntity>();
	
	
	
	public ArrayList<dataAndNumberEntity> checkArray(ArrayList<dataAndNumberEntity> array) {
		
		
		
		for(int j=0;j<array.size()-1; j++) {


			if(array.get(j).getData().getYear() == array.get(j+1).getData().getYear()) {
				int anno = array.get(j).getData().getYear();
				
				int diff = array.get(j+1).getData().getMonthValue() - array.get(j).getData().getMonthValue();
				//System.out.println("mese succ = " + array.get(j+1).getMonthValue());

				//System.out.println("mese prec = " + array.get(j).getMonthValue());
				//System.out.println("mese succ = " + array.get(j).getData().getMonth());
				
				//System.out.println("mese succ = " + array.get(j+1).getData().getMonth());

				//System.out.println("diff = " + diff);
				for(int m=0; m<diff-1;m++) {
					int mese = array.get(j).getData().getMonthValue() + 1;
					YearMonth ym= YearMonth.of(anno,mese) ;
					//Month mese = array.get(j).getMonth();
					dataAndNumberEntity dN = new dataAndNumberEntity();
					dN.setData(ym);
					dN.setCount(0);
				//	System.out.println("mese = " + mese);

					array.add(j+1,dN);
					j++;
				}

				//System.out.println("ok");
			}
			else {
				int anno = array.get(j).getData().getYear();

				int diff = 12-(array.get(j).getData().getMonthValue()) + array.get(j+1).getData().getMonthValue();
				//System.out.println("diff = " + diff);

				
				for(int m =0; m<diff-1;m++) {
					if(array.get(j).getData().getMonthValue() != 12) {
						int mese = array.get(j).getData().getMonthValue() + 1;
						YearMonth ym= YearMonth.of(anno,mese) ;
						//Month mese = array.get(j).getMonth();
						
						//System.out.println("mese = " + mese);
						dataAndNumberEntity dN = new dataAndNumberEntity();

						dN.setData(ym);
						dN.setCount(0);
						array.add(j+1,dN);
						j++;
				}
				}
				//System.out.println("no");

			}
		}
		/*
		System.out.println(" ");

		for(int i=0; i<array.size();i++) {
			System.out.println("data = " + array.get(i));
		}
		*/
		return array;
	}
	
	
	
	public ArrayList<dataAndNumberEntity> addElementArray(ArrayList<dataAndNumberEntity> array, dataAndNumberEntity dati, YearMonth mese_anno) {
		
		
		
			
		if(array.size() == 0) {
				array.add(dati);
				System.out.println("\nciaoooooo");
			} else {
			for (int j = 0; j < array.size(); j++) {
				System.out.println("\n\nj=:" + j);
				System.out.println("array.size=" + array.size());

				System.out.println("array.get(" + j + ").getData() =" + array.get(j).getData());
				System.out.println( "mese anno = " + mese_anno);
				boolean cacca = mese_anno.equals(array.get(j).getData());
				System.out.println("cacca = " + cacca);
			
				if (mese_anno.equals(array.get(j).getData())) {
					
					System.out.println("provaaaaa");
					array.get(j).setCount(array.get(j).getCount() + 1);
					System.out.println(array.get(j).getData());
	 				System.out.println(array.get(j).getCount());
					break;
				}
				else if ( j!= (array.size()-1)) {
					
					System.out.println("booooooo");
					//j++;
				}
				else if (j == (array.size()-1)) {
 	 					array.add(dati);
 	 					System.out.println("noooooo");
 	 					break;
	 				}
				
			}
	}
		return array;

}
}
