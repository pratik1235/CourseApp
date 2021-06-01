package com.cashfree.springboot.courseapp.service;

import com.cashfree.springboot.courseapp.entity.Course;
import java.util.List;


public interface CourseService {        //interface used for loose coupling
    
    public List<Course> getAllCourses();
    public Course getCourse(String courseId);
    public Course addCourse(Course newCourse);
    public Course deleteCourse(String courseId);

}
