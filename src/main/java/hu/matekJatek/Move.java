package hu.matekJatek;

public class Move {
    private String operation;
    private NumberState nextState;

    public Move(String operation, NumberState nextState) {
        this.operation = operation;
        this.nextState = nextState;
    }

    public String getOperation() {
        return operation;
    }

    public NumberState getNextState() {
        return nextState;
    }
}
