package level1;

public class VolOfEarth {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int earthRadius=6378;
        double earthRadiusMiles =  6378/1.6;
        double volumeKM = (double)4/3 * (double)22/7 *earthRadius*earthRadius*earthRadius;
        double volumeMiles = (double)4/3 * (double)22/7 *earthRadiusMiles*earthRadiusMiles*earthRadiusMiles;

        System.out.println("The volume of earth in cubic kilometers is "+ volumeKM + " and cubic miles is "+ volumeMiles);

    }

}

