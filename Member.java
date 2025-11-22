//=============================================================
// Course: CSC111
// Project: Library Simulation System
// Submitted by: 
//              Name:Faisal Ali Alraddadi
//              ID:446106106
//              Section:88297
// GitHub Repo (Bonus): add link here
//=============================================================

public class Member {

    // ------------------------
    // Private Attributes
    // ------------------------
    private int id;
    private String name;
    private int borrowedCount;

    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;

    private double sessionFees;

    // Public Attributes
    // ------------------------
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // ------------------------
    // Constructor
    // ------------------------
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;

        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0;
    }

    // ------------------------
    // Private Methods
    // ------------------------
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    private boolean canReturn() {
        return borrowedCount > 0;
    }

    // ------------------------
    // Public Methods
    // ------------------------
    public void viewBorrowedCount() {
        System.out.println("Borrowed books: " + borrowedCount);
        numViewBorrowed++;
        TotalViewBorrowed++;
    }

    public boolean borrowOne() {
        if (!canBorrow()) {
            System.out.println("Error: Cannot borrow more than 5 books.");
            return false;
        }

        borrowedCount++;
        numBorrows++;
        TotalBorrows++;

        sessionFees += 0.50;
        TotalRevenue += 0.50;

        System.out.println("Book borrowed successfully. Fee charged: 0.50");
        return true;
    }

    public boolean returnOne() {
        if (!canReturn()) {
            System.out.println("Error: No books to return.");
            return false;
        }

        borrowedCount--;
        numReturns++;
        TotalReturns++;

        System.out.println("Book returned successfully.");
        return true;
    }

    public void displayStatistics() {
        System.out.println("\n---- Session Summary ----");
        System.out.println("Views: " + numViewBorrowed);
        System.out.println("Borrows: " + numBorrows);
        System.out.println("Returns: " + numReturns);
        System.out.printf("Fees: %.2f\n", sessionFees);
        System.out.println("-------------------------\n");
    }

    // Reset session statistics
    public void reset() {
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0;
    }

    // ------------------------
    // Getters
    // ------------------------
    public int getId() { return id; }
    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedCount; }
}
