package org.example.project.configurations.api_specifications;

import lombok.Getter;

public enum EndPoint {
    BASE_URL("https://reqres.in/"),
    GET_USER("/api/users/2"),
    GET_USERS_LIST("/api/users?page=2"),
    POST_NEW_USER("/api/users"),
    POST_NEW_REGISTRATION("/api/register"),
    UPDATE_USER("/api/users/2"),
    DELETE_USER("/api/users/2"),
    GET_RESOURCES("/api/unknown");

    private final String value;

    EndPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
