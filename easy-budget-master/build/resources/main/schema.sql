CREATE TABLE account (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    account_Value BIGINT NOT NULL,
    currency VARCHAR(20) NOT NULL,
    notes VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);