package src;

import java.util.Arrays;

/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;

    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private String name;
    private Professor[] professors;
    private Teacher[] teachers;
    private Student[] students;
    private Course[] courses;
    private int tuition;

    /**
     * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
     * Students, Teachers, and Courses limited by the corresponding MAX variables.
     *
     * @param name Name of the College to be created.
     * @param tuition Cost for students to attend.
     */
    public College(String name, int tuition) {
        
        this.name = name;
        this.tuition = tuition;
        this.teachers = new Teacher[MAX_TEACHERS];
        this.professors = new Professor[MAX_PROFESSORS];
        this.courses = new Course[MAX_COURSES];

        this.students = new Student[MAX_STUDENTS];
    }

    /**
     * Adds course to the College's array of courses. If the course is null, the course is already available at the
     * College, or the College cannot add more courses, nothing changes.
     *
     * @param course A course object to be added to the College's array of courses.
     */
    public void addCourse(Course course) {

        int a = -1;
        int co=0;
        if(course==null)
        {a=0;}

        else if(course!=null) {
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] != null) {
                    co++;
                    if (course.equals(courses[i]) || (course.getName().equals(courses[i].getName()) && course.getProfessor().equals(courses[i].getProfessor()))) {
                        a = 0;
                        break;
                    }
                }
            }
            if (co == courses.length) {
                a = 0;
            }

            if (a == 0) {
            } else {
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] == null) {
                        this.courses[i] = course;
                        break;
                    }
                }

            }
        }
    }


    public void hireProfessor(Professor professor) {
        if(professor!=null)
        {

            int co=0;
            for (int i=0;i<getProfessors().length;i++)
            {
                if(professors[i]!=null)
                {

                    co++;
                    if (getProfessors()[i].equals(professor))
                    {

                        co = -1;break;
                    }

                }
            }

            if(co==getProfessors().length)
            {return;}
            else if (co==-1)
            {return;}
            else if (co>=0 && co<getProfessors().length)
            {

                for(int i=0;i<getProfessors().length;i++)
                {

                    if(getProfessors()[i]==null)
                    {  getProfessors()[i]=professor;

                    break;}}

            }


        }

    }

    /**
     * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
     * or teacher is already employed by the College, nothing changes.
     *
     * @param teacher Teacher to be added to the College's array of teachers
     */
    public void hireTeacher(Teacher teacher) {
         if(teacher!=null)
        {
            int co=0;
            for (int i=0;i<getTeachers().length;i++)
            {
                if(getTeachers()[i]!=null)
                {
                    co++;
                    if (getTeachers()[i].equals(teacher))
                    {
                        co = -1;
                        break;
                    }
                }
            }

            if(co==getTeachers().length)
            {return;}
            else if (co==-1)
            {return;}
            else
            {
                for(int i=0;i<getTeachers().length;i++) {
                    if (getTeachers()[i] == null) {
                        this.getTeachers()[i] = teacher;
                        break;
                    }
                }
            }
        }

    }

    /**
     * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
     * College, or the College cannot add more students, nothing changes.
     *
     * @param student A Student object to be added to the College's array of students.
     */
    public void addStudent(Student student) {
          if(student==null)
        {}

        else {
            int co=0;
            for (int i=0;i<students.length;i++)
            {

                if(students[i]==null)
                {
                    co=i+1;
                    break;
                }
                if(student.getID()==(students[i].getID()))
                {co=-1;
                    break;}

            }
            if(co==students.length)
            {}
            else if (co==-1)
            {}
            else
            {
                this.students[co-1]=student;
            }
        }
    }

    /**
     * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
     * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
     *
     * *HINT* If you try to remove a student from a Course, an exception is thrown. Consider using a try-catch block.
     *
     * @param student Student to be removed from the College's array of students
     */
    public void dropStudent(Student student) {
         if(student==null){
        }


        else {
            if(students!=null) {
                int i;
                boolean check = false;
                for (i = 0; i < students.length; i++) {
                    if (student==students[i]){
                        this.students[i] = null;
                        check =true;

                    }
                }
                if(check)
                { if(student!=null)
                {
                    for(int j=0;j<MAX_COURSES;j++)
                    {
                        try
                        {if(courses[j]!=null)
                        {
                            courses[j].dropStudent(student);}
                        }
                        catch (DropFromCourseException s){continue;}
                    }}
                }}
        }
        if(student==null){
        }


        else {
            if(students!=null) {
                int i;
                boolean check = false;
                for (i = 0; i < students.length; i++) {
                    if (student==students[i]){
                        this.students[i] = null;
                        check =true;

                    }
                }
                if(check)
                { if(student!=null)
                {
                    for(int j=0;j<MAX_COURSES;j++)
                    {
                        try
                        {if(courses[j]!=null)
                        {
                            courses[j].dropStudent(student);}
                        }
                        catch (DropFromCourseException s){continue;}
                    }}
                }}
        }
    }

   
    public int calculateNetBudgetChange() {
        int totaltui=0;

        for (int i=0;i<MAX_STUDENTS;i++)
        {
            if(getStudents()[i]!=null)
            {totaltui=this.tuition+totaltui;}
        }


        int profsal=0;
        for (int i=0;i<MAX_PROFESSORS;i++)
        {
            if (getProfessors()[i]!=null)
        {
            int cou=0;
            profsal=profsal+getProfessors()[i].getBaseSalary();

            for(int j=0;j<getProfessors()[i].getCourses().length;j++)
            {
                if (getProfessors()[i].getCourses()[j]!=null) {
                    cou++;
                }
            }
            for (int k=0;k<cou;k++)
            {
                profsal=profsal+getProfessors()[i].getPerCourseSalary();
            }
        }
        }


        int tesal=0;
        for (int i=0;i<MAX_TEACHERS;i++)
        {
            if (getTeachers()[i]!=null)
        {
            int co=0;
            tesal=tesal+getTeachers()[i].getBaseSalary();
            for(int j=0;j<getTeachers()[i].getCourses().length;j++)
            {
                if (getTeachers()[i].getCourses()[j]!=null)
                {
                    co++;
                }
            }
            for (int k=0;k<co;k++)
            {
                tesal=tesal+getTeachers()[i].getPerCourseSalary();
            }

        }
        }

     return totaltui-profsal-tesal;

    }

   
    public Course[] getCourses()
    {
         return courses;
    }
    public Teacher[] getTeachers()
    {
         return teachers;
    }

    /**
     * @return A reference to the array of Professors employed by this College.
     */
    public Professor[] getProfessors()
    {
         return professors;
    }

    /**
     * @return A reference to the array of Students enrolled at this College.
     */
    public Student[] getStudents()
    {
          return students;
    }

    /**
     * @return The name of the College object
     */
    public String getName() {
       return name;
    }

    /**
     * @return The tuition charged per student
     */
    public int getTuition() {
  return tuition; 
    }
}
