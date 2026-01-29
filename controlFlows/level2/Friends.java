package level2;

import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        int amarHeight = sc.nextInt();
        int akbarHeight = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        if (amarAge < akbarAge && amarAge < anthonyAge)
            System.out.println("Amar is youngest");
        else if (akbarAge < anthonyAge)
            System.out.println("Akbar is youngest");
        else
            System.out.println("Anthony is youngest");

        if (amarHeight > akbarHeight && amarHeight > anthonyHeight)
            System.out.println("Amar is tallest");
        else if (akbarHeight > anthonyHeight)
            System.out.println("Akbar is tallest");
        else
            System.out.println("Anthony is tallest");

        sc.close();
    }
}
