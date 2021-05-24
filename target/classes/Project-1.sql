---------------------------------------------------
-------------------- Project 1 --------------------
---------------------------------------------------



CREATE TABLE IF NOT EXISTS ers_reimbursement_statuses (
	reimb_status_id SERIAL PRIMARY KEY,
	reimb_status VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS ers_reimbursement_types (
	reimb_type_id SERIAL PRIMARY KEY,
	reimb_type VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS ers_users (
	ers_user_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(250),
	ers_password VARCHAR(250),
	user_first_name VARCHAR(250),
	user_last_name VARCHAR(250),
	user_email VARCHAR(250),
	user_role_id INTEGER REFERENCES ers_user_roles(ers_user_role_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ers_reimbursements (
	reimb_id SERIAL PRIMARY KEY,
	reimb_amount NUMERIC(6, 2),
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR(250),
	reimb_receipt VARCHAR(250),
	reimb_author INTEGER REFERENCES ers_users(ers_user_id) ON DELETE CASCADE,
	reimb_resolver INTEGER REFERENCES ers_users(ers_user_id) ON DELETE CASCADE,
	reimb_status_id INTEGER REFERENCES ers_reimbursement_statuses(reimb_status_id) ON DELETE CASCADE,
	reimb_type_id INTEGER REFERENCES ers_reimbursement_types(reimb_type_id) ON DELETE CASCADE
);



---------------------------------------------------


SELECT * FROM ers_user_roles;
SELECT * FROM ers_users WHERE ers_username = 'adavis' AND ers_password = 'password'


INSERT INTO ers_user_roles (user_role)
VALUES
('Employee'),
('Manager');

INSERT INTO ers_reimbursement_types (reimb_type)
VALUES
('Lodging'),
('Travel'),
('Food'),
('Other');

INSERT INTO ers_reimbursement_statuses (reimb_status)
VALUES
('Pending'),
('Approved'),
('Denied');

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES
('cdaniels', 'password', 'Cara', 'Daniels', 'cdaniels@email.com', 1),
('jsmith', 'password', 'John', 'Smith', 'jsmith@email.com', 1),
('adavis', 'password', 'Andrew', 'Davis', 'adavis@email.com', 2);

INSERT INTO ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES
(123.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, NULL, 1, 2),
(80.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, NULL, 1, 2),
(45.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 2, NULL, 1, 2);

INSERT INTO ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES
(123.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, 3, 2, 2),
(80.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, 3, 2, 2),
(45.00, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 2, 3, 3, 2);

DELETE FROM ers_reimbursement_types;
DELETE FROM ers_user_roles;
DELETE FROM ers_user_roles WHERE ers_user_role_id = 11;
DELETE FROM ers_user_roles WHERE ers_user_role_id = 7 OR ers_user_role_id = 8 OR ers_user_role_id = 9;
DELETE FROM ers_users WHERE ers_user_id = 2;





---------------------------------------------------
-------------------- Project 0 --------------------
---------------------------------------------------

CREATE TABLE IF NOT EXISTS customers (
    customer_id SERIAL PRIMARY KEY,
    customer_last_name VARCHAR(255),
    customer_first_name VARCHAR(255),
    customer_email VARCHAR(255),
    customer_password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS employees (
	employee_id SERIAL PRIMARY KEY,
	employee_last_name VARCHAR(255),
    employee_first_name VARCHAR(255),
    employee_email VARCHAR(255),
    employee_password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS items (
	item_id SERIAL PRIMARY KEY,
	item_asking_price NUMERIC(5, 2),
	item_description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS offers (
    offer_user_id INTEGER REFERENCES customers(customer_id) ON DELETE CASCADE,
    offer_item_id INTEGER REFERENCES items(item_id) ON DELETE CASCADE,
    offer_price NUMERIC(5, 2),
    offer_number_of_payments INTEGER,
    PRIMARY KEY(offer_user_id, offer_item_id)
);

CREATE TABLE IF NOT EXISTS accepted (
	accepted_user_id INTEGER REFERENCES customers(customer_id) ON DELETE CASCADE,
	accepted_item_id INTEGER REFERENCES items(item_id) ON DELETE CASCADE,
	accepted_amount_paid NUMERIC(5, 2),
	accepted_item_description VARCHAR(255),
	accepted_quantity INTEGER,
	PRIMARY KEY(accepted_user_id, accepted_item_id)
);

CREATE TABLE IF NOT EXISTS payments (
	payment_user_id INTEGER REFERENCES customers(customer_id) ON DELETE CASCADE,
	payment_item_id INTEGER REFERENCES items(item_id) ON DELETE CASCADE,
	payment_item_description VARCHAR(255),
	payment_item_price NUMERIC(5, 2),
	payment_paid_payments INTEGER,
	payment_total_payments INTEGER,
	PRIMARY KEY(payment_user_id, payment_item_id)
);


---------------------------------------------------


INSERT INTO customers (customer_first_name, customer_last_name, customer_email, customer_password)
VALUES
('Andrew', 'Davis', 'adavis@email.com', 'p4ssw0rd'),
('John', 'Smith', 'jsmith@email.com', 'p4ssw0rd');

INSERT INTO employees (employee_first_name, employee_last_name, employee_email, employee_password)
VALUES
('Cara', 'Daniels', 'cdaniels@company.com', 'p4ssw0rd'),
('Brandy', 'Stevens', 'bstevens@comapny.com', 'p4s4sw0rd');

INSERT INTO items (item_asking_price, item_description)
VALUES
(30.50, 'Tee S/M/L/XL'),
(35.50, 'Tee 2XL'),
(40.50, 'Tee 3XL'),
(40.50, 'Polo S/M/L/XL'),
(45.50, 'Polo 2XL'),
(50.50, 'Polo 3XL'),
(60.50, 'Jacket S/M/L/XL'),
(65.50, 'Jacket 2XL'),
(70.50, 'Jacket 3XL');

--INSERT INTO offers (offer_user_id, offer_item_id, offer_price, offer_number_of_payments)
--VALUES
--(3, 14, 100.59, 3);

--INSERT INTO accepted (accepted_user_id, accepted_item_id, accepted_amount_paid, accepted_item_description, accepted_quantity)
--VALUES
--(1, 4, 30.00, 'An Item', 1),
--(2, 4, 30.00, 'An Item', 1);

--INSERT INTO payments (payment_user_id, payment_item_id, payment_item_description, payment_item_price, payment_paid_payments, payment_total_payments)
--VALUES
--(2, 1, 'Polo S/M/L/XL', 40.00, 0, 2);


---------------------------------------------------


--SELECT * FROM customers;
--SELECT * FROM customers LEFT JOIN payments ON customers.user_id = payments.payment_user_id;
--SELECT offer_user_id, user_id FROM offers LEFT JOIN users ON offers.offer_user_id = users.user_id;
--
--ALTER TABLE offers
--ADD offers_price TO offer_price
--
--ALTER TABLE offers
--RENAME COLUMN offers_item_id TO offer_item_id;
--

DELETE FROM accepted;
DELETE FROM customers WHERE customer_id = 3 OR customer_id = 4;
--DELETE FROM customers WHERE customer_id = 8 OR customer_id = 9 OR customer_id = 10;
--DELETE FROM offers WHERE offer_item_id = 2;


---------------------------------------------------


--DROP TABLE items;
--DROP TABLE customer;
DROP table items;
--DROP table departments, employees;
