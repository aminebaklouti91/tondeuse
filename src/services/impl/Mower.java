package services.impl;

import models.Lawn;
import services.MovableService;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class Mower implements MovableService {

    private int x;
    private int y;
    private char orientation;
    private static final Logger log = Logger.getLogger(Mower.class.getName());


    public Mower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    @Override
    public void move(String instructions, Lawn lawn) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    // Pivoter la tondeuse à gauche
                    rotateLeft();
                    break;
                case 'D':
                    // Pivoter la tondeuse à droite
                    rotateRight();
                    break;
                case 'A':
                    // Avancer la tondeuse
                    moveForward(lawn);
                    break;
                default:
                    // Instruction invalide
                    break;
            }
        }
    }

    @Override
    public void rotateLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
        }
    }

   @Override
    public void rotateRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    @Override
    public void moveForward(Lawn lawn) {
        switch (orientation) {
            case 'N':
                if (y < lawn.getHeight()) {
                    y++;
                }
                break;
            case 'E':
                if (x < lawn.getWidth()) {
                    x++;
                }
                break;
            case 'S':
                if (y > 0) {
                    y--;
                }
                break;
            case 'W':
                if (x > 0) {
                    x--;
                }
                break;
        }
    }

    // Méthode pour afficher la position finale de la tondeuse
    @Override
    public void printFinalPosition() {
        log.info(() -> x + " " + y + " " + orientation);
    }
}
