package level1;

public class WindChill {
    public static double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp +
                (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        double temp = Double.parseDouble(args[0]);
        double windSpeed = Double.parseDouble(args[1]);

        System.out.println("Wind Chill = " + calculateWindChill(temp, windSpeed));
    }
}
