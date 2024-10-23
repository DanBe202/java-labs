package lab_2;

import java.util.*;

public class GameCollection {
    private List<Game> games;

    public GameCollection() {
        this.games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    // Сервісний метод 1: Фільтрація ігор з певного жанру
    public List<Game> filterByGenre(String genre) {
        List<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getGenre().equalsIgnoreCase(genre)) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    // Сервісний метод 2: Сортування ігор за ціною (використання Collections)
    public List<Game> sortByPrice() {
        List<Game> sortedGames = new ArrayList<>(games);
        Collections.sort(sortedGames, Comparator.comparingDouble(Game::getPrice));
        return sortedGames;
    }

    // Сервісний метод 3: Знаходження найдорожчої гри
    public Game getMostExpensiveGame() {
        return Collections.max(games, Comparator.comparingDouble(Game::getPrice));
    }

    // Сервісний метод 4: Сортування за рейтингом за допомогою Comparable
    public List<Game> sortByRatingDescending() {
        List<Game> sortedGames = new ArrayList<>(games);
        Collections.sort(sortedGames);  // Використовує Comparable
        return sortedGames;
    }
}

