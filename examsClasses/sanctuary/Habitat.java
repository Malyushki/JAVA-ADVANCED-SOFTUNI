import java.util.ArrayList;
import java.util.List;

public class Habitat {
    //•	capacity: int
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Elephant elephant){
        if (this.data.size()<capacity){
            data.add(elephant);
        }
    }
    public boolean remove(String name){
        Elephant temp = new Elephant(name,-1,null);
        for (Elephant e:this.data) {
            if (e.getName().equals(temp.getName())){
                temp = e;
            }
        }
       if (data.contains(temp)){
           data.remove(temp);
           return true;
       }
       return false;
    }
    public Elephant getElephant(String retiredFrom){
        Elephant temp = new Elephant(null,-1,retiredFrom);
        for (Elephant e:this.data) {
            if (e.getRetiredFrom().equals(temp.getRetiredFrom())){
                return e;
            }
        }
        return null;
    }
    public Elephant getOldestElephant(){
        Elephant oldest = new Elephant(null,-1,null);
        for (Elephant e:this.data) {
            if (e.getAge()>oldest.getAge()){
                oldest = e;
            }
        }
        if (oldest.getAge()>0){
            return oldest;
        }
        return null;
    }
   public int getAllElephants(){
        return this.data.size();
   }
   public String getReport(){
       StringBuilder sb = new StringBuilder();
       sb.append("Saved elephants in the park:");
       sb.append(System.lineSeparator());
       this.data.forEach(s -> sb.append(String.format("%s came from: %s",s.getName(),s.getRetiredFrom())).append(System.lineSeparator()));
       return sb.toString();
    }

}
