CREATE TABLE user (
	uuid VARCHAR(20) NOT NULL,
    id VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(40) NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE', 'DELETE') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT now(),
    updated_at DATETIME DEFAULT now(),
    CONSTRAINT USER_PK PRIMARY KEY (uuid),
    CONSTRAINT USER_UQ UNIQUE(id)
);

CREATE TABLE monthly (
    idx INT NOT NULL AUTO_INCREMENT,
	uuid VARCHAR(20) NOT NULL,
    date_group VARCHAR(30) NOT NULL,
    total_expense INT NOT NULL,
    total_income INT NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE', 'DELETE') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT now(),
    updated_at DATETIME DEFAULT now(),
    CONSTRAINT MONTHLY_PK PRIMARY KEY (idx),
    CONSTRAINT MONTHLY_FK FOREIGN KEY (uuid) REFERENCES user(uuid)
);

CREATE TABLE expense (
    idx INT NOT NULL AUTO_INCREMENT,
    monthly_idx INT NOT NULL,
	title VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    category ENUM('FOOD', 'FASHION', 'LIVING', 'BEAUTY', 'ELECTRONICS', 'HEALTH', 'ETC'),
    date DATE,
    status ENUM('ACTIVE', 'INACTIVE', 'DELETE') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT now(),
    updated_at DATETIME DEFAULT now(),
    CONSTRAINT EXPENSE_PK PRIMARY KEY (idx),
    CONSTRAINT EXPENSE_FK FOREIGN KEY (monthly_idx) REFERENCES monthly(idx)
);


CREATE TABLE income (
    idx INT NOT NULL AUTO_INCREMENT,
    monthly_idx INT NOT NULL,
	title VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    category ENUM('FOOD', 'FASHION', 'LIVING'),
    date DATE,
    status ENUM('ACTIVE', 'INACTIVE', 'DELETE') DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT now(),
    updated_at DATETIME DEFAULT now(),
    CONSTRAINT INCOME_PK PRIMARY KEY (idx),
    CONSTRAINT INCOME_FK FOREIGN KEY (monthly_idx) REFERENCES monthly(idx)
);