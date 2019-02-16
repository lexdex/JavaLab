package droid.battle;

import droid.BattleDroid;
import droid.Droid;
import engine.Menu;

public class Battle {
    private static int superAttackCount;

    private Droid player;
    private Droid enemy;

    public Battle() {

    }

    public Battle(Droid player, Droid enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void playerAttack() {
        int hitPoints = player.attack(enemy);
        System.out.println(Menu.ANSI_RED + "Player set " + hitPoints + " of damage. (Simple attack)" + Menu.ANSI_RESET);
        System.out.println("Enemy characteristics after course:");

        enemy.defence(hitPoints);
        if (enemy.isAlive() == false) {
            System.out.println(Menu.ANSI_CYAN +"My congratulation, you win!" + Menu.ANSI_RESET);
        } else return;
    }

    public void playerSuperAttack() {
        if (superAttackCount >= 2) {
            System.out.println(Menu.ANSI_RED + "You can`t use super attack anymore." + Menu.ANSI_RESET);
            playerAttack();
            return;
        } else {
            superAttackCount++;
            int hitPoints = player.superAttack(enemy);
            System.out.println(Menu.ANSI_RED + "Player set " + hitPoints + " of damage. (Super attack)" + Menu.ANSI_RESET);
            System.out.println("Enemy characteristics after course:");

            enemy.defence(hitPoints);
            if (enemy.isAlive() == false) {
                System.out.println(Menu.ANSI_CYAN +"My congratulation, you win!" + Menu.ANSI_RESET);
            } else return;
        }
    }

    public void enemyAttack() {
        int hitPoints = enemy.attack(player);
        System.out.println(Menu.ANSI_RED + "Enemy set " + hitPoints + " of damage. (Simple attack)" + Menu.ANSI_RESET);
        System.out.println("Player characteristics after course:");

        player.defence(hitPoints);
        if (player.isAlive() == false) {
            System.out.println(Menu.ANSI_CYAN + "You was defeated" + Menu.ANSI_RESET);
        } else return;
    }

    public void enemySuperAttack() {
        int hitPoints = enemy.superAttack(player);
        System.out.println(Menu.ANSI_RED + "Enemy set " + hitPoints + " of damage. (Super attack)" + Menu.ANSI_RESET);
        System.out.println("Player characteristics after course:");

        player.defence(hitPoints);
        if (player.isAlive() == false) {
            System.out.println(Menu.ANSI_CYAN + "You was defeated" + Menu.ANSI_RESET);
        } else return;
    }

    public boolean enemyIsAlive() {
        if (enemy.isAlive() == true) {
            return true;
        }
        return false;
    }

    public boolean playerIsAlive() {
        if (player.isAlive() == true) {
            return true;
        }
        return false;
    }
}
