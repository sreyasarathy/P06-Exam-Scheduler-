//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Exam Scheduler 
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu
// Lecturer: Professor Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * This particular class contains a collection of static recursive utility methods. 
 * These help create the Exam Schedule for the University 
 */

public class ExamScheduler {
	
/**
 * a valid schedule is returned for the given rooms and courses
 *
 * @param rooms is the rooms array
 * @param courses is the courses array
 *
 * @throws IllegalStateException if the schedule does not exist
 */
	
	
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {
	  
    return findScheduleHelper(new Schedule(rooms, courses), 0);
    
  }

/**
  * A private recursive method which assigns all the unassigned course in the schedule 
  * from the beginning is taken from the array and then provided as an argument
  *
  * @param schedule an object of Schedule
  * @param numCourses the number of courses
  */

  private static Schedule findScheduleHelper(Schedule schedule, int index) {
	  
    if (index == schedule.getNumCourses()) {
    	
      if (schedule.isComplete()) {
    	  
        return schedule;
        
      }
      
      throw new IllegalStateException("This schedule is not complete");
      
    }
    
    if (schedule.isAssigned(index))
    	
      return findScheduleHelper(schedule, index + 1);
    
    else {
    	
      for (int a = 0; a < schedule.getNumRooms(); a++) {
    	  
        try {
        	
          Schedule newSchedule = schedule.assignCourse(index, a);
          
          return findScheduleHelper(newSchedule, index + 1);
          
        } catch (Exception e) {
        	
          System.out.println(e);
          
        }
        
      }
      
      throw new IllegalStateException("This particular schedule does not exist");
      
    }
    
  }
  

/**
 * An ArrayList is returned which contains all the possible schedules for the given 
 * set of rooms and the given set of courses.
 *
 * @param rooms is the rooms array
 * @param courses is the courses array
 */
  
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
	  
    return findAllSchedulesHelper(new Schedule(rooms, courses), 0);
    
  }
  

/**
 * A private recursive method which assigns all the unassigned courses in Schedule in ALL POSSIBLE ways 
 * beginning from the index provided as an argument. An ArrayList is returned. 
 * 
 * @param schedule is the schedule array
 * @param index is getNumCourses 
 */
  
 
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
	  
    ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    
    if (index == schedule.getNumCourses()) {
    	
      if (schedule.isComplete()) {
    	  
        schedules.add(schedule);
        
        return schedules;
        
      }
      
      throw new IllegalStateException("This schedule is not complete");
      
    }
    
    
    if (schedule.isAssigned(index)) {
    	
      schedules.addAll(findAllSchedulesHelper(schedule, index + 1));
      
      return schedules;
      
    } else {
    	
      for (int a = 0; a < schedule.getNumRooms(); a++) {
    	  
        try {
        	
          Schedule newSchedule = schedule.assignCourse(index, a);
          
          schedules.addAll(findAllSchedulesHelper(newSchedule, index + 1));
          
        } catch (Exception e) {
        	
          System.out.println(e);
          
        }
        
      }
      
      return schedules;
      
    }
    
  }
  
}
