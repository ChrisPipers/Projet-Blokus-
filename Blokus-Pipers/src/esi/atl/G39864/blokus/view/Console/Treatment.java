package esi.atl.G39864.blokus.view.Console;

import esi.atl.gg39864.blokus.model.Board;
import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Player;
import esi.atl.gg39864.blokus.model.PlayerManager;
import esi.atl.gg39864.blokus.model.Position;
import esi.atl.gg39864.blokus.model.Stock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class allows to play the game and treat each element 
 *
 * @author chris home
 */
public class Treatment {

    private final Scanner clavier = new Scanner(System.in);
    private Game game;
    private PlayerManager playerManager;
    private List<String> listCmd = new ArrayList<>();

    /**
     * this is the constructor of Treatment
     */
    public Treatment(Game game, PlayerManager playerManager) {
        this.game = game;
        this.playerManager = playerManager;
    }

    /**
     * this method allows to play with the console mode
     *
     * @param game is the game used for play
     */
    public void playGame(Game game) {
        game = initNamePlayer(game);
        Player currentPlayer = playerManager.getCurrentPlayer();
        while (!game.getEnd()) {
            Display display = new Display();
            display.help();
            List<String> cmd = cmdUser();
            cmdChoise(game, cmd);
            Position position = getPosition(cmd);
            Piece piece = currentPlayer.getStock().getPiece(getNumPiece(cmd));
            game.playConsole(position, piece);
            currentPlayer = playerManager.nextPlayer(currentPlayer);
            position = null;
        }
    }

    /**
     * this method allows to listed the command of a user
     *
     * @return a list with each command of the user
     */
    public List<String> cmdUser() {
        System.out.println("enter your command");

        String cmd = clavier.nextLine();
        cmd += " ";
        System.out.println(cmd);
        listCmd = listingCmd(cmd);
        return listCmd;
    }

    /**
     * this method allows to make the action according with the first parameter
     * enter in her command
     *
     * @param game is the game where make the different action
     * @param listCmdUser is the list of each parameter enter by the player
     */
    public void cmdChoise(Game game, List<String> listCmdUser) {
        int cpt = 0;
        Display display = new Display();

        do {
            switch (listCmdUser.get(0)) {
                case "show":
                    display.toStringBoard(game);
                    break;
                case "stock":
                    display.displayStock(game.getPlayer(2));
                    break;
                case "play":
                    play(game.getBoard(), getNumPiece(listCmdUser), getPosition(listCmdUser),
                            game.getCurrentPlayer().getStock());
                    display.toStringBoard(game);
                    cpt = 1;
                    break;
                case "help":
                    display.help();
                    break;
                case "next":
                    cpt = 1;
                    break;
                case "exit":
                    cpt = 1;
                    game.setEnd();
                    break;
            }
        } while (cpt == 0);

    }

    /**
     * this method take in the number and the name of the play number i
     *
     * @param i is the number of the player to take her name
     * @return a String, this String is the name of the Player
     */
    public String namePlayer(int i) {
        i += 1;
        System.out.println("Player number " + i + " enter your name");
        return clavier.nextLine();
    }

    /**
     * this method put the command of the Player in a list
     *
     * @param cmdUser is the line enter by the player for her choise and action 
     * @return a list of each parameter separate 
     */
    public List<String> listingCmd(String cmdUser) {
        int i = 0;
        int debut = 0;
        List<String> listCmdUser = new ArrayList();
        String stringTemp;
        while (i < cmdUser.length()) {
            stringTemp = Character.toString(cmdUser.charAt(i));
            if (" ".equals(stringTemp)) {

                listCmdUser.add(cmdUser.substring(debut, i));
                debut = i + 1;
            }
            i++;
        }
        return listCmdUser;
    }

    /**
     * this method verify if the command is show, stock, play or help
     */
    public List<String> verifyCmd(List<String> listCmdUser) {
        boolean correct = false;
        do {
            correct = ((listCmdUser.get(0).equals("show"))
                    || (listCmdUser.get(0).equals("stock"))
                    || (listCmdUser.get(0).equals("play"))
                    || (listCmdUser.get(0).equals("help"))
                    || (listCmdUser.get(0).equals("next"))
                    || (listCmdUser.get(0).equals("exit"))
                    || (listCmdUser.get(0).equals("move")));
            if (!correct) {
                System.out.println("enter show, stock, play, help,next, exit or "
                        + "move");
                listCmdUser.set(0, clavier.nextLine());
            }
        } while (!correct);
        if ((listCmdUser.get(0).equals("play"))) {
            listCmdUser = verifyCmdPiece(listCmdUser);
            listCmdUser = verifyCmdPosition(listCmdUser);
        }
        for (String string : listCmdUser) {
            System.out.println(string);
        }
        return listCmdUser;
    }

    /**
     * this method verify if the parameter of the command Play for the number of
     * a Piece is valid
     */
    public List<String> verifyCmdPiece(List<String> listCmdUser) {
        int nbTemp = 0;
        boolean just = (listCmdUser.get(1) == null || listCmdUser.get(1) == "");
        while (!just) {
            System.err.println("enter a enteger");
            listCmdUser.set(1, clavier.nextLine());
            just = (listCmdUser.get(1) == null || listCmdUser.get(1) == "");
        }
        do {
            try {
                nbTemp = Integer.parseInt(listCmdUser.get(1));
            } catch (NumberFormatException e) {
                System.err.println("not a positif enteger enter the number of Piece");
                just = false;
                listCmdUser.set(1, clavier.nextLine());
            }
            just = ((nbTemp >= 0) || (nbTemp < 20));
        } while (!just);
        return listCmdUser;
    }

    /**
     * this method verify if the parameters of the command play for the Position
     * are valid
     */
    public List<String> verifyCmdPosition(List<String> listCmdUser) {

        boolean just = true;
        int i = 0;
        int j = 0;
        just = (listCmdUser.get(2) == null || listCmdUser.get(2) == "");
        while (!just) {
            System.err.println("enter a enteger");
            listCmdUser.set(2, clavier.nextLine());
            just = (listCmdUser.get(2) == null || listCmdUser.get(2) == "");
        }
        just = (listCmdUser.get(3) == null || listCmdUser.get(3) == "");
        while (!just) {
            System.err.println("enter a enteger");
            listCmdUser.set(3, clavier.nextLine());
            just = (listCmdUser.get(3) == null || listCmdUser.get(3) == "");
        }
        do {
            try {
                i = Integer.parseInt(listCmdUser.get(2));
                j = Integer.parseInt(listCmdUser.get(3));
            } catch (NumberFormatException e) {
                just = false;
                System.err.println("not a positif enteger between 0 and 19 " + "\n"
                        + "enter i");
                listCmdUser.set(2, clavier.nextLine());
                System.err.println("enter j");
                listCmdUser.set(2, clavier.nextLine());
            }
            Position position = new Position(i, j);
            just = position.isInside(position);
        } while (!just);
        return listCmdUser;
    }

    /**
     * this method return the first element of the list of the command user
     *
     * @return the first argument of the command user, show, stock, play or help
     */
    public String getCmd(List<String> listCmdUser) {
        return listCmdUser.get(0);
    }

    /**
     * this method return the number of the Piece selectionned by the Player
     * after have choise the command Play
     *
     * @return the number of Piece to choise
     */
    public int getNumPiece(List<String> listCmdUser) {
        return Integer.parseInt(listCmdUser.get(1));
    }

    /**
     * this method return a Position with the two parameter enter for choise
     * where add the Piece in the Board
     *
     * @return a Position where add the Piece
     */
    public Position getPosition(List<String> listCmdUser) {
        int i = Integer.parseInt(listCmdUser.get(2));
        int j = Integer.parseInt(listCmdUser.get(3));
        Position position = new Position(i, j);
        return position;
    }

    /**
     * this method verify the end of game with le List of the Player
     *
     * @param listPalyer is the list of the player where this method analize if
     * the argument of player isBlock return true
     * @return if the game is end or not
     */
    public boolean end(List<Player> listPalyer) {
        boolean end = false;
        int cpt = 0;
        for (Player player : listPalyer) {
            if (player.isBlocked() == true) {
                cpt++;
            }
        }
        if (cpt == 4) {
            end = true;
        }
        return end;
    }

    public Game initNamePlayer(Game game) {
        for (int i = 0; i < 4; i++) {
            System.out.println("enter you name");
            String name = clavier.nextLine();
            game.getListPlayer().get(i).setName(name);
            // lire quelque part ici le fichier
            // game.addPlayer(new Player(name, stock, color, number))

        }
        return game;
    }

    /**
     * this method allows to add a Piece in the Board
     *
     * @param board is the Board where add the Piece
     * @param i is the number of the Piece to add in the Board
     * @param position is the Position where add the Piece
     * @param stock is the Stock where take the Piece number i
     */
    public void play(Board board, int i, Position position, Stock stock) {
         Piece piece = stock.getPiece(i);
            board.addPiece(game, piece, position);
            stock.getListOfStock().remove(piece);
    }
}
