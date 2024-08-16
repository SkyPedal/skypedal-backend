INSERT INTO `users` (`first_name`,`last_name`, `email`, `password_hash`, `office_location`,`reward_points`)
VALUES
    ('Will','Moolman','will@sky.uk','{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG','Livingston',42),
    ('Simonas','Burkovskis','simonas@sky.uk','{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG','Livingston',4200),
    ('Robert','Pettit','robert@sky.uk','{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG','Leeds',42),
    ('Vladimir','Volgin','vladimir@sky.uk','{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG','Leeds',42),
    ('Samuel','Elliott','samuel@sky.uk','{bcrypt}$2a$10$JomNCELUGwttzHipaNpuXe.U9nRc2JollvVRRU.v/pbcxwodKlaQG','Brentwood',42);

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
('Free Cake', '1 delicious free cake of your choosing!', 10, 10, '34552345-23452345-23452345.jpg', TRUE),
('Free Coffee', '1 delicious free coffee of your choosing!', 20, 25, '34552345-23452345-23452345.jpg', TRUE),
('Free Cookie', '1 delicious free cookie of your choosing!', 15, 50, '34552345-23452345-23452345.jpg', TRUE),
('Free Cracker', '1 delicious free cracker of your choosing!', 1, 1, '34552345-23452345-23452345.jpg', TRUE);

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

INSERT INTO `activities` (`date`, geo_json, activity_time, distance, type, user_id, co2_saving, cost_saving, points_earned)
VALUES
    ('today', '["coordinates"]', '40min', 3100, 'cycling', 1, 543,  430, 1000),
    ('today', '["coordinates"]', '1h', 4300, 'cycling', 2, 3,  1000, 4000),
    ('today', '["coordinates"]', '20min', 5000, 'running', 2, 600,  230, 1000),
    ('today', '["coordinates"]', '35min', 2300, 'walking', 2, 300,  110, 1000);

--    private String date;
--    private String geoJson;
--    private String activity_time;
--    private int distance;
--    private String type;
--    @ManyToOne
--    private User user;
--    private List<Integer> joined_friends;
--    private int co2_saving;
--    private int cost_saving;
--    private int points_earned;
--
