package novosad;

import java.util.Random;

public class Game {
  int[] doors;
  private Person person;
  private int deadEnd;

  public Game() {
    doors = new int[10];
    person = new Person();
    deadEnd = 0;
  }

  public void fillDoors() {
    Random rand = new Random();
    boolean isEnemy;

    for (int i = 0; i < doors.length; i++) {
      isEnemy = rand.nextBoolean();

      if (isEnemy) {
        doors[i] = - (5 + rand.nextInt(96));
      } else {
        doors[i] = 10 + rand.nextInt(71);
      }
    }

    System.out.println("Doors");
    for(int i = 0; i < doors.length; i++) {
      System.out.println("| Door " + (i + 1) + " | " + doors[i] + " | ");
    }

    System.out.println("Deadends: " + countDeadEnds(0));
    getWinningCombination();
  }

  public int countDeadEnds(int doorNumber) {

    if (doorNumber == doors.length) {
      return 0;
    }

    if(doors[doorNumber] + person.getStrength() < 0) {
      return (1 + countDeadEnds(++doorNumber));
    } else {
      return countDeadEnds(++doorNumber);
    }
  }

  public void getWinningCombination() {
    int[] doorNumbers = new int[doors.length];
    int firstDoorNumber = 0;
    int lastDoorNumber = doorNumbers.length - 1;

    if (canWin()) {

      for (int i = 0; i < doors.length; i++) {
        if (doors[i] + person.getStrength() > 0) {
          person.setStrength(person.getStrength() + doors[i]);
          doorNumbers[firstDoorNumber] = i;
          firstDoorNumber++;
        } else {
          doorNumbers[lastDoorNumber] = i;
          lastDoorNumber--;
        }
      }

      for(int elem : doorNumbers) {
        System.out.print(elem + 1 + " ");
      }
    } else {
      System.out.println("You will be dead anyway!");
    }

  }

  private boolean canWin() {
    boolean canWin;
    int sum = 0;

    for(int elem : doors) {
      sum += elem;
    }

    System.out.println(sum);

    canWin = sum + person.getStrength() >= 0;

    return canWin;
  }


  public static class ArrayDo {
    public static void main(String[] args) {
      int[] array1 = {1,1,2,2,2,2,3,4,4,4,5,6};
      int[] array2 = {2,2,3,4,4,5,7};

     Game game = new Game();
      game.fillDoors();
    }
  }
}
