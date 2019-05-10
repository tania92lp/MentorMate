package version3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Simple OOP representation of problem. The algorithm is the same like version2
        Scanner scanner = new Scanner(System.in);

        try{
            Integer size = scanner.nextInt();
            Figure figure = new Figure(size);
            figure.print();
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Invalid input! Enter a positive ODD number.");
        }

    }
}
