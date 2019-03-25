package src;

/**
 * Person
 *
 * Interface provided for general properties of students in courses.
 */

public interface Person {
    void setName(String name);
    void setGender(String gender);
    void setAge(int age);
    int getID();
    String getName();
    String getGender();
    int getAge();
}
