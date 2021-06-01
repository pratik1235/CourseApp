package com.cashfree.springboot.courseapp.dao;

import com.cashfree.springboot.courseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseDao extends JpaRepository<Course,Long>  //can also extend CrudRepository or PagingAndSorting ...and provide the entity which we want to work on(Course here) and type of the primary key for the entity
{
    

    //the definitions of all the methods inside CrudRepository and hence isnide UserDao are provided by spring-data-jpa.
    //and if we come up with another query method then also we just need to declare it here and spring-data-jpa will itself provide the implementation for
    //some constraints need to be followed for naming our custom methods and for reference see documentation on spring-data-jpa.

    //example of custom methods:
    //List<User> findByRole(String role);

    //************************************* */
    //******so in the service class just create an variable of UserDao and Autowire it and then call methods as userdao.save(new User(...)) or userdao.findById(Id) etc



}




//The above approach is better


// instead of this we can also use class UserDAO with @Repository and @Transaction so that each method is transactional annotation and use entity managers to persist the data 
//example in Ranga's course section 6 step 6 but this the above method is advanced  