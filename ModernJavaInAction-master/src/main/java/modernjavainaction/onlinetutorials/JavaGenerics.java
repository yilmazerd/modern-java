package modernjavainaction.onlinetutorials;

import org.junit.Test;

public class JavaGenerics {

    public static < T > void printArray( T[] inputArray ) {
        // Display array elements
        for(T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    @Test
    public void main() {
        String[] myString = new String[3];
        myString[0] = "Test1";
        myString[1] = "Test2";
        myString[2] = "Test3";
        printArray(myString);
    }

}
