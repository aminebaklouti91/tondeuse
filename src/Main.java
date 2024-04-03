import models.Lawn;
import services.MovableService;
import services.impl.Mower;

public class Main {
    public static void main(String[] args) {

        // Lire les données à partir du fichier d'entrée et créer la pelouse et les tondeuses
        Lawn lawn = new Lawn(5, 5);
        MovableService mower1 = new Mower(1, 2, 'N');
        MovableService mower2 = new Mower(3, 3, 'E');

        // Déplacer les tondeuses selon les instructions
        mower1.move("GAGAGAGAA", lawn);
        mower2.move("AADAADADDA", lawn);

        // Afficher la position finale des tondeuses
        ((Mower) mower1).printFinalPosition();
        ((Mower) mower2).printFinalPosition();
    }
    }
