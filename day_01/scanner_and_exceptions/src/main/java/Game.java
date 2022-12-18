public interface Game {

    boolean isRunning();
    String start();
    String promptForGuess();
    String processGuess(String guess) throws Exception;

}
