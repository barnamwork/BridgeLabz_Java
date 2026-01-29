package level1;

public class DividePen {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int countPen=14;
        int student=3;
        int perStudent=countPen/student;
        int remaining = countPen%student;
        System.out.println("The Pen Per Student is " + perStudent + " and the remaining pen not distributed is "+ remaining);

    }

}
