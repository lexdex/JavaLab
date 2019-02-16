package tasks.task1;


import menu.Command;

public class PingPongGame implements Command {
    private final Object ball = new Object();

    private void playerOneGame(Player player) {
        synchronized (ball) {
            for (int i = 0; i < 5; i++) {
                try {
                    ball.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                play(player);
                ball.notify();
            }
        }
    }

    private void playerTwoGame(Player player) {
        synchronized (ball) {
            for (int i = 0; i < 5; i++) {
                ball.notify();
                try {
                    ball.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                play(player);
            }
        }
    }

    private void play(Player player) {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int point = player.tryToScore();
        player.addPoint(point);
        System.out.print(player.getName() + (point != 0 ? " That's a Hit Plus Point" : " That's Miss :( Bad Luck"));
        System.out.println(" points: " + player.getPoints());
    }

    @Override
    public void execute() {
        Player playerOne = new Player("Superman");
        Player playerTwo = new Player("Batman");
        Thread t1 = new Thread(() -> playerOneGame(playerOne));
        Thread t2 = new Thread(() -> playerTwoGame(playerTwo));
        t1.setPriority(10);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {/*ignore*/}
        if (playerOne.compareTo(playerTwo) > 0) {
            System.out.println(playerOne.getName() + " WINS!!!");
        } else if (playerOne.compareTo(playerTwo) < 0) {
            System.out.println(playerTwo.getName() + " WINS!!!");
        } else {
            System.out.println("A draw");
        }
        System.out.println("Score: " + playerOne.getPoints() + ":" + playerTwo.getPoints());
    }
}
