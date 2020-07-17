CREATE TABLE account (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    account_Value BIGINT NOT NULL,
    currency VARCHAR(20) NOT NULL,
    notes VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE transactions (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    account_Id INTEGER NOT NULL,
    transaction_Value BIGINT NOT NULL,
    type VARCHAR(20) NOT NULL,
    category VARCHAR(20) NOT NULL,
    from_who VARCHAR(50) NOT NULL,
    notes VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);