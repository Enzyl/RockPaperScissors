import java.util.SortedMap;

public class Game {
    private Player player;
    private Computer computer;
    private CHOICES playerChoice;
    private CHOICES computerChoice;
    private RESULT result;
    private static int wins;
    private static int loses;
    private static int ties;

    public Game() {
        player = new Player();
        computer = new Computer();
    }
    public void play(){
        playerChoice = player.getChoice();
        computerChoice = computer.getChoice();
        result = getResult(playerChoice,computerChoice);
        displayResults();
        stats();
    }

    public void displayStats(){
        System.out.println("You have played "+(wins+loses+ties)+" games");
        System.out.println("You have won "+ wins + " times");
        System.out.println("You have lost "+ loses + " times");
        System.out.println("You have tied "+ ties + " times");

    }

    private void stats(){
        if(result == RESULT.WIN){
            wins++;
        }else if(result == RESULT.LOSE){
            loses++;
        }else{
            ties++;
        }
    }

    private void displayResults(){
        switch (result){
            case WIN:
                System.out.println(playerChoice + " beats " + computerChoice +". Player WINS!");
                break;
            case LOSE:
                System.out.println(playerChoice + " loses to " + computerChoice +". Player LOST!");
                break;
            case TIE:
                System.out.println(playerChoice + " equals to " + computerChoice +". It's a TIE!");
                break;

        }
    }

    private RESULT getResult(CHOICES playerChoice, CHOICES computerChoice){
        if(playerChoice == computerChoice){
            return RESULT.TIE;
        }
        switch (playerChoice){
            case ROCK:
                return (computerChoice == CHOICES.SCISSORS ? RESULT.WIN : RESULT.LOSE);
            case PAPER:
                return (computerChoice == CHOICES.ROCK ? RESULT.WIN : RESULT.LOSE);
            case SCISSORS:
                return (computerChoice == CHOICES.PAPER ? RESULT.WIN : RESULT.LOSE);
        }
        // it will never come to this line because of all above options
        return RESULT.LOSE;
    }
}
