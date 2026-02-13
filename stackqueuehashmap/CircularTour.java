package stackqueuehashmap;
/*
Circular Tour / Petrol Pump Problem
Time Complexity: O(n)
*/
class CircularTour {

    static int findStartPoint(int[] petrol, int[] distance) {

        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < petrol.length; i++) {

            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, reset start
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        // Check if total petrol is enough
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        System.out.println(findStartPoint(petrol, distance)); // Output: 2
    }
}

