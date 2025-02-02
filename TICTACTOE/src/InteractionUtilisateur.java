import java.util.Scanner;

public class InteractionUtilisateur {

    Scanner input = new Scanner(System.in);

    public int inputRow() {
        int row = input.nextInt();
        return row;
    }

    public int inputCol() {
        int col = input.nextInt();
        return col;
    }

    public ModeJeux askUserGameMode(View erreurdesaisie) {
        ModeJeux modeJeu = null;
        do {
            int modeJeuInt;
            modeJeuInt = input.nextInt();

            if (modeJeuInt == 1) {
                modeJeu = ModeJeux.HUMAIN_VS_HUMAIN;
            } else if (modeJeuInt == 2) {
                modeJeu = ModeJeux.HUMAIN_VS_BOT;
            } else if (modeJeuInt == 3) {
                modeJeu = ModeJeux.BOT_VS_BOT;
            } else {
                erreurdesaisie.erreurDeSaisie();

            }

        } while (modeJeu == null);

        return modeJeu;
    }

}


