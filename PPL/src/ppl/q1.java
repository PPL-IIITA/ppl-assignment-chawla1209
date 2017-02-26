
package ppl;
import Boy.Boy;
import Girl.Girl;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class q1{
        public static void inputboy(Boy b[],String line,int i){
            String csvSplit = ",";
            String[] boy = line.split(csvSplit);
            b[i] = new Boy();
            b[i].setName(boy[0]);
            b[i].setIntelligence_Quotient(Integer.parseInt(boy[1]));
            b[i].setAttractiveness_Quotient(Integer.parseInt(boy[2]));
            b[i].setMinimum_Attractiveness(Integer.parseInt(boy[3]));
            b[i].setBudget(Integer.parseInt(boy[4]));
            b[i].setTypeboy(boy[6]);
            String az="";
            b[i].setGirl_Friend(az);
            if(Integer.parseInt(boy[5])!=1)
                    b[i].setStatus(false);
            else
                b[i].setStatus(true);
        }
        public static void inputgirl(Girl g[],String line,int i){
            String csvSplit = ",";
            String[] girl = line.split(csvSplit);
            g[i] = new Girl();
            g[i].setName(girl[0]);
            g[i].setAttractiveness_Quotient(Integer.parseInt(girl[1]));
            g[i].setExpense(Integer.parseInt(girl[2]));
            g[i].setIntelligence_Quotient(Integer.parseInt(girl[3]));
            g[i].setType(girl[5]);
            if(Integer.parseInt(girl[4])==1)
                g[i].setStatus(true);
            else
                g[i].setStatus(false);
            String ara="";
            g[i].setBoy_Friend(ara);
        }
        
	public static void main(String args[]){
            CSV csv_files = new CSV();
                csv_files.csv(10,10,10);
		int number_of_boys=0,number_of_girls=0,i,j;
		
		Girl g[] = new Girl[1000];
		//String csvFile = "C:\\Users\\HP PC\\Desktop\\Girlq.csv";
                String csvFile="girl.csv";
                
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		
		
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
                          j=number_of_girls;
                        inputgirl(g,line,number_of_girls++);
                            
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
                catch(IOException e){
			e.printStackTrace();
		}
                Boy b[] = new Boy[1000];
                
		// csvFile = "C:\\Users\\HP PC\\Desktop\\Boy1.csv";
                csvFile="Boy.csv";
		 line = "";
		 csvSplit = ",";
		 buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
                          inputboy(b,line,number_of_boys++);
			}
		}
	
		catch(FileNotFoundException e){
		}
                catch(IOException e){
		}
                finally{
                    if(buff != null){
                        try{
                            buff.close();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
               	    }
		}
	for(i=0;i<number_of_boys;i++){
            for(j=0;j<number_of_girls;j++){
                if(!(g[j].getStatus())  && !(b[i].getStatus()) ){
                    if( g[j].possible(b[i].getBudget())){
                        if(b[i].possible(g[j].getAttractiveness_Quotient(),g[j].getExpense())){
                            b[i].setGirl_Friend(g[j].getName());
                            g[j].setBoy_Friend(b[i].getName());
                            b[i].setStatus (true);
                            g[j].setStatus(true);
                            b[i].setGirl_Friend_Object(g[j]);
                            b[i].setGirl_Friend_id(j);
                            g[j].setBoy_Friend_id(i);
                            g[j].setBoy_Friend_Object(b[i]);
			}
                    }
                }
            }
	}
       try{
           PrintWriter writer = new PrintWriter("Question1_log.log", "UTF-8");
       
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        writer.println(df.format(dateobj)+" "+"Committed Couples:");
	for(i=0;i<number_of_boys;i++){
		if(b[i].getStatus()==true){
		//	System.out.println(b[i].getName() +" " +b[i].getGirl_Friend());
                        writer.println(df.format(dateobj)+" "+ b[i].getName() +" " +b[i].getGirl_Friend());
                }
        }writer.close();
       }
       catch (IOException e) {
        }	
    }
}
/*import java.io.*;
import java.util.*;
public class csv_gen {
	    void csv(int a,int b,int c){
		try{
		    FileWriter gift_file = new FileWriter("gift.csv");
			FileWriter boy_file = new FileWriter("boy.csv");
			FileWriter girl_file = new FileWriter("girl.csv");
			int i;
			Random boy_rand = new Random();
			Random girl_rand = new Random();
			Random gift_rand = new Random();
			for(i=0;i<c;i++){
			    gift_file.write(gift_rand.nextInt(100)+gift_rand.nextInt(10));
			    if(i%3==0)gift_file.append("Luxury");
				else if(i%3==1)gift_file.append("Utility");
				else gift_file.append("Essential");
				gift_file.append("\n");
			}
			for(i=0;i<a;i++){
				boy_file.write("Boy"+(i+1)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(1000)+","+"0");
				if(i%3==0)boy_file.append("Generous");
				else if(i%3==1)boy_file.append("Miser");
				else boy_file.append("Geek");
				boy_file.append("\n");
				
			}
			for(i=0;i<b;i++){
			boy_file.write("Girl"+(i+1)+","girl_rand.nextInt(10)+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(1000)+","+"0");
				if(i%3==0)girl_file.append("Normal");
				else if(i%3==1)girl_file.append("Choosy");
				else girl_file.append("Desperate");
				boy_file.append("\n");
				
			}
			boy_file.close();
			girl_file.close();
		}catch(IOException e){		
		
		}
	
		
}
	    
}*/