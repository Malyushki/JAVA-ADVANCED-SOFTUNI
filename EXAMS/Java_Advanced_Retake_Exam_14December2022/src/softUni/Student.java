package EXAMS.Java_Advanced_Retake_Exam_14December2022.src.softUni;

public class Student {
    private String firstName;
    private String lastName;
    private String bestCourse;

    public Student(String firstName, String lastName, String bestCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestCourse = bestCourse;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestCourse() {
        return bestCourse;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBestCourse(String bestCourse) {
        this.bestCourse = bestCourse;
    }

    @Override
    public String toString() {
        //"Student: {firstName} {lastName}, Best Course = {bestCourse}"
        return String.format("Student: %s %s, Best Course = %s",this.firstName,this.lastName,this.bestCourse);
    }
}
