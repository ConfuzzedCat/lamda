package com.github.confuzzedcat.thursday;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
}
