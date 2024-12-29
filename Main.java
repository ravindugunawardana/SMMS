import java.util.Scanner;

public class Main {
    static int studentIDs[] = new int[0];
    static String studentNames[] = new String[0];
    static int programmingFundamentalMarks[] = new int[0];
    static int dbmsMarks[] = new int[0];

    public static void main(String args[]) {

        String menuView = ("|-----------------------------------------------------------------------------------------|\n"
                + "|                        WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                          |\n"
                + "|-----------------------------------------------------------------------------------------|\n\n"
                + "[1] Add new student                         [2] Add New Student With Marks\n"
                + "[3] Add Marks                               [4] Update Student Details\n"
                + "[5] Update Marks                            [6] Delete Student\n"
                + "[7] Print Student Details                   [8] Print Student Ranks\n"
                + "[9] Best in Programming Fundamentals        [10] Best in Database Management System\n\n"
                + "Enter an option to continue : ");

        Scanner scanner = new Scanner(System.in);

        int menuSelection = 0;

        do {
            clearConsole();
            System.out.println();
            System.out.print(menuView);
            menuSelection = scanner.nextInt();
            System.out.println();

            switch (menuSelection) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addNewStudentWithMarks();
                    break;
                case 3:
                    addMarks();
                    break;
                case 4:
                    updateStudentDetails();
                    break;
                case 5:
                    updateMarks();
                    break;
                case 6:
                    deletStudent();
                    break;
                case 7:
                    printStudentDetails();
                    break;
                case 8:
                    printStudentRanks();
                    break;
                case 9:
                    printBestInProgrammingFundamentals();
                    break;
                case 10:
                    printBestInDatabaseManagementSystem();
                    break;

                default:
                    break;
            }
        } while (menuSelection != 0);
        scanner.close();
    }

    public static int[] growIntArray(int[] oldArr) {
        int[] newArr = new int[oldArr.length + 1];

        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }

        return newArr;
    }

    public static int[] addElementToIntArray(int[] ar, int v) {
        ar = growIntArray(ar);
        ar[ar.length - 1] = v;

        return ar;
    }

    public static String[] growStringArray(String[] oldArr) {
        String[] newArr = new String[oldArr.length + 1];

        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }

        return newArr;
    }

    public static String[] addElementToStringArray(String[] ar, String v) {
        ar = growStringArray(ar);
        ar[ar.length - 1] = v;
        return ar;
    }

    public static void addNewStudent() {
        String input;

        do {
            System.out.println("ADD NEW STUDENT");
            Scanner studentInput = new Scanner(System.in);

            int studentId;
            int i;
            boolean isExist;

            do {
                isExist = false;
                System.out.print("Enter Student ID    : ");
                studentId = studentInput.nextInt();

                for (i = 0; i < studentIDs.length; i++) {
                    if (studentIDs[i] == studentId) {
                        System.out.println("The Student ID already exists");
                        isExist = true;
                    }

                }

            } while (isExist == true && studentIDs.length > 0);

            studentIDs = addElementToIntArray(studentIDs, studentId);
            programmingFundamentalMarks = growIntArray(programmingFundamentalMarks);
            dbmsMarks = growIntArray(dbmsMarks);

            System.out.print("Enter Student Name    : ");
            String studentName = studentInput.next();

            studentNames = addElementToStringArray(studentNames, studentName);

            System.out.print("Student has been added sucessfully. Do you want to add a new student(Y/n): ");

            input = studentInput.next();

        } while (input.equals("Y"));
    }

    public static void addNewStudentWithMarks() {
        String input;

        do {
            System.out.println("ADD NEW STUDENT WITH MARKS");
            Scanner studentInput = new Scanner(System.in);

            int studentId;
            int i;
            boolean isExist;

            do {
                isExist = false;
                System.out.print("Enter Student ID    : ");
                studentId = studentInput.nextInt();

                for (i = 0; i < studentIDs.length; i++) {
                    if (studentIDs[i] == studentId) {
                        System.out.println("The Student ID already exists");
                        isExist = true;
                    }

                }

            } while (isExist == true && studentIDs.length > 0);

            studentIDs = addElementToIntArray(studentIDs, studentId);
            programmingFundamentalMarks = growIntArray(programmingFundamentalMarks);
            dbmsMarks = growIntArray(dbmsMarks);

            System.out.print("Enter Student Name    : ");
            String studentName = studentInput.next();
            studentNames = addElementToStringArray(studentNames, studentName);

            Scanner studentWithMarksInput = new Scanner(System.in);
            int programmingFundamentalMark;
            int dbmsMark;

            do {
                System.out.print("Programming Fundamentals Marks : ");
                programmingFundamentalMark = studentWithMarksInput.nextInt();
                if (!(programmingFundamentalMark > 0 && programmingFundamentalMark < 100)) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (!(programmingFundamentalMark > 0 && programmingFundamentalMark < 100));

            int k = programmingFundamentalMarks.length - 1;
            programmingFundamentalMarks[k] = programmingFundamentalMark;

            do {
                System.out.print("Database Management System Marks : ");
                dbmsMark = studentWithMarksInput.nextInt();
                if (!(dbmsMark > 0 && dbmsMark < 100)) {
                    System.out.println("Invalid marks, please enter correct marks.");
                }

            } while (!(dbmsMark > 0 && dbmsMark < 100));

            int j = dbmsMarks.length - 1;
            dbmsMarks[j] = dbmsMark;

            System.out.print("Student has been added successfully. Do you want to add a new student(Y/n): ");

            input = studentInput.next();

        } while (input.equals("Y"));
    }

    public static void addMarks() {
        String userInput;
        int studentId;

        System.out.println("ADD MARKS");

        do {
            int i;
            boolean isExist = false;
            int index = 0;

            System.out.print("Enter Student ID: ");
            Scanner studentInput = new Scanner(System.in);
            studentId = studentInput.nextInt();

            for (i = 0; i < studentIDs.length; i++) {
                if (studentIDs[i] == studentId) {
                    index = i;
                    isExist = true;
                }
            }

            if (isExist) {
                int programmingFundamentalMark;
                int dbmsMark;
                System.out.println("Student Name: " + studentNames[index]);

                if (programmingFundamentalMarks[index] > 0 && dbmsMarks[index] > 0) {
                    System.out.print(
                            "This student's marks have been already added.\n"
                                    + "If you want to update the marks, please use [4] Update Marks option.\n\n"
                                    + "Do you want to add marks for another student?: ");
                    userInput = studentInput.next();
                    if (userInput.equals("Y")) {
                        continue;
                    } else {
                        break;
                    }
                }

                do {
                    System.out.print("Programming Fundamentals Marks: ");
                    programmingFundamentalMark = studentInput.nextInt();
                    if (!(programmingFundamentalMark > 0 && programmingFundamentalMark < 100)) {
                        System.out.print("Invalid marks, please enter correct marks.");
                    }
                } while (!(programmingFundamentalMark > 0 && programmingFundamentalMark < 100));

                programmingFundamentalMarks[index] = programmingFundamentalMark;

                do {
                    System.out.print("Database Management System Marks: ");
                    dbmsMark = studentInput.nextInt();
                    if (!(dbmsMark > 0 && dbmsMark < 100)) {
                        System.out.print("Invalid marks, please enter correct marks.");
                    }
                } while (!(dbmsMark > 0 && dbmsMark < 100));

                dbmsMarks[index] = dbmsMark;
                System.out.print("Marks have been added. Do you want to add marks for another student(Y/n): ");
                userInput = studentInput.next();

            } else {
                System.out.print("Invalid Student ID. Do you want to search again? Y/n(): ");
                userInput = studentInput.next();
            }

        } while (userInput.equals("Y"));

    }

    public static void updateStudentDetails() {
        System.out.println("UPDATE STUDENT DETAILS");
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int studentId;
        String newStudentName;

        do {
            boolean isExist = false;
            int index = 0;

            System.out.print("Enter Student ID: ");
            studentId = userInput.nextInt();

            for (int i = 0; i < studentIDs.length; i++) {
                if (studentIDs[i] == studentId) {
                    index = i;
                    isExist = true;
                }
            }

            if (isExist) {
                System.out.println("Student Name: " + studentNames[index]);
                System.out.print("Enter the new student name: " + "\n");
                newStudentName = userInput.next();
                studentNames[index] = newStudentName;
                System.out.print("Student details has been updated sucessfully.\n"
                        + "Do you want to update another student details? (Y/n): ");
                inputString = userInput.next();
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? Y/n(): ");
                inputString = userInput.next();
            }
        } while (inputString.equals("Y"));
    }

    public static void updateMarks() {
        System.out.println("UPDATE MARKS");
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int studentId;
        int newProgrammingFMarks;
        int newDbmsMark;

        do {
            int index = 0;
            boolean isExist = false;

            System.out.print("Enter Student ID: ");
            studentId = userInput.nextInt();

            for (int i = 0; i < studentIDs.length; i++) {
                if (studentIDs[i] == studentId) {
                    index = i;
                    isExist = true;
                }
            }

            if (isExist) {
                if (programmingFundamentalMarks[index] == 0 && dbmsMarks[index] == 0) {
                    System.out.println("This student's marks yet to be added.");
                    System.out.print("Do you want to update marks for another student? (Y/n): ");

                    inputString = userInput.next();
                    if (userInput.equals("Y")) {
                        continue;
                    } else {
                        break;
                    }
                }

                System.out.println("Student Name: " + studentNames[index] + "\n\n"
                        + "Programming Fundamentals Marks: " + programmingFundamentalMarks[index] + "\n"
                        + "Database Management System Marks : " + dbmsMarks[index] + "\n\n");

                do {
                    System.out.print("Enter new Programming Fundamental Marks: ");
                    newProgrammingFMarks = userInput.nextInt();
                    if (!(newProgrammingFMarks > 0 && newProgrammingFMarks < 100)) {
                        System.out.println("Invalid marks, please enter correct marks.");
                    }

                } while (!(newProgrammingFMarks > 0 && newProgrammingFMarks < 100));

                programmingFundamentalMarks[index] = newProgrammingFMarks;

                do {
                    System.out.print("Enter new Database Management System Marks: ");
                    newDbmsMark = userInput.nextInt();
                    if (!(newDbmsMark > 0 && newDbmsMark < 100)) {
                        System.out.println("Invalid marks, please enter correct marks.");
                    }

                } while (!(newDbmsMark > 0 && newDbmsMark < 100));

                dbmsMarks[index] = newDbmsMark;

                System.out.println("Marks have been updated successfully.");
                System.out.print("Do you want to update marks for another student? (Y/n): ");
                inputString = userInput.next();

            } else {
                System.out.print("Invalid Student ID. Do you want to search again? Y/n(): ");
                inputString = userInput.next();
            }

        } while (inputString.equals("Y"));

    }

    public static int[] removeElementFromIntArray(int[] orginalArray, int indexToRemove) {
        int[] newArray = new int[orginalArray.length - 1];

        for (int i = 0, k = 0; i < orginalArray.length; i++) {
            if (i != indexToRemove) {
                newArray[k] = orginalArray[i];
                k++;
            }
        }
        return newArray;
    }

    public static String[] removeElementFromStringArray(String[] orginalArray, int indexToRemove) {
        String[] newArray = new String[orginalArray.length - 1];

        for (int i = 0, k = 0; i < orginalArray.length; i++) {
            if (i != indexToRemove) {
                newArray[k] = orginalArray[i];
                k++;
            }
        }
        return newArray;
    }

    public static void deletStudent() {
        System.out.println("DELETE STUDENT");
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int studentId;

        do {
            int index = 0;
            boolean isExist = false;

            System.out.print("Enter Student ID: ");
            studentId = userInput.nextInt();

            for (int i = 0; i < studentIDs.length; i++) {
                if (studentIDs[i] == studentId) {
                    index = i;
                    isExist = true;
                }
            }

            if (isExist) {

                studentIDs = removeElementFromIntArray(studentIDs, index);
                studentNames = removeElementFromStringArray(studentNames, index);
                programmingFundamentalMarks = removeElementFromIntArray(programmingFundamentalMarks, index);
                dbmsMarks = removeElementFromIntArray(dbmsMarks, index);
                System.out.print("Student has been deleted successfully.\n"
                        + "Do you want to delete another student? (Y/n): ");
                inputString = userInput.next();

            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                inputString = userInput.next();
            }
        } while (inputString.equals("Y"));
    }

    public static void calculateRanks(double[] marks, int[] ranks) {
        int n = marks.length;
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (marks[j] > marks[i]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
    }

    public static void calculateRanks(int[] marks, int[] ranks) {
        int n = marks.length;
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (marks[j] > marks[i]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
    }

    public static void printStudentDetails() {
        System.out.println("PRINT STUDENT DETAILS");
        int arrayLength = studentIDs.length;
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int studentId;
        double[] averageMarks = new double[arrayLength];
        int[] ranks = new int[arrayLength];

        // Prepare average mark array
        for (int i = 0; i < studentIDs.length; i++) {
            averageMarks[i] = (programmingFundamentalMarks[i] + dbmsMarks[i]) / 2;
        }

        calculateRanks(averageMarks, ranks);
        do {
            int index = 0;
            boolean isExist = false;

            System.out.print("Enter Student ID: ");
            studentId = userInput.nextInt();

            for (int i = 0; i < studentIDs.length; i++) {
                if (studentIDs[i] == studentId) {
                    index = i;
                    isExist = true;
                }
            }

            if (isExist) {
                System.out.println("Student Name: " + studentNames[index]);

                if (programmingFundamentalMarks[index] == 0 && dbmsMarks[index] == 0) {
                    System.out.println("Marks yet to be added");
                } else {

                    String rankPosition;
                    int totalMarks = programmingFundamentalMarks[index] + dbmsMarks[index];

                    if (ranks[index] == 1) {
                        rankPosition = " (First)";
                    } else if (ranks[index] == 2) {
                        rankPosition = " (Second)";
                    } else if (ranks[index] == 3) {
                        rankPosition = " (Third)";
                    } else {
                        rankPosition = "";
                    }

                    System.out.println(
                            "+-------------------------------------+------------------------+\n"
                                    + "|Programming Fundamentals Marks       |                    "
                                    + programmingFundamentalMarks[index] + "|\n"
                                    + "|Database Management System Marks     |                    " + dbmsMarks[index]
                                    + "|\n"
                                    + "|Total Marks                          |                    " + totalMarks + "|\n"
                                    + "|Avg. Marks                           |                    "
                                    + averageMarks[index] + "|\n"
                                    + "|Rank                                 |                    " + ranks[index]
                                    + rankPosition + "|\n"
                                    + "+-------------------------------------+------------------------+");
                }

                System.out.print("Do you want to search another student details? (Y/n): ");
                inputString = userInput.next();
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
                inputString = userInput.next();
            }

        } while (inputString.equals("Y"));

    }

    public static void printStudentRanks() {

        System.out.println("PRINT STUDENT RANKS");
        int arrayLength = studentIDs.length;
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int[] totalMarks = new int[arrayLength];
        double[] averageMarks = new double[arrayLength];
        int[] ranks = new int[arrayLength];

        // Prepare total marks array
        for (int i = 0; i < arrayLength; i++) {
            totalMarks[i] = programmingFundamentalMarks[i] + dbmsMarks[i];
        }

        // Prepare average marks array
        for (int i = 0; i < studentIDs.length; i++) {
            averageMarks[i] = (totalMarks[i]) / 2;
        }

        calculateRanks(averageMarks, ranks);

        do {
            for (int i = 0; i < arrayLength; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    if ((ranks[j] == i + 1) && (averageMarks[j] != 0.0)) {
                        System.out.println("Rank: " + ranks[j] + " ID: " + studentIDs[j] + " Name: " + studentNames[j]
                                + " Total Marks: " + totalMarks[j] + " Average Marks: " + averageMarks[j]);
                    }
                }
            }

            System.out.print("Do you want to go back to main menu? (Y/n): ");
            inputString = userInput.next();

        } while (inputString.equals("n"));
    }

    public static void printRanksBasedOnSubjectResults(int[] subjectMarksArray) {

        System.out.println("BEST IN PROGRAMMING FUNDAMENTALS MARKS");
        int arrayLength = studentIDs.length;
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        int[] ranks = new int[arrayLength];

        calculateRanks(subjectMarksArray, ranks);

        do {
            for (int i = 0; i < arrayLength; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    if ((ranks[j] == i + 1) && (subjectMarksArray[j] != 0.0)) {
                        System.out.println("Rank: " + ranks[j] + " ID: " + studentIDs[j] + " Name: " + studentNames[j]
                                + " PF Marks: " + subjectMarksArray[j] + " DBMS Marks: " + dbmsMarks[j]);
                    }
                }
            }

            System.out.print("Do you want to go back to main menu? (Y/n): ");
            inputString = userInput.next();

        } while (inputString.equals("n"));

    }

    public static void printBestInProgrammingFundamentals() {
        printRanksBasedOnSubjectResults(programmingFundamentalMarks);

    }

    public static void printBestInDatabaseManagementSystem() {
        printRanksBasedOnSubjectResults(dbmsMarks);
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

}