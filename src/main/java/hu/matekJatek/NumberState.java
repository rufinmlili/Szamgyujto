package hu.matekJatek;

import java.util.ArrayList;
import java.util.List;


public class NumberState {
    private int value;
    private boolean aiTurn;

    public NumberState(int value, boolean aiTurn) {
        this.value = value;
        this.aiTurn = aiTurn;
    }

    public int getValue() {
        return value;
    }

    public boolean isAiTurn() {
        return aiTurn;
    }

    public boolean isGoal() {
        return value == 20;
    }

    public List<Move> getPossibleMoves() {
        List<Move> moves = new ArrayList<>();

        if (value + 1 <= 20) {
            moves.add(new Move("+1", new NumberState(value + 1, !aiTurn)));
        }

        if (value + 2 <= 20) {
            moves.add(new Move("+2", new NumberState(value + 2, !aiTurn)));
        }

        if (value * 2 <= 20) {
            moves.add(new Move("*2", new NumberState(value * 2, !aiTurn)));
        }

        return moves;
    }

    @Override
    public String toString() {
        return "Aktuális szám: " + value + ", AI következik: " + aiTurn;
    }
}
