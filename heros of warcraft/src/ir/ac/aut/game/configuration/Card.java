package ir.ac.aut.game.configuration;

public abstract class Card {
    private String name;
    private String description;

    public boolean equals(String name, String description) {
        return this.name.equals(name) && this.description.equals(description);
    }

    public String toString() {
        return this.name + ": " + this.description;
    }

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
