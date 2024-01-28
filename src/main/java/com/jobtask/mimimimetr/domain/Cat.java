package com.jobtask.mimimimetr.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cat {
    private final CatId id;
    private final CatName name;
    private final CatImage image;
    private final CatGrade grade;

    public record CatId (Long value) {}
    public record CatName (String value) {}
    public record CatImage (byte[] value) {}
    public record CatGrade (Double grade) {}

}
