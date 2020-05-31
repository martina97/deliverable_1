package project_deliverable_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;






public class main_deliverable_1 {
	
		static ArrayList<dataAndNumberEntity> array = new ArrayList<dataAndNumberEntity>();
	
	
	   public static void main(String[] args) throws IOException, JSONException,InvalidRemoteException, TransportException, GitAPIException {
		
		
		//apro repository locale esistente
		   RetrieveTicketsID_deliverable_1 list = new RetrieveTicketsID_deliverable_1();
		   //System.out.println("La lista dei bug che sono stati chiusi o risolti è:");
		   list.lista = RetrieveTicketsID_deliverable_1.retrieveTickets("DAFFODIL");
		 // list.printArrayList(list.lista);
		   
		   
		Path repoPath = Paths.get("D:/Università/magistrale/isw2/Codici/incubator-daffodil");
		 try (Git git = Git.init().setDirectory(repoPath.toFile()).call()) {
		    }
		    InitCommand init = Git.init();
		    init.setDirectory(repoPath.toFile());
		    try (Git git = init.call()) {
		    }
		    try (Git git = Git.open(repoPath.toFile())) {
		    	
		    	
		    	// log del progetto
		    	/*
		    	returns an iterable of RevCommit instances. 
		    	With this object, you have access to commit information like the id, time, message, and author.*/
		    	
		    	//Iterable<RevCommit> logs = git.log().all().call();
		    	
		    	/*
		        for (RevCommit rev : logs) {
		          System.out.print(Instant.ofEpochSecond(rev.getCommitTime()));		//giorno e ora commit
		          System.out.print(": ");											
		          System.out.print(rev.getFullMessage());							//messaggio nel commit
		          System.out.println();
		          System.out.println(rev.getId().getName());						//id commit
		          System.out.print(rev.getAuthorIdent().getName());					//autore commit
		          System.out.println(rev.getAuthorIdent().getEmailAddress());		//email autore commit
		          System.out.println("-------------------------");
		        }*/
		        
		    	//for (int i=0; i< 20; i++) {

		  for (int i=0; i< list.lista.size(); i++) {
		    		String key = list.lista.get(i);
		            System.out.println("\nIl bug che è stato chiuso/risolto è=" + key);
		           
		            Iterable<RevCommit> logs = git.log().all().call();
	        		
		            ArrayList<Integer> millis = new ArrayList<Integer> ();

			        for (RevCommit rev : logs) {
				          //System.out.print(Instant.ofEpochSecond(rev.getCommitTime()));
				         // System.out.print(": ");
			        	
			        	String string = rev.getFullMessage();
		        		//System.out.println(string);
		        		//System.out.println(keyword);
			        	
		        		//ArrayList<Integer> millis = new ArrayList<Integer> ();

			        if (string.contains(key + ".") || string.contains(key + "\n") || string.contains(key + "\r") || string.contains(key + ",")) {				
			        	// System.out.println("il bug che è stato chiuso/risolto è=" + key);
			        		//List<Integer> millis = new ArrayList<Integer> ();
			        		List<Integer> data = new ArrayList<Integer>();
			        		int data_milliseconds = rev.getCommitTime();
			        		millis.add(data_milliseconds);
			        		
			                LocalDateTime date_commit = Instant.ofEpochSecond(data_milliseconds).atZone(ZoneId.of("UTC")).toLocalDateTime();

			        		//System.out.println("\n-La data del commit IN ISTANT in cui si trova il bug è: " + Instant.ofEpochSecond(rev.getCommitTime()));
			        		
			        		System.out.println("\n-La data del commit (IN LOCALDATETIME) in cui si trova il bug è: " + date_commit);

			        		//System.out.println("\n in millisecondi: \n" + rev.getCommitTime());
			        		//System.out.println("\n in millisecondi: \n" + data_milliseconds);
					         //System.out.println("-------------------------");

			        	}
			        
			        
			      
			        }
			        if (millis.size() != 0) {	//ci sono bug che non stanno in nessun commit quindi non posso trovare la data
			        	System.out.println("\nSTAMPO LISTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			        	for (int k = 0; k < millis.size(); k++) {
			        		System.out.println(millis.get(k));
			        	}  
			        	FindRecentData frd = new FindRecentData();
		 				frd.data1 = FindRecentData.findData(millis);
		 				
		 				
		 				YearMonth mese_anno = FindRecentData.convertData(frd.data1);
		 				System.out.println("data convertita è = " + mese_anno);
		 				
		 				dataAndNumberEntity dati = new dataAndNumberEntity();
		 				dati.setData(mese_anno);
		 				dati.setCount(1);
		 				
		 				/*
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
		 				}*/
		 				
		 				///// 	AGGIUNGO ORA!!!!! /////
		 				
		 			    ListDataNumber prova= new ListDataNumber();
		 			    array = prova.addElementArray(array, dati, mese_anno);
		 				
		 				
		 				/////////
		 				
		 				
		 				
			        }
			      System.out.println("-------------------------");
		    	
		    	}
		    }
		    for (int i = 0; i < array.size(); i++) {
 				System.out.println(array.get(i).getData());
 				//System.out.println(array.get(i).getCount());

 			}
		    
		    //stampo contenuti in ordine!
		    Collections.sort(array, new dataAndNumberEntity());
		    System.out.println("\nOrdino per data");
		    for (int m=0; m<array.size(); m++) {
		    	System.out.println(array.get(m).getData());
		    }
		    
		    ListDataNumber lDN= new ListDataNumber();
		    array = lDN.checkArray(array);
		    
		    
		    
		    CSVWriter csv = new CSVWriter();
		    String filePath = "D:\\Programmi\\Java\\csv\\deliverable_1.csv ";

		    csv.writeCsv(filePath, array);
		    
	   }
}
		    	    	
		    	
		          /*
		          for (; i < total && i < j; i++) { //for sulla issue
		             //Iterate through each bug
		             String key = issues.getJSONObject(i%1000).get("key").toString();	//PRINT KEY DELLA ISSUE
		             //System.out.println(key);
			            System.out.println("il bug che è stato chiuso/risolto è=" + key);
			           // String key2 = key + " ";
			           // System.out.println("key = " + key2);
				    	Iterable<RevCommit> logs = git.log().all().call();

				        for (RevCommit rev : logs) {
					          //System.out.print(Instant.ofEpochSecond(rev.getCommitTime()));
					         // System.out.print(": ");
				        	
				        	String string = rev.getFullMessage();
			        		//System.out.println(string);
			        		//System.out.println(keyword);

				        	if (string.toLowerCase().indexOf(key.toLowerCase()) != -1) {
					           // System.out.println("il bug che è stato chiuso/risolto è=" + key);
				        		System.out.println("\n IL BUG SI TROVA NEL COMMENTO: \n" + rev.getFullMessage());
						         //System.out.println("-------------------------");

				        	}
				        	

				        }
		                 
				         System.out.println("-------------------------");
	            	             
		          }
		          
		       } while (i < total);
		       return;
		    }
		    	
		    	
		    	
		    	
		    	
		    	
		        	/*
			          System.out.print(rev.getFullMessage());
			          System.out.println();
			          System.out.println(rev.getId().getName());
			          System.out.print(rev.getAuthorIdent().getName());
			          System.out.println(rev.getAuthorIdent().getEmailAddress());
			          System.out.println("-------------------------");
			        }*/
		    

		  /////////////////////////////////////



		
		
		
		/*
		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		Repository repository = repositoryBuilder.setGitDir(new File("D:/Università/magistrale/isw2/Codici/helloWorldProject/.git"))
					.readEnvironment()
					.findGitDir()
					.setMustExist(true)
					.build();
		
		
		git.checkout()
	    .setCreateBranch(true)
	    .setName("new-branch")
	    .call();*/

