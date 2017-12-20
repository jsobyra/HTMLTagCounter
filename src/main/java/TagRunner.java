import java.util.Scanner;

public class TagRunner {

    public static void main(String[] args){
        TagCounter tagCounter = new TagCounter();
        Scanner scanner = new Scanner(System.in);
        String command;

        command = scanner.nextLine();
        while (!command.equals("GOODBYE")){
            switch (command){
                case "STORE":
                    System.out.println("Please write url: ");
                    if(tagCounter.store(scanner.nextLine())) System.out.println("Storing was succesful!!!");
                    else System.out.println("Storing was unsuccesful!!!");
                    break;
                case "RETRIEVE":
                    System.out.println("Please write url and tag (url\\ntag): ");
                    System.out.println(tagCounter.retrieve(scanner.nextLine(), scanner.nextLine()));
                    break;
                default:
                    System.out.println("Command given by the user is unknown. Try typing STORE, RETRIEVE or GOODBYE");
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
