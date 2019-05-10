package version1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //This was my firs solution. Algorithm works with small input numbers, but at border case with 9999 get OutOfMemoryError:
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

        StringBuilder result = new StringBuilder();

        int dashes = number;

        for (int i = number; i < 2*number; i+=2) {
            StringBuilder row = new StringBuilder();

            row.append(repeat("-", dashes))
                    .append(repeat("*", i))
                    .append(repeat("-", 2*number - i))
                    .append(repeat("*", i))
                    .append(repeat("-", dashes));

            row.append(row).append(System.lineSeparator());
            result.append(row);
            dashes--;
        }

        for (int i = 1; i <= number; i+=2) {
            StringBuilder row = new StringBuilder();

            row.append(repeat("-", dashes))
                    .append(repeat("*", number))
                    .append(repeat("-", i))
                    .append(repeat("*", 2* number - i))
                    .append(repeat("-", i))
                    .append(repeat("*", number))
                    .append(repeat("-", dashes));


            row.append(row).append(System.lineSeparator());
            result.append(row);
            dashes--;
        }

        System.out.println(result.toString());
    }


    public static String repeat(String word, Integer times){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
             result.append(word);
        }

        return result.toString();
    }

}
