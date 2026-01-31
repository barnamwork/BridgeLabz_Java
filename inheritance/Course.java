package inheritance;

public class Course {
    String courseName;
    double duration;
    Course(String courseName, double duration){
        this.courseName=courseName;
        this.duration=duration;
    }
    void displayDetails(){
        System.out.println("Coursename : " + courseName);
        System.out.println("Duration : " + duration);
    }

    public static void main() {
        Course course = new Course("calisthenics", 20);
        OnlineCourse onlinecourse = new OnlineCourse("Online Course", 40, "PhysicsWallah", true);
        PaidOnlineCourse paidonlinecourse = new PaidOnlineCourse("Paid Course", 60, "BridgeLabz", true, 45000, 10 );

        course.displayDetails();
        System.out.println();
        onlinecourse.displayDetails();
        System.out.println();
        paidonlinecourse.displayDetails();
    }

}
class OnlineCourse extends Course {
    String platform;
    Boolean isRecorded;
    OnlineCourse(String courseName, double duration, String platform, Boolean isRecorded){
        super(courseName, duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }

    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("isRecorded: " + isRecorded);
    }
}
class PaidOnlineCourse extends OnlineCourse{
    double fee;
    double discount;
    PaidOnlineCourse(String courseName, double duration, String platform, Boolean isRecorded, double fee, double discount){
        super(courseName, duration, platform, isRecorded);
        this.fee=fee;
        this.discount=discount;
    }
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount);
    }

}

