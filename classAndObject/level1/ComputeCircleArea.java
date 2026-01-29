package level1;

// This class calculates and displays area and circumference of a circle using radius

class ComputeCircleArea {

    double radius;

    void calculate() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    public static void main(String[] args) {
        ComputeCircleArea c = new ComputeCircleArea();
        c.radius = 7;

        c.calculate();
    }
}


