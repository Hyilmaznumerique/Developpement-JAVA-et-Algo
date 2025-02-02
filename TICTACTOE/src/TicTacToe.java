
public class TicTacToe {

    public Player player1;
    public Player player2;
    public Player currentPlayer;
    private View view;

    final int size = 3;  // Taille du plateau de jeu
    Cell[][] board = new Cell[size][size];  // Plateau de jeu

    public TicTacToe(ModeJeux choixAdversaire, View view) {
        this.view = view;
        // Initialiser le plateau de jeu avec des cases vides
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
        }

        // Initialisation des joueurs avec leurs représentations respectives
        if (choixAdversaire.equals(ModeJeux.HUMAIN_VS_HUMAIN)) { // 2 joueurs humains
            player1 = new HumanPlayer("X");
            player2 = new HumanPlayer("O");
        } else if (choixAdversaire.equals(ModeJeux.HUMAIN_VS_BOT)) { // 1 joueur humain et 1 joueur artificiel
            player1 = new HumanPlayer("X");
            player2 = new ArtificialPlayer("O");
        } else { // 2 joueurs artificiel
            player1 = new ArtificialPlayer("X");
            player2 = new ArtificialPlayer("O");
        }
        currentPlayer = player1;  // Le jeu commence avec player1

    }

    // Méthode pour afficher le plateau
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                view.afficherChaqueCase(i, j, board); // Affiche chaque case
            }
            view.nouvelleLigne(); // Nouvelle ligne après chaque ligne du plateau

        }
    }

    // Demander au joueur de faire son coup
    public int[] getMoveFromPlayer() {
        int[] move = new int[2];

        boolean valueNotValid = true;
        // Vérifier si le joueur est un joueur artificiel


        while (valueNotValid) {
            move = currentPlayer.getMove(board);
            int row = 0;
            int col = 0;

            // Vérifier si les coordonnées sont valides et si la case est vide
            if (row >= 0 && row < size && col >= 0 && col < size) {
                if (this.board[row][col].isEmpty()) {
                    valueNotValid = false;  // Si la case est vide, le coup est valide
                }
            }

            if (valueNotValid) {
                view.caseIncorrecte();
            }
        }

        return move;  // Retourne les coordonnées du coup
    }

    // Assigner un symbole à une case du plateau
    public void setCellValue(String representation, int row, int col) {
        this.board[row][col].setOwner(representation);  // Assigner le symbole au joueur courant
    }

    // Vérifier si le plateau est plein
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;  // Si une case est vide, le plateau n'est pas plein
                }
            }
        }
        return true;  // Le plateau est plein
    }

    // Vérifier si 3 pions sont alignés (horizontal, vertical ou diagonal)
    public boolean checkWinner() {
        // Vérification des lignes et des colonnes pour une victoire
        for (int i = 0; i < size; i++) {
            if (board[i][0].getOwner().equals(board[i][1].getOwner()) &&
                    board[i][0].getOwner().equals(board[i][2].getOwner()) && !board[i][0].isEmpty()) {
                return true;
            }
            if (board[0][i].getOwner().equals(board[1][i].getOwner()) &&
                    board[0][i].getOwner().equals(board[2][i].getOwner()) && !board[0][i].isEmpty()) {
                return true;
            }
        }

        // Vérification des diagonales
        if (board[0][0].getOwner().equals(board[1][1].getOwner()) &&
                board[0][0].getOwner().equals(board[2][2].getOwner()) && !board[0][0].isEmpty()) {
            return true;
        }
        if (board[0][2].getOwner().equals(board[1][1].getOwner()) &&
                board[0][2].getOwner().equals(board[2][0].getOwner()) && !board[0][2].isEmpty()) {
            return true;
        }

        return false;  // Retourne false si aucune condition de victoire n'est remplie
    }

    // Méthode pour vérifier si le jeu est terminé (victoire ou match nul)
    public boolean isOver() {
        // Vérifier si quelqu'un a gagné
        if (checkWinner()) {
            return true;  // Victoire
        }
        // Vérifier si le plateau est plein
        if (isBoardFull()) {
            return true;  // Match nul (le plateau est rempli sans gagnant)
        }
        return false;  // Le jeu n'est pas terminé
    }

    // Gérer la logique générale du jeu
    public void play() {
        while (!isOver()) {
            // Demander au joueur courant de faire un coup
            int[] move = getMoveFromPlayer();
            setCellValue(currentPlayer.getRepresentation(), move[0], move[1]);
            display();  // Afficher le plateau après chaque coup

            // Alterner entre les deux joueurs
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        // Le jeu est terminé
        if (checkWinner()) {
            view.verifieGagnant(currentPlayer);
        } else {
            view.matchNul();
        }
    }
}