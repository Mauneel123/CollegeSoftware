package src;

import java.util.Arrays;

/**
 * Program Name
 *
 * Abstraction of a college teacher. Each teacher is uniquely identifiable by their ID (starting at 0).
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class Teacher implements Person {
    /**
     * Static variable used to determine the next ID number
     */
    protected static int nextID = 0;

    private String name;
    private int age;
    private String gender;
    private int id;
    private Course courses[];
    private int perCourseSalary;
    private int baseSalary;

    /**
     * Constructs a new Teacher with the corresponding parameters as field values, an array for storing courses, and
     * the next ID value (one greater than the previously created teacher's id value). Set the Teacher's baseSalary to
     * 30,000 and perCourseSalary to 15,000 by default.
     *
     * @param name Name of the new Teacher to be added
     * @param age Age of the new Teacher to be added
     * @param gender Gender of the new Teacher to be added
     */
    public Teacher(String name, int age, String gender) {
        //TODO: Initialize field variables for this Teacher object

        this.id=nextID;
        nextID++;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.baseSalary=30000;
        this.courses=new Course[10];
        this.perCourseSalary=15000;
    }

    /**
     * Constructs a new Teacher with the corresponding parameters as field values, an array for storing courses, and
     * the next ID value (one greater than the previously created teacher's ID value).
     *
     * @param name Name of the new Teacher to be added
     * @param age Age of the new Teacher to be added
     * @param gender Gender of the new Teacher to be added
     * @param baseSalary Amount the Teacher must be paid
     * @param perCourseSalary Amount the Teacher must be paid for each course they lead
     */
    public Teacher(String name, int age, String gender, int baseSalary, int perCourseSalary) {
        //TODO: Initialize field variables for this Teacher object

        this.id=nextID;
        nextID++;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.baseSalary=baseSalary;
        this.courses=new Course[10];
        this.perCourseSalary=perCourseSalary;
    }

    /**
     * Adds a course to the Teacher's array of courses taught. If the course array is full, then its size is doubled
     * the course is added. A Teacher may teach the same course more than once (like having multiple sections). If
     * course is null, nothing changes.
     *
     * This method should not modify the passed course object.
     *
     * @param course
     */
    public void addCourse(Course course){
        //TODO: Add course to the Teacher's array of courses, if possible
        if (course!=null)
        {
            int co=0;
            for(int j=0;j<courses.length;j++)
            {co++;
                if(courses[j]==null)
                {break;}
            }

            if (co==courses.length)
            {
                Course[] temp=new Course[courses.length*2];

                for (int i=0;i<courses.length;i++)
                {
                    temp[i]=courses[i];
                }
                temp[courses.length]=course;
                courses=new Course[temp.length];
                for (int i=0;i<temp.length;i++)
                {
                    this.courses[i]=temp[i];
                }
            }
            else
            {
                for (int i=0;i<courses.length;i++)
                {
                    if (courses[i]==null)
                    { this.courses[i]=course;
                        break;
                    }
                }

            }
        }
    }

    /**
     * Removes a course from the Teacher's array of courses taught. If the Teacher teaches multiple instances of the
     * course, only one is removed. Returns true if the course is found, false otherwise.
     *
     * @param course
     * @return boolean
     */
    public boolean dropCourse(Course course){
        //TODO: Remove course from the Teacher's array of courses, if possible.

       {boolean a = false;
        int i;
        for (i = 0; i < courses.length; i++) {
            if (courses[i]!= null) {
                if (courses[i].equals(course)) {
                    this.courses[i] = null;
                    a = true;
                    break;
                }
            }
        }

        return a;}
    }

    /**
     * @return a reference to the array of courses taught by this Teacher.
     */
    public Course[] getCourses()
    {
        //TODO: Return a reference to the courses taught by the teacher
        return courses;
    }

    /**
     * Returns the number of times the Teacher teaches course. For example, if the course occurs twice this returns 2.
     * If the course is not taught by this Teacher, this returns 0. Returns 0 if course is null.
     *
     * @param course Course being confirmed if taught by teacher
     * @return Course object.
     */
    public int teachesCourse(Course course) {
        //TODO: Return the number of times this Teacher teaches this course


        if (course == null)
        {
            return 0;
        }
        else
            {
            int co=0;
            for (int j = 0; j < courses.length; j++) {

                {
                    if (courses[j] != null) {
                        if ((courses[j].getName().equals(course.getName())) /*|| course.equals(courses[j]*/) {

                            co++;
                        }
                    }
                }   } return co;
        }




}

    @Override
    public void setName(String name) {
        //TODO: Set the Teacher's name to the parameter name
        this.name=name;
    }

    @Override
    public void setGender(String gender) {
        //TODO: Set the Teacher's gender to the parameter gender
        this.gender=gender;
    }

    @Override
    public void setAge(int age) {
        //TODO: Set the Teacher's age to the parameter age
        this.age=age;
    }

    @Override
    public String getName() {
        //TODO: Return the Teacher's name
        return name;
    }

    @Override
    public String getGender() {
        //TODO: Return the Teacher's gender
        return gender;
    }

    @Override
    public int getAge() {
        //TODO: Return the Teacher's age
        return age;
    }

    @Override
    public int getID() {
        //TODO: Return the Teacher's ID
        return id;
    }

    public int getPerCourseSalary() {
        //TODO: Return the Teacher's salary received per course taught
        return perCourseSalary; //pretty much
    }

    public int getBaseSalary() {
        //TODO: Return the Teacher's salary received for being employed by the College
        return baseSalary; //welp
    }

    /**
     * Returns a String representation of the Teacher object. This method must exist, but will not be tested.
     *
     * @return String
     */
    public String toString() {
        return "";
    }

//    public static void main(String[] args) {
//        Teacher hello = new Teacher("jknk",21,"male");
//        hello.addCourse(new Course("kk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kkfd",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kdfk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kkfd",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kdfk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kkfd",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kdfk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kk",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kkfd",new Professor("gdfgd",23,"female")));
//        hello.addCourse(new Course("kdfk",new Professor("gdfgd",23,"female")));
//        System.out.println(hello.getCourses().length);
//    }
}