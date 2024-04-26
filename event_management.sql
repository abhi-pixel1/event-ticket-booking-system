create database event_management;

CREATE TABLE organizer (
    org_id INT PRIMARY KEY,
    user_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    org_type INT
);

CREATE TABLE student (
    cust_id INT PRIMARY KEY,
    user_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE event (
    event_id INT PRIMARY KEY,
    org_id INT,
    event_name VARCHAR(255),
    description TEXT,
    start_time DATETIME,
    end_time DATETIME,
    place VARCHAR(255),
    date DATE,
    FOREIGN KEY (org_id) REFERENCES organizer(org_id)
);

CREATE TABLE ticket (
    ticket_id INT PRIMARY KEY,
    event_id INT,
    type VARCHAR(255),
    cost DECIMAL(10, 2),
    no_of_seats INT,
    FOREIGN KEY (event_id) REFERENCES event(event_id)
);

CREATE TABLE sales (
    cust_id INT,
    event_id INT,
    ticket_id INT,
    FOREIGN KEY (cust_id) REFERENCES student(cust_id),
    FOREIGN KEY (event_id) REFERENCES event(event_id),
    FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id)
);

CREATE TABLE discount (
    ticket_id INT,
    type INT,
    new_val DECIMAL(10, 2),
    FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id)
);
