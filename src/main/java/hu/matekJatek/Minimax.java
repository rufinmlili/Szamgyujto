package hu.matekJatek;

public class Minimax {

    public int minimax(NumberState state, int depth) {

        if (state.isGoal()) {
            if (state.isAiTurn()) {
                return -1;
            } else {
                return 1;
            }
        }

        if (depth == 0) {
            return 0;
        }

        if (state.isAiTurn()) {
            int bestValue = Integer.MIN_VALUE;

            for (Move move : state.getPossibleMoves()) {
                int value = minimax(move.getNextState(), depth - 1);
                bestValue = Math.max(bestValue, value);
            }

            return bestValue;
        } else {
            int bestValue = Integer.MAX_VALUE;

            for (Move move : state.getPossibleMoves()) {
                int value = minimax(move.getNextState(), depth - 1);
                bestValue = Math.min(bestValue, value);
            }

            return bestValue;
        }
    }

    public Move findBestMove(NumberState state, int depth) {
        Move bestMove = null;
        int bestValue = Integer.MIN_VALUE;

        for (Move move : state.getPossibleMoves()) {
            int value = minimax(move.getNextState(), depth - 1);

            System.out.println("AI vizsgálja: "
                    + move.getOperation()
                    + " -> "
                    + move.getNextState().getValue()
                    + " | érték: "
                    + value);

            if (value > bestValue) {
                bestValue = value;
                bestMove = move;
            }
        }

        return bestMove;
    }
}
