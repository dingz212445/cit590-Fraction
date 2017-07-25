package fraction;

import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        Fraction currentValue = new Fraction(0);
        System.out.println("Calculator starts!");
        System.out.println("Current value: " + currentValue);
        System.out.print("Command: ");
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        
        while(command.charAt(0) != 'q') {
            switch (command.charAt(0)) {
            case 'a':
                currentValue = currentValue.abs();
                break;
            case 'c':
                currentValue = new Fraction(0);
                break;
            case 'i':
                currentValue = currentValue.inverse();
                break;
            case 's':
                currentValue = new Fraction(command.substring(1).trim());
                break;
            case '+':
                currentValue = currentValue.add(new Fraction(command.substring(1).trim()));
                break;
            case '-':
                currentValue = currentValue.subtract(new Fraction(command.substring(1).trim()));
                break;
            case '*':
                currentValue = currentValue.multiply(new Fraction(command.substring(1).trim()));
                break;
            case '/':
                currentValue = currentValue.divide(new Fraction(command.substring(1).trim()));
                break;
            }
            System.out.println("Current value: " + currentValue);
            System.out.println("New command: ");
            command = input.nextLine();
        } 
        
        input.close();
        
        System.out.println("Calculation over!");
    }

}
