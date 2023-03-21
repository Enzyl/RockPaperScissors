import java.util.Scanner;
public class Player {
    Scanner scan;
    public Player(){
        super();
        scan = new Scanner(System.in);
    }
    public CHOICES getChoice(){
        System.out.println("Please enter your choice: R=ROCK, P=PAPER, S=SCISSORS");
        char playerChoice = scan.nextLine().toUpperCase().charAt(0);

        switch (playerChoice) {
            case 'R':
                return CHOICES.ROCK;
            case 'P':
                return CHOICES.PAPER;
            case 'S':
                return CHOICES.SCISSORS;
        }
        //if neither of the above option, then it is an invalid input
        System.out.println("Invalid input");
        return getChoice();
    }
}
