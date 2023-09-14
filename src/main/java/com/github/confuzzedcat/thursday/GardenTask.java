package com.github.confuzzedcat.thursday;

import lombok.Builder;

import java.time.LocalDate;

public class GardenTask extends Task{
    private String gardenLocation;

    public GardenTask(String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }

    public void setGardenLocation(String gardenLocation) {
        this.gardenLocation = gardenLocation;
    }
}
