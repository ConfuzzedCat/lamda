package com.github.confuzzedcat.streamsAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private int pages;
}
