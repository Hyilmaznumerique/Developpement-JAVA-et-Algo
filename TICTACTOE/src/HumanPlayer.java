import java.util.Random;

public class HumanPlayer extends Player {

    private InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();

    public HumanPlayer(String representation) {
        super(representation); // Appeler le constructeur de la classe Player pour assigner la représentation (X ou O)
    }

    // Cette méthode génère un coup aléatoire
    public int[] getMove(Cell[][] board) {
        int row, col;
        System.out.println("Joueur " + getRepresentation() + ", entrez le numéro de la ligne désirée (0-2) :");
        row = interactionUtilisateur.inputRow();
        System.out.println("Joueur " + getRepresentation() + ", entrez le numéro de la colonne désirée (0-2) :");
        col = interactionUtilisateur.inputCol();

        return new int[]{row, col};
    }

}



