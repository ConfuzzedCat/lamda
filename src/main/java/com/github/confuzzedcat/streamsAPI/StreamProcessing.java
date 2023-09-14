package com.github.confuzzedcat.streamsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProcessing {
    public static void main(String[] args) {
        // Create a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 5, 1178));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 6, 310));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 4, 223));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 4, 251));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 4, 317));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 7, 636));
        books.add(new Book("Kafka on the Shore", "Haruki Murakami", 2002, 10, 505));
        books.add(new Book("The Wind-Up Bird Chronicle", "Haruki Murakami", 1994, 4, 607));
        books.add(new Book("1Q84", "Haruki Murakami", 2009, 3, 925));

        // Calculate the average rating of all books
        System.out.println("\nCalculate the average rating of all books");
        double avgRating = books.stream()
                                .mapToDouble(book -> book.getRating())
                                .average()
                                .getAsDouble();
        // Filter and display books published after a specific year
        System.out.println("\nFilter and display books published after a specific year");
        books.stream()
                .filter(book -> book.getPublicationYear() > 1998)
                .forEach(System.out::println);

        // Sort books by rating in descending order
        System.out.println("\nSort books by rating in descending order");
        List<Book> sorted = books.stream()
                                .sorted(Comparator.comparing(Book::getRating).reversed() )
                                .toList();
        sorted.forEach(System.out::println);

        // Find and display the title of the highest-rated book
        System.out.println("\nFind and display the title of the highest-rated book");
        System.out.println(books.stream()
                .max(Comparator.comparing(Book::getRating).reversed()));

        // Group books by author and calculate average rating for each author
        System.out.println("\nGroup books by author and calculate average rating for each author");
        books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .forEach((author, bookList) -> {
                    System.out.println(author + " - " +bookList.stream()
                            .mapToDouble(Book::getRating)
                            .average()
                            .getAsDouble());
                });

        // Calculate the total number of pages for all books
        System.out.println("\nCalculate the total number of pages for all books");
        int totalAmountOfPages = books.stream()
                .mapToInt(book -> book.getPages())
                .sum();
        System.out.println(totalAmountOfPages);
    }
}
