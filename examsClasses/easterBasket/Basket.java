package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int  capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg){
        if (this.data.size()<capacity){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        for (Egg e:data) {
            if (e.getColor().equals(color)){
                data.remove(e);
                return true;
            }
        }
        return false;
    }
    public Egg getStrongestEgg(){
        Egg temp = new Egg(null,-1,null);
        for (Egg e :data) {
            if (e.getStrength()> temp.getStrength()){
                temp = e;
            }
        }
        if (temp.getStrength()>-1){
            return temp;
        }else {
            return null;
        }
    }
    public Egg getEgg(String color){

        for (Egg e :data) {
            if (e.getColor().equals(color)){
                return e;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:",this.material));
        sb.append(System.lineSeparator());
        for (Egg e : this.data) {
         sb.append(e.toString());
         sb.append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
