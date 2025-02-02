public class Cell {

    private String representation;

    public Cell() {
        representation = " ";  // La case est vide par défaut
    }

    public String getOwner() {
        return representation;  // Retourne le symbole (X, O ou " " si la case est vide)
    }

    public String getRepresentation() {
        return "| " + representation + " ";  // Retourne la case sous forme de "| X |"
    }

    public boolean isEmpty() {
        return representation.equals(" ");  // Vérifie si la case est vide
    }

    public void setOwner(String symbol) {
        if (this.isEmpty()) {
            representation = symbol;  // Assigner le symbole du joueur si la case est vide
        }
    }

    public boolean isOwner(String symbol) {
        return representation.equals(symbol);  // Vérifie si la case appartient au joueur
    }
}
