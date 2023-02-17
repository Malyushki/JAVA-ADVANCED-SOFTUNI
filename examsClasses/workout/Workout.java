package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise1) {
        if (exercises.size() < exerciseCount) {
            this.exercises.add(exercise1);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise element : exercises) {
            if (element.getName().equals(name) && element.getMuscle().equals(muscle)) {
                exercises.remove(element);
                return true;
            }
        }
        return false;

    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise element : exercises) {
            if (element.getName().equals(name) && element.getMuscle().equals(muscle)) {
                return element;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        Exercise temp = new Exercise(null,null,-1);
        for (Exercise element : exercises) {
            if (element.getBurnedCalories()>temp.getBurnedCalories()){
                temp = element;
            }
        }
        if (temp.getBurnedCalories()>0){
            return temp;
        }else {
            return null;
        }
    }
    public int getExerciseCount(){
        return this.exercises.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s",this.type));
        sb.append(System.lineSeparator());
        for (Exercise e:exercises) {
            sb.append(e.toString());
            sb.append(System.lineSeparator());
        }
     return sb.toString();
    }

}
