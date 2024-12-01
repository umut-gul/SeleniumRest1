package pages;

import io.restassured.response.Response;
import utils.ApiUtils;

public class BoardPage {

    public String createBoard(String boardName) {
        String body = String.format("{\"name\":\"%s\"}", boardName);
        Response response = ApiUtils.post("/boards", body);
        return response.jsonPath().getString("id");
    }

    public String getDefaultListId(String boardId) {
        Response response = ApiUtils.get("/boards/" + boardId + "/lists");
        System.out.println("Lists Response: " + response.getBody().asString());
        return response.jsonPath().getString("[0].id"); // First list ID
    }

    public void deleteBoard(String boardId) {
        ApiUtils.delete("/boards/" + boardId);
    }
}
