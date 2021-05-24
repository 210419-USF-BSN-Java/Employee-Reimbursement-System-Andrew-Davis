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
('tstark', 'password', 'Tony', 'Stark', 'tstark@email.com', 1),
('bbanner', 'password', 'Bruce', 'Banner', 'bbanner@email.com', 1),
('todinson', 'password', 'Thor', 'Odinson', 'todinson@email.com', 1),
('srogers', 'password', 'Steve', 'Rogers', 'srogers@email.com', 2),
('nfury', 'password', 'Nick', 'Fury', 'nfury@email.com', 2);

INSERT INTO ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES
(123.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I took a group of clients out for dinner.', '', 1, NULL, 1, 3),
(290.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I stayed the night at a nice hotel.', '', 1, NULL, 1, 1),
(45.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 50 miles', '', 2, NULL, 1, 2),
(123.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I took a group of clients out for lunch.', '', 1, NULL, 1, 3),
(590.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I stayed a week at a nice hotel.', '', 1, NULL, 1, 1),
(21.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 25 miles', '', 2, NULL, 1, 2),
(40.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 30 miles', '', 1, 4, 2, 2),
(80.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, 4, 2, 2),
(45.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I stayed at an Air BnB', '', 2, 4, 3, 1),
(40.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I stayed at a hotel', '', 1, 5, 2, 1),
(80.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 100 miles', '', 1, 5, 2, 2),
(45.50, '2020-05-21 08:00:00', '2020-05-21 08:10:00', 'I was required to drive 30 miles', '', 2, 5, 3, 2);


