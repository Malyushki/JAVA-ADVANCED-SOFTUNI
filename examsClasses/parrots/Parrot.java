package parrots;

public class Parrot {
    /*
    •	name: String
    •	species: String
    •	available: boolean - true by default

     */
    private String name;
    private String species;
    private boolean available ;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean bool) {
        this.available = bool;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",this.species,this.name);
    }
}
