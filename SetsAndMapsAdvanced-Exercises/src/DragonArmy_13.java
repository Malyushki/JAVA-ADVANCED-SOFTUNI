import java.util.*;



public class DragonArmy_13 {
    public static class Dragon {
        String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, String damage, String health, String armor) {
            this.name = name;
            this.damage = Integer.parseInt(damage);
            this.health = Integer.parseInt(health);
            this.armor = Integer.parseInt(armor);
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getArmor() {
            return armor;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public String toString() {
            return String.format("-%s -> damage: %d, health: %d, armor: %d", this.name, this.damage, this.health, this.armor);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> dragonsMap = new LinkedHashMap<>();
        List<Dragon> dragonsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] dragonInfo = scanner.nextLine().split("\\s+");
            String type = dragonInfo[0];
            String name = dragonInfo[1];
            String damage = dragonInfo[2];
            String health = dragonInfo[3];
            String armor = dragonInfo[4];
            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            if (!dragonsMap.containsKey(type)) {
                dragonsMap.put(type, new ArrayList<>());
                dragonsMap.get(type).add(name);

                dragonsList.add(new Dragon(name, damage, health, armor));

            } else {
                if (!dragonsMap.get(type).contains(name)) {
                    dragonsMap.get(type).add(name);
                    dragonsList.add(new Dragon(name, damage, health, armor));
                } else {

                    for (int j = 0; j < dragonsList.size(); j++) {
                        if (dragonsList.get(j).getName().equals(name)) {
                            dragonsList.get(j).setArmor(Integer.parseInt(armor));
                            dragonsList.get(j).setDamage(Integer.parseInt(damage));
                            dragonsList.get(j).setHealth(Integer.parseInt(health));
                            break;
                        }
                    }

                }
            }

            Collections.sort(dragonsMap.get(type));
        }
        for (Map.Entry<String, List<String>> entry : dragonsMap.entrySet()) {

            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            int counter = 0;

            for (String name : entry.getValue()) {


                for (Dragon e : dragonsList) {
                    if (e.getName().equals(name)) {
                        averageDamage += e.getDamage();
                        averageHealth += e.getHealth();
                        averageArmor += e.getArmor();
                        counter++;
                    }
                }


            }
            averageDamage /= counter;
            averageHealth /= counter;
            averageArmor /=counter;

                System.out.printf("%s::(%.2f/%.2f/%.2f)%n",entry.getKey(),averageDamage,averageHealth,averageArmor);

                for (String name : entry.getValue()) {
                    for (Dragon e : dragonsList) {
                        if (e.getName().equals(name)) {
                            System.out.println(e.toString());
                        }
                    }
                }

            }

        }
/// ne pprintira korektno srednite stoinosti
    }
