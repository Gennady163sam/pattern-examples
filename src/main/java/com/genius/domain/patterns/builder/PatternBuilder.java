package com.genius.domain.patterns.builder;

import com.genius.domain.patterns.Pattern;

/**
 * This class implements Builder pattern behavior
 *
 * @author  Gennady Savinov
 * @see     Pattern
 */
public class PatternBuilder {
    private String name;
    private String description;

    /**
     * The intent of the Builder design pattern is to separate the construction of a complex object from its representation.
     * By doing so the same construction process can create different representations.
     */

    public String getName() {
        return name;
    }

    public PatternBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PatternBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
}
