package com.cashfree.springboot.courseapp.service;

import com.cashfree.springboot.courseapp.dao.CourseDao;
import com.cashfree.springboot.courseapp.entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        
        return courseDao.findAll();
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
        // System.out.println("course id is is "+ courseId);
        Course course;
        try{
            course=courseDao.existsById(courseId) ==true ? courseDao.getById(courseId) : null; 
        }
        catch(Exception e)
        {
            return null;
        }
        return course;
    }

    @Override
    public Course addCourse(Course newCourse) {
    
        Course savedCourse=courseDao.save(newCourse);

        return savedCourse;       //returning so that we know what is created
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

        Course course=null;
        try{
            if(courseDao.existsById(courseId) ==true)
            {
                course=courseDao.getById(courseId);
                courseDao.deleteById(courseId); 
            }
             
        }
        catch(Exception e)
        {
            return null;
        }
        return course;

    }

    @Override               //just for ease of random data addition using this method
    public void addCoursesList(List<Course> newCourses) {
        courseDao.saveAll(newCourses);
        
    }
}
