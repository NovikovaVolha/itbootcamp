CREATE TABLE user
(
    id         INT         NOT NULL AUTO_INCREMENT,
    surname    VARCHAR(40) NOT NULL,
    name       VARCHAR(20) NOT NULL,
    patronymic VARCHAR(40) NULL,
    email      VARCHAR(50) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    roles    VARCHAR(45) NOT NULL,
    CONSTRAINT user_id
        FOREIGN KEY (user_id) REFERENCES user (id)
);