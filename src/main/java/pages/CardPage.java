package pages;

import io.restassured.response.Response;
import utils.ApiUtils;

public class CardPage {

    public String createCard(String listId, String cardName) {
        String body = String.format("{\"name\":\"%s\", \"idList\":\"%s\"}", cardName, listId);
        Response response = ApiUtils.post("/cards", body);

        System.out.println("Card Creation Response: " + response.getBody().asString());

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to create card. Status: " + response.getStatusCode());
        }
        return response.jsonPath().getString("id");
    }

    public void updateCard(String cardId, String newName) {
        String body = String.format("{\"name\":\"%s\"}", newName);
        Response response = ApiUtils.put("/cards/" + cardId, body);

        System.out.println("Card Update Response: " + response.getBody().asString());

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to update card. Status: " + response.getStatusCode());
        }
    }

    public void deleteCard(String cardId) {
        Response response = ApiUtils.delete("/cards/" + cardId);

        System.out.println("Card Deletion Response: " + response.getBody().asString());

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to delete card. Status: " + response.getStatusCode());
        }
    }
}
