package stackqueuehashmap;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxFrequencyChar {

    public static void main(String[] args) {

        String str = "banana";

        HashMap<Character, Integer> freqMap = new HashMap<>();

        // ---------- PHASE 1: Count frequency ----------
        for (char ch : str.toCharArray()) {

            // getOrDefault handles first occurrence safely
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // ---------- PHASE 2: Find max frequency ----------
        char maxChar = '\0';
        int maxFreq = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {

            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        System.out.println("Character with max frequency: " + maxChar);
        System.out.println("Frequency: " + maxFreq);
    }
}

