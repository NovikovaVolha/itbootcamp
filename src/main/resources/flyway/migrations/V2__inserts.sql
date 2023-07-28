INSERT INTO user (id, surname, name, patronymic, email)
VALUES (1, 'Иванов', 'Иван', 'Иванович', 'ivanov@gmail.com'),
       (2, 'Федоров', 'Федор', 'Федорович', 'fedorov@mail.ru');

INSERT INTO user_roles (user_id, roles)
VALUES (1, 'ADMINISTRATOR'),
       (2, 'CUSTOMER_USER');
