package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    /*
•	name: String
•	capacity: int
•	size: int - the volume of the pool

     */
private String name;
private int capacity;
private int size;
private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }
    public void add(Fish fish){
        if (getFishInPool()<capacity && !fishInPool.contains(fish)){
            fishInPool.add(fish);
        }

    }
}
