import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        View view = new View();
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();

        view.choixModeJeux();
        Scanner input = new Scanner(System.in);
        // user inputs mode jeu (1 => HUMAIN_VS_HUMAIN)

        ModeJeux modeJeu = interactionUtilisateur.askUserGameMode(view);

        TicTacToe ticTacToe = new TicTacToe(modeJeu, view);
        ticTacToe.play(); // Démarrer le jeu

    }

}

