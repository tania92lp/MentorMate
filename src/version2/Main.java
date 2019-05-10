package version2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //This is my second optimised algorithm. It works faster than first one.
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextInt()){
            System.out.println("Invalid input: " + "\"" + scanner.nextLine() + "\"-> " + "Input should be ODD number" );
            return;
        }
        Integer number = scanner.nextInt();

        if(number < 2 || number > 10000 || number %2 == 0){
            System.out.println("Input should be ODD number between 2 and 10 000!");
            return;
        }


        String[] result = new String[number +1];

        for (int a = number, b = number, c = number; a > number/2; a--, b+=2, c-=2) {
            StringBuilder upperRow = new StringBuilder();
            StringBuilder bottomRow = new StringBuilder();

            String firstDashes = repeat('-', a);
            String stars = repeat('*', b);
            String innerDashes = repeat('-', c);


            upperRow.append(firstDashes).append(stars).append(innerDashes).append(stars).append(firstDashes);
            upperRow.append(upperRow);
            int index = number-a;
            result[index] = upperRow.toString();


            String fixedStars = repeat('*', number);
            firstDashes = repeat('-', index);
            bottomRow.append(firstDashes).append(fixedStars).append(innerDashes).append(stars).append(innerDashes).append(fixedStars).append(firstDashes);
            bottomRow.append(bottomRow);
            result[number -index] = bottomRow.toString();

        }


        Arrays.stream(result).forEach(row -> System.out.println(row));

    }


    public static String repeat(Character ch, Integer times){
        char[] chars = new char[times];
        Arrays.fill(chars, ch);

        return new String(chars);
    }

}
