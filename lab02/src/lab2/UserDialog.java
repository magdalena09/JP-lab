package lab2;

import java.util.Scanner;

public class UserDialog {
    private final Scanner scanner = new Scanner(System.in);

    public String enterString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int enterInt(String prompt) {
        boolean isError;
        int i = 0;
        do{
            isError = false;
            try{
                i = Integer.parseInt(enterString(prompt));
            } catch(NumberFormatException e){
                System.err.println("Błąd");
                isError = true;
            }
        }while(isError);
        return i;
    }
}
