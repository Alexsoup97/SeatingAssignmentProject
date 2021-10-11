/**
 * [Student.java]
 * 
 * @author 
 * @version 1.0 
**/
public class Student{

    private String name;
    private int id;
    private String cohort;
    //Student[] friendPreferences;


    public Student(String name, int id, String cohort){

        this.name = name;
        this.id = id;
        this.cohort = cohort;
        //this.friendPreferences = friendPrefences;

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

    public String getCohort() {
        return this.cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    // public Student[] getFriendPreferences() {
    //     return this.friendPreferences;
    // }

    // public void setFriendPreferences(Student[] friendPreferences) {
    //     this.friendPreferences = friendPreferences;
    // }

}