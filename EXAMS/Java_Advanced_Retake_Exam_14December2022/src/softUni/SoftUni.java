package EXAMS.Java_Advanced_Retake_Exam_14December2022.src.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
    public int getCount() {

        return this.data.size();
    }
    public String insert(Student student){
        if (this.data.size()>=this.capacity){
            return "The hall is full.";
        }else if (this.data.contains(student)){
            return "Student is already in the hall.";
        }else {
            this.data.add(student);
return String.format("Added student %s %s.",student.getFirstName(),student.getLastName());
        }
    }
    public String remove(Student student1){
        if (!this.data.contains(student1)){
            return "Student not found.";
        }else {
            this.data.remove(student1);
            return String.format("Removed student %s %s.",student1.getFirstName(),student1.getLastName());
        }
    }
    public Student getStudent(String firstName, String lastName){
        for (Student student:this.data) {
            if (student.getFirstName().equals(firstName)&&student.getLastName().equals(lastName)){
                return student;
            }
        }return null;
    }

        public String getStatistics(){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Hall size: %d%n", this.getCount()));
            this.data.forEach(s -> sb.append(s.toString()).append(System.lineSeparator()));
            return sb.toString();
        }

}
