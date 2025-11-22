//=============================================================
// Course: CSC111
// Project: Library Simulation System
// Submitted by: 
//              Name:Faisal Ali Alraddadi
//              ID:446106106
//              Section:88297
// GitHub Repo (Bonus): add link here
//=============================================================

import java.util.Scanner;

public class LibrarySimulator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // -----------------------------------------
        // Array of Members (size 100) have same three members as in phase 1
        // -----------------------------------------
        Member[] members = new Member[100];
        int memberCount = 3;

        // Pre-loaded (Phase 1 users)
        members[0] = new Member(100, "Ahmed", 0);
        members[1] = new Member(200, "Faisal", 0);
        members[2] = new Member(300, "Fahad", 0);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n==========================================");
            System.out.println("   Welcome to the Public Library System   ");
            System.out.println("==========================================");
            System.out.println("1. Login as Member");
            System.out.println("2. Add New Member");
            System.out.println("3. Login as Administrator");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int option = input.nextInt();

            switch (option) {

                // -------------------------------
                // Login as existing member
                // -------------------------------
                case 1:
                    System.out.println("\nSelect a member:");

                    for (int i = 0; i < memberCount; i++) {
                        System.out.printf("%d. %s (ID: %d)\n", i + 1, members[i].getName(), members[i].getId());
                    }

                    System.out.print("Enter number: ");
                    int choice = input.nextInt();

                    if (choice < 1 || choice > memberCount) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Member current = members[choice - 1];
                    int userOption;

                    do {
                        System.out.println("\n------------------------------------------");
                        System.out.println("User: " + current.getName());
                        System.out.println("------------------------------------------");
                        System.out.println("1. View Borrowed Books Count");
                        System.out.println("2. Borrow Book");
                        System.out.println("3. Return Book");
                        System.out.println("4. View Session Summary");
                        System.out.println("5. Exit to Main Menu");
                        System.out.print("Choose: ");
                        userOption = input.nextInt();

                        switch (userOption) {
                            case 1: current.viewBorrowedCount(); break;
                            case 2: current.borrowOne(); break;
                            case 3: current.returnOne(); break;
                            case 4: current.displayStatistics(); break;
                            case 5: System.out.println("Returning to Main Menu..."); current.reset(); break;
                            default: System.out.println("Invalid option.");
                        }

                    } while (userOption != 5);

                    break;

                // -------------------------------
                // Add new member
                // -------------------------------
                case 2:
                    if (memberCount >= 100) {
                        System.out.println("Error: Maximum members reached.");
                        break;
                    }

                    System.out.print("Enter member ID: ");
                    int id = input.nextInt();

                    input.nextLine(); // clear buffer

                    System.out.print("Enter member name: ");
                    String name = input.nextLine();

                    members[memberCount] = new Member(id, name, 0);
                    memberCount++;

                    System.out.println("Member added successfully.");
                    break;

                // -------------------------------
                // Administrator menu
                // -------------------------------
                case 3:
                    int adminChoice;

                    do {
                        System.out.println("\n============== Administrator Menu ==============");
                        System.out.println("1. View Total Revenue");
                        System.out.println("2. Most Frequent Operation");
                        System.out.println("3. Exit to Main Menu");
                        System.out.print("Choose: ");

                        adminChoice = input.nextInt();

                        switch (adminChoice) {
                            case 1:
                                System.out.printf("Total Revenue: %.2f\n", Member.TotalRevenue);
                                break;

                            case 2:
                                int b = Member.TotalBorrows;
                                int r = Member.TotalReturns;

                                if (b > r) System.out.println("Most Frequent: Borrow");
                                else if (r > b) System.out.println("Most Frequent: Return");
                                else System.out.println("Both operations equal in frequency.");
                                break;

                            case 3:
                                System.out.println("Returning...");
                                break;

                            default:
                                System.out.println("Invalid.");
                        }

                    } while (adminChoice != 3);

                    break;

                // -------------------------------
                // Exit Program
                // -------------------------------
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Library System!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

    }
}
