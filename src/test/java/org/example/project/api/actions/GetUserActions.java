package org.example.project.api.actions;

import io.cucumber.java.en.Then;
import org.example.project.api.dtos.requests.User;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class GetUserActions extends Context {

    @Then("Response user's Avatar link contains user's id")
    public void validateAvatarLinkId() {
        User user = Context.response.body().jsonPath().getObject("data", User.class);
        Assertions.assertTrue(user.getAvatar().contains(String.valueOf(user.getId())));
    }

    @Then("Response users list Avatar links contains users ids")
    public void validateAvatarLinksIds() {
        List<User> users = Context.response.body().jsonPath().getList("data", User.class);
        Assertions.assertTrue(users.stream()
                .allMatch(user -> user.getAvatar().contains(String.valueOf(user.getId()))));
    }
}
