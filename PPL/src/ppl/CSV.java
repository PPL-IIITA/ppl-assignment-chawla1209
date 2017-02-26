package ppl;
import java.io.*;
import java.util.*;
public class CSV {
	    public static void csv(int a,int b,int c){
		try{
		    FileWriter gift_file = new FileWriter("gift.csv");
			FileWriter boy_file = new FileWriter("boy.csv");
			FileWriter girl_file = new FileWriter("girl.csv");
			int i;
			Random boy_rand = new Random();
			Random girl_rand = new Random();
			Random gift_rand = new Random();
			for(i=0;i<c;i++){
			    gift_file.write(gift_rand.nextInt(100)+","+gift_rand.nextInt(10)+",");
			    if(i%3==0)gift_file.append("Luxury");
				else if(i%3==1)gift_file.append("Utility");
				else gift_file.append("Essential");
				gift_file.append("\n");
			}
			for(i=0;i<a;i++){
				boy_file.write("Boy"+(i+1)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(1000)+","+"0"+",");
				if(i%3==0)boy_file.append("Generous");
				else if(i%3==1)boy_file.append("Miser");
				else boy_file.append("Geek");
				boy_file.append("\n");
				
			}
			for(i=0;i<b;i++){
			girl_file.write("Girl"+(i+1)+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(1000)+","+"0"+",");
				if(i%3==0)girl_file.append("Normal");
				else if(i%3==1)girl_file.append("Choosy");
				else girl_file.append("Desperate");
				girl_file.append("\n");
				
			}
			boy_file.close();
			girl_file.close();
                        gift_file.close();
		}catch(IOException e){}
	
		
}
	    
}