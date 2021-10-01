
public class Student{


    private String name;
    private int id;
    private char cohort;
    Student[] friendPreferences;


    public Student(String name, int id, char cohort, Student[] friendPrefences){

        this.name = name;
        this.id = id;
        this.cohort = cohort;
        this.friendPreferences = friendPrefences;

    }

    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getCohort() {
        return this.cohort;
    }

    public void setCohort(char cohort) {
        this.cohort = cohort;
    }

    public Student[] getFriendPreferences() {
        return this.friendPreferences;
    }

    public void setFriendPreferences(Student[] friendPreferences) {
        this.friendPreferences = friendPreferences;
    }


}