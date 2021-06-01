package com.cashfree.springboot.courseapp.controller;

import com.cashfree.springboot.courseapp.entity.Course;
import com.cashfree.springboot.courseapp.service.CourseService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;







@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> retrieveAllCourses()
    {
        List<Course> courses=courseService.getAllCourses();       //runtime polymorphism will happen here
        
        return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);

    }
    
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> retrieveCourse(@PathVariable String courseId)
    {
        Course course=courseService.getCourse(courseId);
        if(course==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);      //404 not found
        
        return new ResponseEntity<Course>(course,HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> addCourse(@RequestBody Course newCourse)
    {
        Course course= courseService.addCourse(newCourse);  //returning course so that we know what is created

        if(course==null)
            return ResponseEntity.noContent().build();      //no content returned in response body status =204

        //will take current request uri and append id to it and in place of id newly created courseId will be placed
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId()).toUri();

        //.created will specify the 201 status code= content created also
        return ResponseEntity.created(location).build();        
    }

    // @PutMapping("/")


    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable String courseId)
    {
        Course course=courseService.deleteCourse(courseId);

        if(course==null)
            return ResponseEntity.noContent().build();
        
        return new ResponseEntity<Course>(course,HttpStatus.OK);        //should return deleted item too
    }

}
