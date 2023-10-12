import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Book {
private String title;
private String author;
private boolean available;
public Book(String title, String author) {
this.title = title;
this.author = author;
this.available = true;
}
public String getTitle() {
return title;
}
public String getAuthor() {
return author;
}
public boolean isAvailable() {
return available;
}
public void setAvailable(boolean available) {
this.available = available;
}
}
class Library {
private List<Book> books;
public Library() {
this.books = new ArrayList<>();
}
public void addBook(Book book) {
books.add(book);
}

10

public void displayBooks() {
System.out.println("Library Books:");
for (Book book : books) {
System.out.println("Title: " + book.getTitle());
System.out.println("Author: " + book.getAuthor());
System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not
available"));
System.out.println("--------------------");
}
}
public Book findBook(String title) {
for (Book book : books) {
if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
return book;
}
}
return null;
}
public void borrowBook(String title) {
Book book = findBook(title);
if (book != null) {
book.setAvailable(false);
System.out.println("You have borrowed the book: " + book.getTitle());
} else {
System.out.println("The book is not available in the library.");
}
}
public void returnBook(String title) {
Book book = findBook(title);
if (book != null) {
book.setAvailable(true);
System.out.println("You have returned the book: " + book.getTitle());
} else {
System.out.println("You didn't borrow this book from the library.");
}
}
}
public class Main {
public static void main(String[] args) {
Library library = new Library();
library.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K.
Rowling"));

11

library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
library.addBook(new Book("1984", "George Orwell"));
Scanner scanner = new Scanner(System.in);
int choice;
do {
System.out.println("LIBRARY MANAGEMENT SYSTEM");
System.out.println("1. Display all books");
System.out.println("2. Borrow a book");
System.out.println("3. Return a book");
System.out.println("0. Exit");
System.out.print("Enter your choice: ");
choice = scanner.nextInt();
scanner.nextLine(); // Consume newline character
switch (choice) {
case 1:
library.displayBooks();
break;
case 2:
System.out.print("Enter the title of the book to borrow: ");
String borrowTitle = scanner.nextLine();
library.borrowBook(borrowTitle);
break;
case 3:
System.out.print("Enter the title of the book to return: ");
String returnTitle = scanner.nextLine();
library.returnBook(returnTitle);
break;
case 0:
System.out.println("Exiting");
break;
default:
System.out.println("Invalid choice. Please try again.");
break;
}
System.out.println();
} while (choice != 0);
scanner.close();
}
}