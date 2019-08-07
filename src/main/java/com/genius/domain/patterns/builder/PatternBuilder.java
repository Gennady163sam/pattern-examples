package com.genius.domain.patterns.builder;

public class PatternBuilder {
    private String name;
    private String description;

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
