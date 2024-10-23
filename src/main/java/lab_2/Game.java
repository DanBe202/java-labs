package lab_2;

public class Game implements Comparable<Game> {
    private String name;
    private int rating;
    private double price;
    private String genre;      // Нове поле - жанр гри
    private String description; // Нове поле - опис гри

    public Game(String name, int rating, double price, String genre, String description) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.genre = genre;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Game other) {
        // Сортування за рейтингом за спаданням
        return Integer.compare(other.rating, this.rating);
    }

    @Override
    public String toString() {
        return String.format("Game{name='%s', rating=%d, price=%.2f, genre='%s', description='%s'}",
                name, rating, price, genre, description);
    }
}
