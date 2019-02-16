package task3;
import java.util.Arrays;

public class ArrayMagic {
  int[] result;

  public int[] intersection(int[] array1, int[] array2) {
    Arrays.sort(array1);
    Arrays.sort(array2);

    int resultLength = array1.length > array2.length ?
        array2.length : array1.length;

    result = new int[resultLength];

    int firstPointer = 0, secondPointer = 0, resultPointer = 0;

    while(firstPointer < array1.length &&
        secondPointer < array2.length) {

      if(array1[firstPointer] < array2[secondPointer]) {
        firstPointer++;
      } else if(array1[firstPointer] > array2[secondPointer]) {
        secondPointer++;
      } else {
        result[resultPointer] = array1[firstPointer];
        firstPointer++;
        secondPointer++;
        resultPointer++;
      }
    }

    return deleteZeroes(result, resultPointer);
  }

  public int[] symmetricDifference(final int[] array1, final int[] array2) {
    Arrays.sort(array1);
    Arrays.sort(array2);

    int resultLength = array1.length + array2.length;

    int equalNumber = -1;

    result = new int[resultLength];

    int firstPointer = 0, secondPointer = 0, resultPointer = 0;



    while (firstPointer < array1.length &&
        secondPointer < array2.length) {

      if (array1[firstPointer] < array2[secondPointer]) {
        if (array1[firstPointer] != equalNumber) {
          result[resultPointer] = array1[firstPointer];
          resultPointer++;
          firstPointer++;
        }
        else {
          firstPointer++;
        }

      } else if (array1[firstPointer] > array2[secondPointer]) {
        if (array2[secondPointer] != equalNumber) {
          result[resultPointer] = array2[secondPointer];
          secondPointer++;
          resultPointer++;
        }
        else {
          secondPointer++;
        }

      } else {
        equalNumber = array1[firstPointer];
        firstPointer++;
        secondPointer++;
      }
    }

    if (firstPointer == array1.length) {
      for(; secondPointer < array2.length;
          resultPointer++, secondPointer++)  {
        result[resultPointer] = array2[secondPointer];
      }
    } else if (secondPointer == array2.length) {
      for(; firstPointer < array1.length;
          resultPointer++, firstPointer++)  {
        result[resultPointer] = array1[firstPointer];
      }
    }

    return deleteZeroes(result, resultPointer);
  }

  int[] deleteDuplicates(final int[] arrayWithDuplicates) {
    int[] result = new int[arrayWithDuplicates.length];

    Arrays.sort(arrayWithDuplicates);

    int resultPointer = 0;
    int equal = -1;
    int pointer;

    for(pointer = 0; pointer < (arrayWithDuplicates.length - 2);) {
      if(arrayWithDuplicates[pointer] != equal) {
        if(arrayWithDuplicates[pointer] == arrayWithDuplicates[pointer + 1] &&
            arrayWithDuplicates[pointer] == arrayWithDuplicates[pointer + 2]) {
          pointer += 2;
          equal = arrayWithDuplicates[pointer];
        }
        else {
          result[resultPointer] = arrayWithDuplicates[pointer];
          resultPointer++;
          pointer++;
        }
      } else {
        pointer++;
      }
    }

    for(; pointer < arrayWithDuplicates.length; pointer++, resultPointer++) {
      result[resultPointer] = arrayWithDuplicates[pointer];
    }

    return deleteZeroes(result, resultPointer);
  }

  int[] deleteRepeatedSequences(int[] array) {
    int[] result = new int[array.length];

    int resultPointer = 0;

    for(int i = 0; i < array.length - 1; i++) {
      if(array[i] != array[i + 1]) {
        result[resultPointer] = array[i];
        resultPointer++;
      }
    }

    result[resultPointer] = array[array.length - 1];

    return deleteZeroes(result, resultPointer + 1);
  }

  private int[] deleteZeroes(int[] arrayWithZeros, int lengthWithoutZeros) {

    int[] arrayWithoutZeros = new int[lengthWithoutZeros];

    for (int i = 0; i < arrayWithoutZeros.length; i++) {
      arrayWithoutZeros[i] = arrayWithZeros[i];
    }

    return arrayWithoutZeros;

  }
}
