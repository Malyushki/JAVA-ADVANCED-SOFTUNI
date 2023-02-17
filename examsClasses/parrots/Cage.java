package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    /*
•	name: String
•	capacity: int
•	data: List<Parrot> that holds added parrots
      */
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot p : this.data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                return p;

            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        data.forEach(p ->
        {
            if (p.getSpecies().equals(species)) {
                p.setAvailable(false);
                soldParrots.add(p);
            }
        });

        return soldParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", this.name));

        // sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot r : this.data) {
            if (r.isAvailable()) {
                sb.append(r.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();


    }


}
