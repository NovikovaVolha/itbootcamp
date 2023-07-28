INSERT INTO user (id, surname, name, patronymic, email)
VALUES (1, 'Иванов', 'Иван', 'Иванович', 'ivanov@gmail.com'),
       (2, 'Федоров', 'Федор', 'Федорович', 'fedorov@mail.ru');

INSERT INTO user_role (user_id, role)
VALUES (1, 'ADMINISTRATOR'),
       (2, 'CUSTOMER_USER');
