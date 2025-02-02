public class View {
    public void choixModeJeux() {
        System.out.println("Choisir le mode de jeux (1/Humain vs Humain, 2/Humain vs Ai, 3/Ai vs Ai)");
    }

    public void erreurDeSaisie() {
        System.out.println("Erreur de saisie, veuillez réessayez.");
    }

    public void afficherChaqueCase(int i, int j, Cell[][] board) {
        System.out.print(board[i][j].getRepresentation());// Affiche chaque case
    }

    public void nouvelleLigne() {
        System.out.print("|\n");  // Nouvelle ligne après chaque ligne du plateau
    }

    public void caseIncorrecte() {
        System.out.println("La case demandée est incorrecte ou occupée, veuillez réessayer.");
    }

    // Le jeu est terminé
    public void verifieGagnant(Player currentPlayer) {
        System.out.println("Joueur " + currentPlayer.getRepresentation() + " a gagné !");
    }

    public void matchNul() {
        System.out.println("Match nul !");
    }


}

