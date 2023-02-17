package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        Animal tempAnimal = new Animal(null, -1, null);
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                tempAnimal = animal;
            }
        }
        if (data.contains(tempAnimal)) {
            data.remove(tempAnimal);
            return true;
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {

        for (Animal animal : this.data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal tempAnimal = new Animal(null, -1, null);
        for (Animal animal : this.data) {
            if (animal.getAge() > tempAnimal.getAge()) {
                tempAnimal = animal;
            }
        }
        if (tempAnimal.getAge() > 0) {
            return tempAnimal;
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());
        this.data.forEach(s -> sb.append(String.format("%s %s",s.getName(),s.getCaretaker())).append(System.lineSeparator()));
        return sb.toString();
    }

}

