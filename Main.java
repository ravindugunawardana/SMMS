import java.util.Arrays;
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
                    // updateStudentDetails();
                    break;
                case 5:
                    // updateMarks();
                    break;
                case 6:
                    // deletStudent();
                    break;
                case 7:
                    // printStudentDetails();
                    break;
                case 8:
                    // printStudentRanks();
                    break;
                case 9:
                    // bestInProgrammingFundamentals();
                    break;
                case 10:
                    // bestInDatabaseManagementSystem();
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

        System.out.println("");
        System.out.println(Arrays.toString(studentIDs));
        System.out.println(Arrays.toString(studentNames));
        System.out.println(Arrays.toString(programmingFundamentalMarks));
        System.out.println(Arrays.toString(dbmsMarks));
        System.out.println("");
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

        System.out.println("");
        System.out.println(Arrays.toString(studentIDs));
        System.out.println(Arrays.toString(studentNames));
        System.out.println(Arrays.toString(programmingFundamentalMarks));
        System.out.println(Arrays.toString(dbmsMarks));
        System.out.println("");

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
}