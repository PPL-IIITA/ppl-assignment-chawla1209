package Gift;

public class Gift {
    private int price,value;
    private String type;
    public void setPrice(int p){
        this.price=p;
    }
    public void setValue(int v){
        this.value=v;
    }
    public void setType(String t){
        this.type=t;
       // System.out.println(this.type);
    }
    public int getPrice(){
        return this.price;
    }
    public int getValue(){
        return this.value;
    }
    public String getType(){
        return this.type;
    }
}
