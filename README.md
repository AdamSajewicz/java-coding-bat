# java-coding-bat
In this repo I present my solutions for all the CodingBat excercises.
CodingBat is a set of algorithmic problems, and with them you may practice your Java skills.

Most of them are just copied with its descriptions from the CodingBat page. To run a certain problem, you must do the following:
1. create a static void main method,
2. make the method you'd like to test static as well (see below example)

```java
// main method:

public static void main(String[] args) {
    System.out.println(doubleX("axxbb"));
}

// method under test:

static boolean doubleX(String str) {
    if(str.length() < 2) {
        return false;
    }
    else {
        int indexOfFirstXInstance = str.indexOf('x');
        if(indexOfFirstXInstance == str.length() - 1 || indexOfFirstXInstance == - 1) {
            return false;
        }
        else {
            return str.charAt(indexOfFirstXInstance + 1) == 'x';
        }
    }
}    
```

4. within the main method create manually a set of test data, for instance: an aray of ints, a string, etc. You may use test cases from CodingBat page
5. optionally, you may need add a command at the end of the main method, to print the output to the screen (console) 
6. within the main method invoke the solution-method of your choice, with the prepared data as arguments.

Last step is just to run the program.
