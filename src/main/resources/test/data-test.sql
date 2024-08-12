INSERT INTO `users` (`name`, `email`, `password_hash`)
VALUES ('William Moolman', 'email1', 'hash1'),
       ('Simonas Burkovskis', 'email2', 'hash2'),
       ('Robert Pettit', 'email3', 'hash3'),
       ('Vladimir Volgin', 'email4', 'hash4'),
       ('Samuel Elliott', 'email5', 'hash5');

INSERT INTO `locations` (`name`,`lat`,`lng`,`user_id`)
VALUES
('Home',55.9391172,-3.1866364,1),
('Work - Watermark',55.8737717,-3.5436674999999997,1);

INSERT INTO `routes` (`start_id`,`end_id`,`user_id`,`geo_json`,`distance_m`,`duration_s`)
VALUES
(1,2,1,NULL,3400,1200),
(2,1,1,NULL,3500,1300);
