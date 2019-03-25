package src;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Arrays;

/**
 * Program Name
 *
 * Abstraction of a college course. Each course is uniquely identifiable by its course name.
 */

public class Course {
    /**
     * Maximum number of students allowed to be enrolled in a Course
     */
    protected final static int MAX_STUDENTS = 100;

    private String name;
    private Professor professor;
    private Teacher[] teachers;
    private Student[] students;

    public Course(String name, Professor professor) {
        //TODO: Initialize field variables for this Course object
        this.name = name;
        this.professor = professor;
        this.teachers=new Teacher[5];
        this.students = new Student[MAX_STUDENTS];
        professor.addCourse(this);

    }

    public void addStudent(Student student) throws AddToCourseException {
        if(student==null)
        {
            throw new AddToCourseException();
        }
        int j=0;

        for(int i=0;i<students.length;i++)
        {
            j++;
            if(students[i]==null)
            {break;}
            if (students[i].equals(student))
            {throw new AddToCourseException();
            }

        }
        if(j==students.length)
        {throw new AddToCourseException();}
        if (j<students.length)
        {this.students[j-1]=student;

        }
    }
    public void dropStudent(Student student)throws DropFromCourseException {
        
        if (student == null) {
            throw new DropFromCourseException();
        }

        int i;
        int co=0;
        for (i = 0; i < students.length; i++)
        {
            if(student.equals(students[i]))
            {this.students[i]=null;}
            else
            {co++;}
        }
        if(co==students.length)
        {throw new DropFromCourseException();}

    }

   
    public void addTeacher(Teacher teacher) throws AddToCourseException {
          if(teacher==null)
        {
            throw new AddToCourseException();
        }

        int co=0;
        for(int j=0;j<teachers.length;j++)
        {co++;
            if(teachers[j]==null)
            {break;}
        }
        if (co==teachers.length)
        {
            Teacher[] temp=new Teacher[teachers.length*2];
            for (int i=0;i<teachers.length;i++)
            {
                temp[i]=(teachers[i]);
            }
            temp[teachers.length]=teacher;
            teachers=new Teacher[temp.length];
            for (int i=0;i<teachers.length;i++)
            {
                this.teachers[i]=(temp[i]);
            }
            int c=0;
            for(int i=0;i<teacher.getCourses().length;i++)
            {if(teacher.getCourses()[i]!=null)
            {c++;}
            }
            if(c==teacher.getCourses().length)
            { throw new AddToCourseException();}
           else{ teacher.addCourse(this);}

        }
        else
        {
            for (int i=0;i<teachers.length;i++)
            {
                if (teachers[i]==null)
                { this.teachers[i]=teacher;
                    teacher.addCourse(this);
                    break;
                }
            }

        }
}
    public void dropTeacher(Teacher teacher)throws DropFromCourseException{
            if (teacher == null) {
            throw new DropFromCourseException();
        }
        int i;
        int co=0;
        if (teachers==null)
        {throw new DropFromCourseException();}
        for (i=0;i<teachers.length;i++)
        {
            if(teacher.equals(teachers[i]))
            {}
            else
            {co++;}
        }
        if(co==teachers.length)
        {throw new DropFromCourseException();}

        for (i = 0; i < teachers.length; i++)
        {
            if(teacher.equals(teachers[i]))
            {
                teachers[i].dropCourse(this);
                this.teachers[i]=null;
                break;}
        }


    }

  
    public Professor getProfessor()
    {
            return professor;
    }

    public Student[] getRoster() {
         int co=0;
        for(int i=0;i<students.length;i++)
        {
            if(students[i]!=null)
            {
                co++;
            }
        }
        int c=0;
        Student[] ros=new Student[co];
        for(int i=0;i<students.length;i++)
        {
            if(students[i]!=null)
            {
                ros[c++]=students[i];
            }
        }

        return ros;
    }

    public String getName() {
          return name;
    }

  
    public Teacher[] getTeachers() {
        int co=0;
        for(int i=0;i<teachers.length;i++)
        {
            if(teachers[i]!=null)
            {
                co++;
            }
        }
        int c=0;
        Teacher[] ros=new Teacher[co];
        for(int i=0;i<teachers.length;i++)
        {
            if(teachers[i]!=null)
            {
                ros[c++]=teachers[i];
            }
        }

        return ros;

    }

    /**
     * Makes professor the Course professor and updates the old and new Professors involved accordingly.
    */
    public void changeProfessor(Professor professor) {
         this.professor.dropCourse(this);
        professor.addCourse(this);

        this.professor=professor;


    }
    public String toString() {
        return "";
    }
}
