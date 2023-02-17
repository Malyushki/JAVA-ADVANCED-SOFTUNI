package aquarium;

public class Fish {
    /*
•	name: String
•	color: String
•	fins: int

     */
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    @Override
    public String toString() {
        String sb = String.format("Fish: %s%n", this.name) +
                String.format("Fish: %s%n", this.color) +
                String.format("Fish: %d%n", this.fins);
        return sb.trim();
    }
}
