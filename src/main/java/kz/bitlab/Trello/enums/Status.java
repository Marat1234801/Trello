package kz.bitlab.Trello.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    TODO("To do"),
    IN_TEST("In test"),
    DONE("Done"),
    FAILED("Failed");

    private final String message;
}
