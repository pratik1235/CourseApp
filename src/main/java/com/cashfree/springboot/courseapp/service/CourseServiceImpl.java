package com.cashfree.springboot.courseapp.service;

import com.cashfree.springboot.courseapp.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;





@Service
public class CourseServiceImpl implements CourseService{


    

    private static List<Course> courses = new ArrayList<Course>(){{add(new Course(123456L,"Java","OOPS SDE"));
                                    add(new Course(123457L,"C++","OS EMBEDDED SYSTEMS"));
                                    add(new Course(123458L,"LATEX","PDF"));
                                    add(new Course(123459L,"JS","WEBDEV"));
                                    add(new Course(123460L,"PYTHON","ML BACKEND"));
                                    add(new Course(123461L,"HTML","WEB MARKUP"));}};

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public Course getCourse(String id){

        Long courseId =null;

        try{
            courseId=Long.valueOf(id);
        }
        catch(NumberFormatException nfe){
            return null;
        }
        
        for(Course course: courses)
        {
            if(course.getId().equals(courseId))
                return course;
        }
        return null;
    }

    @Override
    public Course addCourse(Course newCourse) {
        
        Long randomId= new Random().nextLong();
        newCourse.setId(randomId);
        courses.add(newCourse);
        return newCourse;       //returning so that we know what is created
    }

    @Override
    public Course deleteCourse(String id) {
        
        Long courseId =null;

        try{
            courseId=Long.valueOf(id);
        }
        catch(NumberFormatException nfe){
            return null;
        }

        Course deletedCourse ;
        for(Course course: courses)
        {
            if(course.getId().equals(courseId))
                {
                    deletedCourse= course;
                    courses.remove(deletedCourse);
                    return deletedCourse;
                }
        }

        return null;

    }
}
