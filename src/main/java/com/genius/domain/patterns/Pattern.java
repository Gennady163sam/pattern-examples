package com.genius.domain.patterns;

/**
 * A pattern is a regularity in the world, in human-made design, or in abstract ideas.
 * As such, the elements of a pattern repeat in a predictable manner.
 * A geometric pattern is a kind of pattern formed of geometric shapes and typically repeated like a wallpaper design.
 *
 * @author  Gennady Savinov
 */
public abstract class Pattern {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
