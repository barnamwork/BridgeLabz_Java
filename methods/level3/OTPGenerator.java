package level3;

public class OTPGenerator {

    // 1. Generate 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    // 2. Check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // Generate OTPs
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        // Display OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        // Check uniqueness
        if (areOTPsUnique(otpArray))
            System.out.println("\nAll OTPs are UNIQUE");
        else
            System.out.println("\nDuplicate OTPs found");
    }
}

