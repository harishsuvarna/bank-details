CREATE TABLE acctbalance
  (
    id                              SERIAL NOT NULL,
    accountNumber                   VARCHAR(1) NOT NULL,
    lastUpdateTimestamp             VARCHAR(1) NOT NULL,
    balance                         FLOAT NOT NULL,


    PRIMARY KEY (id),
    UNIQUE (accountNumber),
  );

CREATE TABLE acctdetails
  (
    id                              SERIAL NOT NULL,
    accountNumber                   VARCHAR(1) NOT NULL,
    transactionTs                   VARCHAR(1) NOT NULL,
    type                            VARCHAR(1) NOT NULL,
    amount                          FLOAT NOT NULL,


    PRIMARY KEY (id),
    UNIQUE (accountNumber),
  );

