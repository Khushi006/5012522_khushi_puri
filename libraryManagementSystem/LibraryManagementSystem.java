import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(10);

        // Adding books
        lms.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        lms.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        lms.addBook(new Book(3, "1984", "George Orwell"));
        lms.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));

        // Linear search by title
        String searchTitle = "1984";
        Book foundBook = lms.linearSearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found using linear search: " + foundBook);
        } else {
            System.out.println("Book not found using linear search.");
        }

        // Binary search by title
        foundBook = lms.binarySearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found using binary search: " + foundBook);
        } else {
            System.out.println("Book not found using binary search.");
        }
    }
}
