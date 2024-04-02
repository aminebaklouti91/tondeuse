package services;

import models.Lawn;

public interface MovableService {
    void move(String instructions, Lawn lawn);
    void rotateLeft();
    void rotateRight();
    void moveForward(Lawn lawn);
    void printFinalPosition();

}
