package hu.matekJatek;

import java.util.Scanner;

public class Game {

    private NumberState state;
    private Minimax minimax;

    public Game() {
        state = new NumberState(1, false);
        minimax = new Minimax();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Számgyűjtő játék 20-ig");
        System.out.println("Kezdő szám: 1");
        System.out.println("Cél: pontosan elérni a 20-at");
        System.out.println();

        while (true) {
            System.out.println("Aktuális szám: " + state.getValue());

            if (!state.isAiTurn()) {
                playerMove(scanner);

                if (state.isGoal()) {
                    System.out.println("A játékos elérte a 20-at. A játékos nyert!");
                    break;
                }
            } else {
                aiMove();

                if (state.isGoal()) {
                    System.out.println("Az AI elérte a 20-at. Az AI nyert!");
                    break;
                }
            }

            System.out.println();
        }

        scanner.close();
    }

    private void playerMove(Scanner scanner) {
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Válassz műveletet:");
            System.out.println("1 - +1");
            System.out.println("2 - +2");
            System.out.println("3 - *2");

            while (!scanner.hasNextInt()) {
                System.out.println("Kérlek számot adj meg (1, 2 vagy 3)!");
                scanner.next(); // rossz input törlése
            }
            int choice = scanner.nextInt();
            int value = state.getValue();

            if (choice == 1 && value + 1 <= 20) {
                state = new NumberState(value + 1, true);
                System.out.println("Játékos lépése: +1 -> " + state.getValue());
                validMove = true;
            } else if (choice == 2 && value + 2 <= 20) {
                state = new NumberState(value + 2, true);
                System.out.println("Játékos lépése: +2 -> " + state.getValue());
                validMove = true;
            } else if (choice == 3 && value * 2 <= 20) {
                state = new NumberState(value * 2, true);
                System.out.println("Játékos lépése: *2 -> " + state.getValue());
                validMove = true;
            } else {
                System.out.println("Érvénytelen lépés. Próbáld újra.");
            }
        }
    }

    private void aiMove() {
        System.out.println("AI gondolkodik...");

        Move bestMove = minimax.findBestMove(state, 8);

        if (bestMove != null) {
            state = bestMove.getNextState();
            System.out.println("AI lépése: " + bestMove.getOperation() + " -> " + state.getValue());
        }
    }
}
