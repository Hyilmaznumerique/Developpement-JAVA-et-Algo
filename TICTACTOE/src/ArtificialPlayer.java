import java.util.Random;

public class ArtificialPlayer extends Player {

    private Random random; // déclaration de random

    public ArtificialPlayer(String representation) {
        super(representation); // Appeler le constructeur de la classe Player pour assigner la représentation (X ou O)
        random = new Random(); // créer une instance de random
    }

    // Cette méthode génère un coup aléatoire
    public int[] getMove(Cell[][] board) {
        int row, col;

        do {
            row = random.nextInt(3); // Génère un numéro de ligne aléatoire entre 0 et 2
            col = random.nextInt(3); // Génère un numéro de ligne aléatoire entre 0 et 2
        } while (board[row][col].isEmpty());
        return new int[]{row, col};
    }

}



