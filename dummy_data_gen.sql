-- Insert dummy data into organizer table
USE event_management;

INSERT INTO organizer (org_id, user_name, email, password, org_type)
VALUES
(1, 'org1_username', 'org1@example.com', 'org1_password', 1),
(2, 'org2_username', 'org2@example.com', 'org2_password', 2),
(3, 'org3_username', 'org3@example.com', 'org3_password', 1);

-- Insert dummy data into customer table
INSERT INTO student (cust_id, user_name, email, password)
VALUES
(1, 'cust1_username', 'cust1@example.com', 'cust1_password'),
(2, 'cust2_username', 'cust2@example.com', 'cust2_password'),
(3, 'cust3_username', 'cust3@example.com', 'cust3_password');

-- Insert dummy data into event table
INSERT INTO event (event_id, org_id, event_name, description, start_time, end_time, place, date)
VALUES
(1, 1, 'Event 1', 'Description of Event 1', '2024-05-10 10:00:00', '2024-05-10 18:00:00', 'Location 1', '2024-05-10'),
(2, 2, 'Event 2', 'Description of Event 2', '2024-05-15 09:00:00', '2024-05-15 17:00:00', 'Location 2', '2024-05-15'),
(3, 3, 'Event 3', 'Description of Event 3', '2024-05-20 11:00:00', '2024-05-20 19:00:00', 'Location 3', '2024-05-20');

-- Insert dummy data into ticket table
INSERT INTO ticket (ticket_id, event_id, type, cost, no_of_seats)
VALUES
(1, 1, 'General Admission', 50.00, 100),
(2, 1, 'VIP', 100.00, 50),
(3, 2, 'Standard', 30.00, 150),
(4, 3, 'Early Bird', 25.00, 200);

-- Insert dummy data into sales table
INSERT INTO sales (cust_id, event_id, ticket_id)
VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(1, 3, 4);

-- Insert dummy data into discount table
INSERT INTO discount (ticket_id, type, new_val)
VALUES
(2, 1, 90.00),
(4, 2, 20.00);
