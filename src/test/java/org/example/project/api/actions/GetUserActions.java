package org.example.project.api.actions;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.project.api.dtos.requests.User;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.example.project.configurations.scenario_context.Context.ContextKeys;

public class GetUserActions {

    private static final Context context = Context.getInstance();

    @Then("Response user's Avatar link contains user's id")
    public void validateAvatarLinkId() {
        User user = context.getContext(ContextKeys.RESPONSE, Response.class).body().jsonPath().getObject("data", User.class);
        Assertions.assertTrue(user.getAvatar().contains(String.valueOf(user.getId())));
    }

    @Then("Response users list Avatar links contains users ids")
    public void validateAvatarLinksIds() {
        List<User> users = context.getContext(ContextKeys.RESPONSE, Response.class).body().jsonPath().getList("data", User.class);

        users.forEach(user -> Assertions.assertTrue(user.getId() >= 18 && user.getId() <= 67));

        Assertions.assertTrue(users.stream()
                .allMatch(user -> user.getAvatar().contains(String.valueOf(user.getId()))));
    }
}
