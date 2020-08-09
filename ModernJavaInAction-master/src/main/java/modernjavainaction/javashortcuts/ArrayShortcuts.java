package modernjavainaction.javashortcuts;

import java.util.stream.IntStream;

public class ArrayShortcuts {


    public void howToCreateArrays(){

        int[] myIntArray = new int[3];

        int[] myIntArray2 = {1, 2, 3};

        int[] myIntArray3 = new int[]{1, 2, 3};

        int [] myIntArray4 = IntStream.range(0, 100).toArray(); // From 0 to 99

        int [] myIntArray5 = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100

        int [] myIntArray6 = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.

        int [] myIntArray7 = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort

    }

    public void arrayOperations(){

        int[] myIntArray = new int[3];
        //Find length of an array
        int myArrayLength = myIntArray.length;
        String values = "test";
        // divide a string into array
        String[] array = values.split("");

    }

}
