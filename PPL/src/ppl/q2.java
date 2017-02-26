
package ppl;
import Boy.Boy;
import Gift.Gift;
import Girl.Girl;
import java.io.*;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class q2{
        public static int absolute_difference(int i) {
        if(i<0)i=i*(-1); 
        return i;
        }
        public static void inputgifts(Gift gi[],String line,int i){
        String csvSplit = ",";
            String[] tara = line.split(csvSplit);
            gi[i] = new Gift();
            gi[i].setPrice(Integer.parseInt(tara[0]));
         //   System.out.println(tara[1]);
            gi[i].setValue(Integer.parseInt(tara[1]));
            gi[i].setType(tara[2]);
        //    System.out.println(gi[i].getPrice());
    }
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
                int nob=Integer.parseInt(args[0]);
                int nog=Integer.parseInt(args[1]);
                int nogifts=Integer.parseInt(args[2]);
                int k=Integer.parseInt(args[3]);
                CSV csv_files = new CSV();
                csv_files.csv(nob,nog,nogifts);
		int number_of_boys=0,number_of_girls=0,i,j,number_of_gifts=0;
		Gift gi[] = new Gift[nogifts+1];
                String csvFile = "gift.csv";
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
                        //    System.out.println("Hi");
                          inputgifts(gi,line,number_of_gifts++);
				
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
                catch(IOException e){
			e.printStackTrace();
		}
		Boy b[] = new Boy[nob+1];
                
		 csvFile = "boy.csv";
		line = "";
		csvSplit = ",";
		buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
                          //   System.out.println("Hi");
                          inputboy(b,line,number_of_boys++);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
                catch(IOException e){
			e.printStackTrace();
		}
		Girl g[] = new Girl[nog+1];
		csvFile = "girl.csv";
		line = "";
		csvSplit = ",";
		buff = null;
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
		
             
            for(i=0;i<(number_of_gifts-1);i++){
                 for(j=i+1;j<number_of_gifts;j++){
                     if(gi[i].getPrice()>gi[j].getPrice()){
                         Gift temp=gi[i];
                         gi[i]=gi[j];
                         gi[j]=temp;
                     }
                 }
             }
             String Boy_Friend_Type,Girl_Friend_Type;
             for(i=0;i<number_of_boys;i++){
                 if(b[i].getStatus()==true){
                     int z=0,current_total=0;
                     Boy_Friend_Type=b[i].getTypeboy();
              
                     if(Boy_Friend_Type.equals("Generous")){
                         int current_budget;
                         current_budget=b[i].getBudget();
                         for(j=number_of_gifts-1;j>=0;j--){
                             if(gi[j].getPrice()<=current_budget){
                                 g[(b[i].getGirl_Friend_id())].getGift().add(gi[j]);
                                 current_budget=current_budget-gi[j].getPrice();
                                
                             }
                         }
                         b[i].setHappiness(0);
                     }
                     else if(Boy_Friend_Type.equals("Miser")){
                         
                         while(current_total<=g[(b[i].getGirl_Friend_id())].getExpense()){
                             
                                    g[(b[i].getGirl_Friend_id())].getGift().add(gi[z]);
                                      current_total+=gi[z++].getPrice();//yahan pe girl ko iss gift ka index de do
                         }
                         if(b[i].getBudget()>=current_total)
                             b[i].setHappiness(b[i].getBudget()-current_total);
                         else
                             b[i].setHappiness(0);
                   
                     }
                     else{
                      
                         z=0;
                         while(current_total<=g[(b[i].getGirl_Friend_id())].getExpense()){
                             g[(b[i].getGirl_Friend_id())].getGift().add(gi[z]);
                             current_total+=gi[z++].getPrice();
                                    
                         }
                         for(j=0;j<number_of_gifts;j++){
                             if(gi[j].getType().equals("Luxury")&&gi[j].getPrice()<b[i].getBudget()){
                                 g[(b[i].getGirl_Friend_id())].getGift().add(gi[j]);
                                 break;
                         }
                     }
                         b[i].setHappiness(g[(b[i].getGirl_Friend_id())].getIntelligence_Quotient());
                        
                 }
             }
             
             }
        for(i=0;i<number_of_girls;i++){
            if(g[i].getStatus()==true){
                Girl_Friend_Type=g[i].getTypegirl();
                if(Girl_Friend_Type.equals("Choosy")){
                 
                    int looper,ans=0;
                        for(looper=0;looper<g[i].getGift().size();looper++){
                            Gift zara;zara=g[i].getGift().get(looper);
                            if(zara.getType().equals("Luxury"))
                                ans+=(2*zara.getPrice());
                            else 
                                ans+=zara.getPrice();
                        }
                        double yoyo;
                        yoyo=log(ans);
                        if(b[g[i].getBoy_Friend_id()].getTypeboy().equals("Generous"))
                            yoyo*=2;
                        g[i].setHappiness(yoyo);
                        if((yoyo+b[g[i].getBoy_Friend_id()].getHappiness())>100000){
                            b[g[i].getBoy_Friend_id()].set_Total_Happiness(100005);
                            g[i].set_Total_Happiness(100005);
                        }
                        else{b[g[i].getBoy_Friend_id()].set_Total_Happiness(yoyo+b[g[i].getBoy_Friend_id()].getHappiness());
                        g[i].set_Total_Happiness(yoyo+b[g[i].getBoy_Friend_id()].getHappiness());}
              
                
                }
                if(Girl_Friend_Type.equals("Desperate")){
                    int looper,ans=0;
                        for(looper=0;looper<g[i].getGift().size();looper++){
                            Gift zara;zara=g[i].getGift().get(looper);
                                ans+=zara.getPrice();
                        }
                        if(ans>g[i].getExpense())ans-=g[i].getExpense();
                        else ans=0;
                        double yoyo;
                        yoyo=exp(ans);
                        if(b[g[i].getBoy_Friend_id()].getTypeboy().equals("Generous"))
                            yoyo*=2;
                        g[i].setHappiness(yoyo);
                        if((yoyo+b[g[i].getBoy_Friend_id()].getHappiness())>100000){
                            b[g[i].getBoy_Friend_id()].set_Total_Happiness(100005);
                            g[i].set_Total_Happiness(100005);
                        }
                        else{b[g[i].getBoy_Friend_id()].set_Total_Happiness(yoyo+b[g[i].getBoy_Friend_id()].getHappiness());
                        g[i].set_Total_Happiness(yoyo+b[g[i].getBoy_Friend_id()].getHappiness());}
                }
                else{
                     int looper,ans=0;
                        for(looper=0;looper<g[i].getGift().size();looper++){
                            Gift zara;zara=g[i].getGift().get(looper);
                                ans+=zara.getPrice();
                                ans+=zara.getValue();
                        }
                        if(ans>g[i].getExpense())ans-=g[i].getExpense();
                        else ans=0;
                        if(b[g[i].getBoy_Friend_id()].getTypeboy().equals("Generous"))
                            ans*=2;
                        g[i].setHappiness(ans);
                        if((ans+b[g[i].getBoy_Friend_id()].getHappiness())>100000){
                            b[g[i].getBoy_Friend_id()].set_Total_Happiness(100005);
                            g[i].set_Total_Happiness(100005);
                        }
                        else
                        {b[g[i].getBoy_Friend_id()].set_Total_Happiness(ans+b[g[i].getBoy_Friend_id()].getHappiness());
                        g[i].set_Total_Happiness(ans+b[g[i].getBoy_Friend_id()].getHappiness());
                        }
                }
            }
        }
        Double []amma=new Double[1000];
        int zer;zer=0;
        for(i=0;i<number_of_boys;i++){
                if(b[i].getStatus()==true){
                
                        amma[zer++]=b[i].get_Total_Happiness();
            }
        }
     
        double tempo;
        for(i=0;i<zer;i++){
            for(j=i;j<zer;j++){
                if(amma[i]<amma[j]){
                    tempo=amma[i];
                    amma[i]=amma[j];
                    amma[j]=tempo;
                }
            }
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date dateobj = new Date();

        try{
            PrintWriter writer = new PrintWriter("Question2_log.log", "UTF-8");
            writer.println(df.format(dateobj)+" Happy Couples:");
        
      //  System.out.println(df.format(dateobj)+" Happy Couples:");
        
        for(i=0;i<k;i++){
            for(j=0;j<number_of_boys;j++){
        //        System.out.println(b[j].get_Total_Happiness()+" ");
                if(amma[i]==b[j].get_Total_Happiness()){
          //          System.out.println(b[j].getName()+" "+b[j].getGirl_Friend()+ " "+ b[j].get_Total_Happiness());
                    writer.println(df.format(dateobj)+" "+ b[j].getName()+" "+b[j].getGirl_Friend()+ " "+ b[j].get_Total_Happiness());
                    break;
                }
            }
        }
        
        zer=0;
        Integer []arr = new Integer[1000];
        for(i=0;i<number_of_boys;i++){
            if(b[i].getStatus()){
            b[i].setCompatibility(absolute_difference(b[i].getBudget()-g[b[i].getGirl_Friend_id()].getExpense())+absolute_difference(b[i].getAttractiveness_Quotient()-g[b[i].getGirl_Friend_id()].getAttractiveness_Quotient())+absolute_difference(b[i].getIntelligence_Quotient()-g[b[i].getGirl_Friend_id()].getIntelligence_Quotient()));
           arr[zer++]=b[i].getCompatibility();
      //      System.out.println(b[i].getCompatibility());
            }
        }
        int peta;
        for(i=0;i<zer;i++){
            for(j=i;j<zer;j++){
                if(arr[i]<arr[j]){
                    peta=arr[i];
                    arr[i]=arr[j];
                    arr[j]=peta;
                }
            }
        }
       // System.out.println("Compatible Couples:");
        writer.println(df.format(dateobj)+ " Compatible Couples:");
        k=3;
        for(i=0;i<k;i++){
            for(j=0;j<number_of_boys;j++){
                if(arr[i]==b[j].getCompatibility()){
                 //   System.out.println(b[j].getName()+" "+b[j].getGirl_Friend()+ " "+ b[j].getCompatibility());
                    writer.println(df.format(dateobj)+ " " +b[j].getName()+" "+b[j].getGirl_Friend()+ " "+ b[j].getCompatibility());
                    break;
                }
            }
        }
        writer.close();}
        catch (IOException e) {}
        
    }    
}