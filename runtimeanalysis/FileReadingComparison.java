package algorithms;
import java.io.*;

class FileReadingComparison {

    /*
     * Counts words from a BufferedReader
     */
    static int countWords(BufferedReader br) throws Exception {

        int count = 0;
        String line;

        // Read file line by line
        while ((line = br.readLine()) != null) {

            // Split line into words using whitespace
            String[] words = line.split("\\s+");
            count += words.length;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        /* ============ FileReader ============ */

        long start = System.nanoTime();

        // FileReader reads characters directly
        BufferedReader br1 =
                new BufferedReader(new FileReader("largefile.txt"));

        System.out.println("Words (FileReader): " +
                countWords(br1));

        System.out.println("FileReader Time: " +
                (System.nanoTime() - start) + " ns");

        br1.close();

        /* ============ InputStreamReader ============ */

        start = System.nanoTime();

        // InputStreamReader converts byte stream to character stream
        BufferedReader br2 =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("largefile.txt")));

        System.out.println("Words (InputStreamReader): " +
                countWords(br2));

        System.out.println("InputStreamReader Time: " +
                (System.nanoTime() - start) + " ns");

        br2.close();
    }
}

