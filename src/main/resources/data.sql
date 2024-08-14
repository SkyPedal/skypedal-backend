INSERT INTO `users` (`first_name`,`last_name`, `email`, `password_hash`, `office_location`,`reward_points`)
VALUES ('William', 'Moolman', 'email1', 'hash1', 'Livingston', 42),
       ('Simonas', 'Burkovskis', 'email2', 'hash2', 'Livingston', 100),
       ('Robert', 'Pettit', 'email3', 'hash3', 'Leeds', 33),
       ('Vladimir', 'Volgin', 'email4', 'hash4', 'Leeds', 40),
       ('Samuel', 'Elliott', 'email5', 'hash5', 'Brentwood', 55);

INSERT INTO `locations` (`name`,`lat`,`lng`,`user_id`)
VALUES
    ('Home',55.9391172,-3.1866364,1),
    ('Work - Watermark',55.8737717,-3.5436674999999997,1);

INSERT INTO `routes` (`start_id`,`end_id`,`user_id`,`geo_json`,`distance_m`,`duration_s`)
VALUES
(1,2,1,NULL,3400,1200),
(2,1,1,NULL,3500,1300);

INSERT INTO `rewards` (`name`,`description`,`point_cost`,`number_available`, `image_link`, `active`)
VALUES
('Free Cake', '1 delicious free cake of your choosing!', 1000, 10, '34552345-23452345-23452345.jpg', TRUE),
('Free Coffee', '1 delicious free coffee of your choosing!', 750, 25, '34552345-23452345-23452345.jpg', TRUE),
('Free Cookie', '1 delicious free cookie of your choosing!', 500, 50, '34552345-23452345-23452345.jpg', FALSE),
('Free Car', '1 delicious free car of your choosing!', 100000, 1, '34552345-23452345-23452345.jpg', TRUE);

INSERT INTO `users_rewards` (`reward_id`,`user_id`,`date_redeemed`,`date_expiry`,`has_used`)
VALUES
(1, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(2, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(3, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(4, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 2, 'Thursday', '2024/09/06 T 12:00', FALSE),
(2, 2, 'Thursday', '2024/09/06 T 12:00', TRUE),
(1, 3, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 4, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 4, 'Thursday', '2024/09/06 T 12:00', TRUE),
(1, 5, 'Thursday', '2024/09/06 T 12:00', FALSE);