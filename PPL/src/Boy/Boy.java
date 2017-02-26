package Boy;

import Girl.Girl;

public class Boy {
    private String name,girl_friend,typerr;
    private Girl Girl_Friend_Object;
    private boolean status;
    private int intelligence_quotient,attractiveness_quotient,minimum_attractiveness,budget,Girl_Friend_id,compatibility;
    private double happiness,total_happiness;
    public void setName(String n) {
        this.name = n;
       // System.out.println(this.name);
    }
    public void setGirl_Friend(String gf) {
        this.girl_friend = gf;
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
    public void setMinimum_Attractiveness(int m_a) {
        this.minimum_attractiveness = m_a;
    }
    public void setBudget(int b) {
        this.budget = b;
    }
    
    public String getName() {
      //  System.out.println(this.name);
        return this.name;
    }
    public String getGirl_Friend(){
        return this.girl_friend;
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
    public int getMinimum_Attractiveness(){
        return this.minimum_attractiveness;
    }
    public int getBudget() {
        return this.budget;
    }  
    public void setGirl_Friend_Object(Girl b){
        this.Girl_Friend_Object=b;
    }
    public Girl getGirl_Friend_Object(){
        return this.Girl_Friend_Object;
    }
    public void setGirl_Friend_id(int i){
        this.Girl_Friend_id=i;
    }
    public int getGirl_Friend_id(){
        return this.Girl_Friend_id;
    }
    public String getTypeboy(){
        return this.typerr;
    }
    public void setTypeboy(String z){
       this.typerr=z;
    }
    public void setHappiness(double ans){
        this.happiness=ans;
    }
    public double getHappiness(){
        return this.happiness;
    }
    public boolean possible(int attractiveness,int expense){
        if (this.budget >= expense) {
            if(this.minimum_attractiveness <= attractiveness){
                return true;
            }
        }
        return false;		
    }

    public void set_Total_Happiness(double d) {
        this.total_happiness=d;
    }
    public double get_Total_Happiness() {
        return this.total_happiness;
    }
    public int getCompatibility(){
        return this.compatibility;
    }
    public void setCompatibility(int a){
           this.compatibility=a;
    }
    
}