package ASSIGN5;

// Custom Exception
class BookException extends Exception {
    public BookException(String message) {
        super(message);
    }
}

// Book class
class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

// Library class
class Library {
    Book[] books;
    int count;

    Library(int size) {
        books = new Book[size];
        count = 0;
    }

    void addBook(String title) {
        books[count] = new Book(title);
        count++;
    }

    Book searchBook(String title) throws BookException {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        throw new BookException("Error: Book '" + title + "' not found in the library.");
    }

    void issueBook(String title) throws BookException {
        Book b = searchBook(title);

        if (b.isIssued) {
            throw new BookException("Error: The book is already checked out!");
        }

        b.isIssued = true;
        System.out.println("Book checked out successfully: " + b.title);
    }

    void returnBook(String title, int daysLate) throws BookException {

        if (daysLate < 0) {
            throw new BookException("Error: Invalid return date! Days late cannot be negative.");
        }

        Book b = searchBook(title);
        b.isIssued = false;

        System.out.println("Book returned successfully: " + b.title);

        if (daysLate > 0) {
            System.out.println("Late Fee: ₹" + (daysLate * 10));
        }
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library lib = new Library(10);

        lib.addBook("Java Programming");

        // 1. Success Checkout
        try {
            lib.issueBook("Java Programming");
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }

        // 2. Already Checked Out
        try {
            lib.issueBook("Java Programming");
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // 3. Return with Late Fee
        try {
            lib.returnBook("Java Programming", 2);
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }

        // 4. Invalid Date
        try {
            lib.returnBook("Java Programming", -1);
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }

        // 5. Book Not Found
        try {
            lib.returnBook("Unknown Book", 0);
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
    }
} 
