CREATE TABLE IF NOT EXISTS account (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	limit_amount VARCHAR(50),
	balance VARCHAR(50),
	account_type VARCHAR(50),
	PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS budget (
	id BIGINT NOT NULL AUTO_INCREMENT,
	start_date DATE,
	end_date DATE,
	budget_type VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS budget_item (
	id BIGINT NOT NULL AUTO_INCREMENT,
	budget_id BIGINT,
	name VARCHAR(50),
	due_date DATE,
	amount VARCHAR(50),
	
	PRIMARY KEY (id),
	FOREIGN KEY (budget_id) REFERENCES budget(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS transaction (
	id BIGINT NOT NULL AUTO_INCREMENT,
	budget_id BIGINT,
	account_name VARCHAR(50),
	amount VARCHAR(50),
	category VARCHAR(50),
	transaction_date DATE,
	description VARCHAR(100),
	transaction_type VARCHAR(50),
	
	PRIMARY KEY (id),
	FOREIGN KEY (budget_id) REFERENCES budget(id) ON DELETE CASCADE
);