INSERT INTO users (email, first_name, last_name, office_location, reward_points, password_hash)
VALUES
('will@sky.uk','will','moolman','Livingston',42, '{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG'),
('Samel@sky.com','Sam','El','Brentwood',25, '{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG'),
('John@email.com','John','Johnson','Leeds',25, '{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG'),
('John2@email.com','John','Johnson','Leeds',25, '{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG'),
('John3@email.com','John','Johnson','Leeds',25, '{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG');

INSERT INTO `locations` (`name`,`lat`,`lng`,`user_id`)
VALUES
('Home',55.9391172,-3.1866364,1),
('Work - Watermark',55.8737717,-3.5436674999999997,1);

INSERT INTO `routes` (`start_id`,`end_id`,`user_id`,`geo_json`,`distance_m`,`duration_s`)
VALUES
(1,2,1,NULL,3400,1200),
(2,1,2,NULL,3500,1300);

INSERT INTO `rewards` (`name`,`description`,`point_cost`,`number_available`, `image_link`, `active`)
VALUES
('Free Cake', '1 delicious free cake of your choosing!', 10, 10, '34552345-23452345-23452345.jpg', TRUE),
('Free Coffee', '1 delicious free coffee of your choosing!', 20, 25, '34552345-23452345-23452345.jpg', TRUE),
('Free Cookie', '1 delicious free cookie of your choosing!', 15, 50, '34552345-23452345-23452345.jpg', FALSE),
('Free Car', '1 delicious free car of your choosing!', 1, 1, '34552345-23452345-23452345.jpg', TRUE),
('Free Crane', '1 delicious free crane of your choosing!', 500, 1, '34552345-23452345-23452345.jpg', FALSE);


INSERT INTO `users_rewards` (`reward_id`,`user_id`,`date_redeemed`,`date_expiry`,`has_used`)
VALUES
(1, 1, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(2, 1, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(3, 1, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(4, 1, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(1, 2, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(2, 2, '2024-07-12T12:00', '2024-07-24T12:00', TRUE),
(1, 3, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(1, 4, '2024-07-12T12:00', '2024-07-24T12:00', FALSE),
(1, 4, '2024-07-12T12:00', '2024-07-24T12:00', TRUE),
(2, 4, '2024-07-12T12:00', '2024-07-24T12:00', FALSE);