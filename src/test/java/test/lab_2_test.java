package test;

import static org.testng.Assert.assertEquals;

import lab_2.Game;
import lab_2.GameCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class lab_2_test {

    @DataProvider(name = "gameProvider")
    public Object[][] provideGames() {
        return new Object[][] {
                { new Game("The Witcher 3", 9, 30, "RPG", "An open-world RPG.") },
                { new Game("Cyberpunk 2077", 7, 60, "Action RPG", "A futuristic RPG.") },
                { new Game("Minecraft", 8, 20, "Sandbox", "A sandbox game.") }
        };
    }

    @Test(dataProvider = "gameProvider")
    public void testAddGame(Game game) {
        GameCollection collection = new GameCollection();
        collection.addGame(game);

        List<Game> games = collection.getGames();
        assertEquals(1, games.size());
        assertEquals(game.getName(), games.get(0).getName());
    }

    @Test
    public void testFilterByGenre() {
        GameCollection collection = new GameCollection();
        collection.addGame(new Game("The Witcher 3", 9, 30, "RPG", "An open-world RPG."));
        collection.addGame(new Game("Minecraft", 8, 20, "Sandbox", "Build and explore."));

        List<Game> rpgGames = collection.filterByGenre("RPG");
        assertEquals(1, rpgGames.size());
        assertEquals("The Witcher 3", rpgGames.get(0).getName());
    }

    @Test
    public void testSortByPrice() {
        GameCollection collection = new GameCollection();
        collection.addGame(new Game("Cyberpunk 2077", 7, 60, "Action RPG", "Futuristic RPG."));
        collection.addGame(new Game("Minecraft", 8, 20, "Sandbox", "Build and explore."));
        collection.addGame(new Game("The Witcher 3", 9, 30, "RPG", "Fantasy RPG."));

        List<Game> sortedGames = collection.sortByPrice();
        assertEquals(3, sortedGames.size());
        assertEquals("Minecraft", sortedGames.get(0).getName());
        assertEquals("Cyberpunk 2077", sortedGames.get(2).getName());
    }

    @Test
    public void testGetMostExpensiveGame() {
        GameCollection collection = new GameCollection();
        collection.addGame(new Game("Cyberpunk 2077", 7, 60, "Action RPG", "Futuristic RPG."));
        collection.addGame(new Game("Minecraft", 8, 20, "Sandbox", "Build and explore."));
        collection.addGame(new Game("The Witcher 3", 9, 30, "RPG", "Fantasy RPG."));

        Game mostExpensive = collection.getMostExpensiveGame();
        assertEquals("Cyberpunk 2077", mostExpensive.getName());
    }
}
