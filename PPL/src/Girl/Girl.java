package Girl;

import Boy.Boy;
import Gift.Gift;
import java.util.ArrayList;

public class Girl {
    private Boy Boy_Friend_Object;
    private String name,boy_friend,typer;
    private double happiness,total_happiness;
    private Boolean status;
    private int attractiveness_quotient,expense,intelligence_quotient,Boy_Friend_id;
    public Integer[] Gifts_List=new Integer[1000];
    public void setName(String n) {
        this.name = n;
    }
    public void setBoy_Friend(String bf) {
        this.boy_friend = bf;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setIntelligence_Quotient(int iq) {
        this.intelligence_quotient = iq;
    }
    public void setAttractiveness_Quotient(int aq) {
        this.attractiveness_quotient = aq;
    }
    public void setExpense(int b) {
        this.expense = b;
    }
    
    public String getName() {
        return this.name;
    }
    public String getBoy_Friend(){
        return this.boy_friend ;
    }
    public boolean getStatus() {
        return this.status;
    }
    public int getIntelligence_Quotient(){
        return this.intelligence_quotient;
    }
    public int getAttractiveness_Quotient(){
        return this.attractiveness_quotient;
    }
    public int getExpense(){
        return this.expense;
    }
    public void setBoy_Friend_Object(Boy b){
        this.Boy_Friend_Object=b;
    }
    public Boy getBoy_Friend_Object(){
        return this.Boy_Friend_Object;
    }
    public void setBoy_Friend_id(int i){
        this.Boy_Friend_id=i;
    }
    public int getBoy_Friend_id(){
        return this.Boy_Friend_id;
    }
      public String getTypegirl(){
        return this.typer;
    }
    public double getHappiness(){
        return this.happiness;
    }
    public void setType(String t){
        this.typer = t;
    }
    public void setHappiness(double ans){
        this.happiness=ans;
    }
    public boolean possible(int budget){
        if(this.expense > budget)
            return false;
        return true;
    }
    private ArrayList<Gift> all_gifts = new ArrayList<Gift>();

    public ArrayList<Gift> getGift() {
        return all_gifts;
    }
     public void set_Total_Happiness(double d) {
        this.total_happiness=d;
    }
    public double get_Total_Happiness() {
        return this.total_happiness;
    }
}