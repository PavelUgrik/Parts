USE test;
DROP TABLE IF EXISTS parts;
CREATE TABLE parts (
    id int PRIMARY KEY AUTO_INCREMENT,
    title varchar(255) not null,
    needed BOOLEAN DEFAULT false not null,
    amount int
);

INSERT INTO parts(title, needed, amount) VALUES
("Материнская плата", true, 54),
("Процессор", true, 5),
("Видеокарта", false, 17),
("Звуковая карта", true, 15),
("Сетевая карта", false, 24),
("HHD диск", false, 0),
("SSD диск", false, 17),
("Корпус", false, 9),
("Кулер", false, 98),
("Блок питания", true, 37),
("Оперативная пямять", true, 23),
("Флешка", false, 3),
("Блютус", false, 0),
("Вай-фай модуль", false, 1),
("Колонки", false, 2),
("Мышка", true, 21),
("Клавиатура", true, 8),
("Коврик", false, 0),
("Микрофон", false, 9),
("Монитор", true, 7),
("Роутер", false, 2),
("Aux кабель", false, 0),
("HDMI кабель", false, 1);





