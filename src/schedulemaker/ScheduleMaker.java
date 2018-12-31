
package schedulemaker;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;


/**
 *
 * @author chandlermathews
 */
public class ScheduleMaker {

   public static void main(String[] args) {
       ArrayList<Course> courseList = new ArrayList<Course>();
       Document doc;

       try{

           File input = new File("classes.htm");

           doc = Jsoup.parse(input, "UTF-8", "");

           Elements courseCRNs = doc.getElementsByIndexEquals(5);
           Elements courseNames = doc.getElementsByIndexEquals(7);
           Elements courseDays = doc.getElementsByIndexEquals(8);
           Elements courseTimes = doc.getElementsByIndexEquals(9);
           Elements courseCaps = doc.getElementsByIndexEquals(10);
           Elements courseActs = doc.getElementsByIndexEquals(11);
           Elements courseRems = doc.getElementsByIndexEquals(12);
           Elements courseInstructors = doc.getElementsByIndexEquals(19);
           Elements courseLocations = doc.getElementsByIndexEquals(21);
           Elements courseAttributes = doc.getElementsByIndexEquals(22);

           for(int i = 0; i < courseNames.size(); i++){
               if( (courseNames.get(i).hasClass("dddefault") == true) && (courseNames.get(i).tagName().equals("td") ) ){
                   
                   String courseTime = "00:00 am-00:00 pm";
                   String courseCap = "0";
                   String courseAct = "0";
                   String courseRem = "0";
                   String courseCRN = "0";
                   
                   
                   if(courseCRNs.get(i+2).previousElementSibling().previousElementSibling().previousElementSibling().previousElementSibling().text().length() == 5)
                       courseCRN = courseCRNs.get(i+2).previousElementSibling().previousElementSibling().previousElementSibling().previousElementSibling().text();
                   String courseName = courseNames.get(i).text();
                   String courseDay = courseDays.get(i-1).text();
                   if((courseTimes.get(i-2).text()).length() == 17)
                       courseTime = courseTimes.get(i-2).text();
                   else if((courseTimes.get(i-3).text()).length() == 17)
                       courseTime = courseTimes.get(i-3).text();
                   if(((courseCaps.get(i-2).text()).length() == 1) || ((courseCaps.get(i-2).text()).length() == 2))
                       courseCap = courseCaps.get(i-2).text();
                   else
                       courseCap = courseCaps.get(i).text();
                   if(((courseActs.get(i-2).text()).length() == 1) || ((courseActs.get(i-2).text()).length() == 2))
                       courseAct = courseActs.get(i-2).text();
                   else
                       courseAct = courseActs.get(i).text();
                   
                   if(i != courseNames.size() - 2 && ( ((courseRems.get(i-2).text()).length() <= 4) ) )
                       courseRem = courseRems.get(i-3).text();
                   String courseInstructor = courseInstructors.get(i-2).text();
                   String courseLocation = courseLocations.get(i-2).text();
                   
                   
                   
                   
                   Course currentCourse = new Course(courseCRN, courseName, courseDay, courseTime, courseCap, courseAct, courseRem, courseInstructor, courseLocation);
                   
                   courseList.add(currentCourse);
               }
           }

        }catch(IOException e){

        }
       
       /*for(Course course : courseList){
               //System.out.println(course);
               //System.out.println("Start: " + course.getStartTime() + " End: " + course.getEndTime());
           }*/
       //Ask for days
       String avaliableDays = "";
       Scanner reader = new Scanner(System.in);
       System.out.println("Enter the days in order in which you are avaliable (MTWRF): ");
       avaliableDays = reader.nextLine();
       if(avaliableDays.contains("M"))
       {
           //What times on this day? var = DayTimes
       }
       if(avaliableDays.contains("T"))
       {
           //What times on this day? var = DayTimes
       }
       if(avaliableDays.contains("W"))
       {
           //What times on this day? var = DayTimes
       }
       if(avaliableDays.contains("R"))
       {
           //What times on this day? var = DayTimes
       }
       if(avaliableDays.contains("F"))
       {
           //What times on this day? var = DayTimes
       }
       
       //Make Schedule Method
       //Go through ArrayList, if the current course start time is in between times and has matching days then add it and remove from list
       //Then see if the next matches it and is NOT inbetween other class times
       // do this until equal to four, save schedule, remove classes, go again until all removed or no more matches
    }
    
}
