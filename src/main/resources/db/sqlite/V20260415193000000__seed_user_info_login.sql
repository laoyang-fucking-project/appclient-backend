-- Seed a passwd-login account bound to user_info for frontend role routing.
INSERT INTO login (wx_open_id, phone_number, password, user_name, relevance_id, relevance_table)
SELECT NULL,
       '13800000000',
       '$2a$10$bOrRjyHCMT2DUnXoVuFWNO1dSd6Zj/fyjS0TETmcD1ZXlR/BGklc2',
       'seed_user',
       '1',
       'user_info'
WHERE NOT EXISTS (
    SELECT 1
    FROM login
    WHERE phone_number = '13800000000'
      AND relevance_table = 'user_info'
);
