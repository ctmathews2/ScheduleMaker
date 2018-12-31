
package schedulemaker;

/**
 *
 * @author chandlermathews
 */
public class Course {
    String CRN;
    String name;
    String days;
    String time;
    int timeStart;
    int timeEnd;
    String cap;
    String act;
    String rem;
    String instructor;
    String location;
    String attribute;
    
    public Course(String CRN, String name, String days, String courseTime, String cap, String act, String rem, String instructor, String location){
        this.CRN = CRN;
        this.name = name;
        this.days = days;
        this.time = courseTime;
        this.timeStart = splitTime(courseTime, "start");
        this.timeEnd = splitTime(courseTime, "end");
        this.cap = cap;
        this.act = act;
        this.rem = rem;
        this.instructor = instructor;
        this.location = location;
        this.attribute = attribute;
        
    }
    
    public int splitTime(String courseTime, String startOrEnd){
        int time = 0;
        if(startOrEnd.equals("start")){
            //System.out.println(courseTime.substring(0,2));
            time = Integer.parseInt(courseTime.substring(0,2) + courseTime.substring(3,5));
            if(courseTime.substring(6,8).equals("pm") && time <= 1200)
                time += 1200;
        }else{
            time = Integer.parseInt(courseTime.substring(9,11) + courseTime.substring(12,14));
            if(courseTime.substring(15,17).equals("pm") && time <= 1200)
                time += 1200;
        }
        return time;
    }
    
    public int getStartTime(){
        return this.timeStart;
    }
    
    public int getEndTime(){
        return this.timeEnd;
    }
    
    @Override
    public String toString(){
        return "Name: " + this .name + " Days: " + this.days + " Time: " + this.time + " Cap: " + this.cap + " Act: " + this.act + " Rem: " + this.rem + " Instructor: " + this.instructor + " Location: " + this.location +  " CRN: " + this.CRN;
    }
}
