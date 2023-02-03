package Opinion_Poll_01;

public class Person {
    String name;
    int age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public  void isAbove30(){

        if (this.age>30){
            System.out.printf("%s - %d%n",this.name,this.age);
        }

    }
}
