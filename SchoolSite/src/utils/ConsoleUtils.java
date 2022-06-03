package utils;
import menus.Errors;
import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void writeConsoleLine(Object object) {
        System.out.println(object);
    }
    
    public static String readConsoleLine() {
        return scanner.nextLine();
    }
public static int readInteger() {
    	
    	Integer result = null;
    	
    	while (result == null) {
			try {
				result = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				Errors.UnvalidInputError();
			}
		}  
    	return result;
}
}
