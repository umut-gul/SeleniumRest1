package tests;

import org.junit.jupiter.api.Test;
import pages.BoardPage;
import pages.CardPage;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloApiTest {

    @Test
    public void testTrelloApi() {
        BoardPage boardPage = new BoardPage();
        CardPage cardPage = new CardPage();

        // Step 1: Create Board
        String boardId = boardPage.createBoard("Selenium Test Board");
        assertNotNull(boardId, "Board creation failed!");
        System.out.println("Board created with ID: " + boardId);

        // Step 2: Get Default List ID from the Board
        String listId = boardPage.getDefaultListId(boardId);
        assertNotNull(listId, "Failed to retrieve default list ID!");
        System.out.println("Default list ID retrieved: " + listId);

        // Step 3: Create Cards
        String card1Id = cardPage.createCard(listId, "Test Card 1");
        String card2Id = cardPage.createCard(listId, "Test Card 2");
        assertNotNull(card1Id, "Card 1 creation failed!");
        assertNotNull(card2Id, "Card 2 creation failed!");
        System.out.println("Cards created with IDs: " + card1Id + ", " + card2Id);

        // Step 4: Update a Random Card
        cardPage.updateCard(card1Id, "Updated Card 1");
        System.out.println("Card updated with ID: " + card1Id);

        // Step 5: Delete Cards
        cardPage.deleteCard(card1Id);
        cardPage.deleteCard(card2Id);
        System.out.println("Cards deleted successfully.");

        // Step 6: Delete Board
        boardPage.deleteBoard(boardId);
        System.out.println("Board deleted successfully.");
    }
}
