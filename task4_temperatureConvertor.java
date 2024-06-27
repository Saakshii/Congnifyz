package cognizify;
import java.util.Scanner;
public class task4_temperatureConvertor {
        public static void main(String[] args) {
            float celsius, fahrenheit;
            Scanner scan = new Scanner(System.in);

            System.out.println("Choose the option");
            System.out.println("1.To Fahrenheit \n2.To Celsius");
            int choice= scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Temperature in Degree Celcius");
                    celsius = scan.nextFloat();
                    fahrenheit = (9 / 5 * celsius) + 32;
                    System.out.println("Temperature " + celsius+ " degree in Fahrenheit is: " + fahrenheit);
                    break;

                case 2:
                    System.out.println("Enter Temperature in Degree Fahrenheit");
                    fahrenheit = scan.nextFloat();
                    celsius = (5/9 * fahrenheit) - 32;
                    System.out.println("Temperature " + fahrenheit+ " degree in Celsius is: " + celsius);
                    break;

                default:
                    System.out.println("Invalid Option!");

            }
        }
}

