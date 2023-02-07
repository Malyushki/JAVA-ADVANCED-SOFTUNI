import java.util.*;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> backpack = new ArrayDeque<>();
        ArrayDeque<Integer> dailyStamina = new ArrayDeque<>();
        ArrayDeque<String> peaksClimbed = new ArrayDeque<>();
        int[] quantitiesOfSupplies = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int supplyQuantity: quantitiesOfSupplies) {
            backpack.push(supplyQuantity);
        }
        int[] quantitiesDailyStamina = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int dailyStaminaQuantity:quantitiesDailyStamina) {
            dailyStamina.offer(dailyStaminaQuantity);
        }
      List<String[]>peaks = new ArrayList<>();
        peaks.add(new String[]{"Vihren","80"});
        peaks.add(new String[]{"Kutelo","90"});
        peaks.add(new String[]{"Banski Suhodol","100"});
        peaks.add(new String[]{"Polezhan","60"});
        peaks.add(new String[]{"Kamenitza","70"});

        for (int day = 1; day <=7 ; day++) {

                int energy = backpack.pop() + dailyStamina.poll();
            int peakDifficulty = Integer.parseInt(peaks.get(0)[1]);
            if (energy>=peakDifficulty){
                peaksClimbed.offer(peaks.get(0)[0]);
                peaks.remove(0);
            }
        if (dailyStamina.isEmpty()||backpack.isEmpty()||peaks.isEmpty() ){
            break;
        }
        }
       if (peaks.isEmpty()){
           System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
       }else {
           System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
       }
       if (!peaksClimbed.isEmpty()){
           System.out.println("Conquered peaks:");
           while (!peaksClimbed.isEmpty()){
               System.out.println(peaksClimbed.poll());
           }
       }
    }
}
