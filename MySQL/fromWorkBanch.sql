-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов:
CREATE TABLE IF NOT EXISTS animals(
	id SERIAL PRIMARY KEY,
    group_type VARCHAR(45)
);
CREATE TABLE IF NOT EXISTS pets(
	id SERIAL PRIMARY KEY,
	from_animals_id BIGINT UNSIGNED NOT NULL, 
    animal_type VARCHAR(45),
    FOREIGN KEY (from_animals_id) REFERENCES animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS pack_animals(
	id SERIAL PRIMARY KEY,
	from_animals_id BIGINT UNSIGNED NOT NULL, 
	animal_type VARCHAR(45),
	FOREIGN KEY (from_animals_id) REFERENCES animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS dog(
	id SERIAL PRIMARY KEY,
	from_pets_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pets_id) REFERENCES pets(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS cat(
	id SERIAL PRIMARY KEY,
	from_pets_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pets_id) REFERENCES pets(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS hamster(
	id SERIAL PRIMARY KEY,
	from_pets_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pets_id) REFERENCES pets(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS horse(
	id SERIAL PRIMARY KEY,
	from_pack_animals_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pack_animals_id) REFERENCES pack_animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS camel(
	id SERIAL PRIMARY KEY,
	from_pack_animals_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pack_animals_id) REFERENCES pack_animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS donkey(
	id SERIAL PRIMARY KEY,
	from_pack_animals_id BIGINT UNSIGNED NOT NULL, 
	name VARCHAR(45),
	birth_date DATE,
	command VARCHAR(200),
	FOREIGN KEY (from_pack_animals_id) REFERENCES pack_animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Заполнить таблицы данными о животных, их командах и датами рождения:
INSERT INTO animals(group_type)
VALUES
	('pets'),
    ('pack_animals');
    
INSERT INTO pets(from_animals_id, animal_type)
VALUES
	(1, 'dog'),
	(1, 'cat'),
	(1, 'hamster');
    
INSERT INTO pack_animals(from_animals_id, animal_type)
VALUES
	(2, 'horse'),
	(2, 'camel'),
	(2, 'donkey');
    
INSERT INTO dog(from_pets_id, name, birth_date, command)
VALUES
	(1, 'Fido', '2020-01-01', 'sit, stay, fetch'),
	(1, 'Buddy', '2018-12-10', 'sit, paw, bark'),
	(1, 'Bella', '2019-11-11', 'sit, stay, roll');
    
INSERT INTO cat(from_pets_id, name, birth_date, command)
VALUES
	(2, 'Whiskers', '2019-05-15', 'sit, pounce'),
	(2, 'Smudge', '2020-02-20', 'cit, pounce, scratch'),
	(2, 'Oliver', '2020-06-30', 'meow, scratch, jump');
    
INSERT INTO hamster(from_pets_id, name, birth_date, command)
VALUES
	(3, 'Hammy', '2021-03-10', 'roll, hide'),
	(3, 'Peanut', '2021-08-01', 'roll, spin'),
	(3, 'Chip', '2021-05-12', 'hide, spin');
    
INSERT INTO horse(from_pack_animals_id, name, birth_date, command)
VALUES
	(1, 'Thunder', '2015-07-21', 'trot, canter, gallop'),
	(1, 'Storm', '2014-05-05', 'trot, canter'),
	(1, 'Blaze', '2016-02-29', 'trot, jump, gallop');
    
INSERT INTO camel(from_pack_animals_id, name, birth_date, command)
VALUES
	(2, 'Sandy', '2016-11-03', 'walk, carry load'),
	(2, 'Dune', '2018-12-12', 'walk, sit'),
	(2, 'Sahara', '2015-08-14', 'walk, run');
    
INSERT INTO donkey(from_pack_animals_id, name, birth_date, command)
VALUES
	(3, 'Eeyore', '2017-09-18', 'walk, carry load, bray'),
	(3, 'Burro', '2019-01-23', 'walk, bray, kick'),
	(3, 'Alga', '2018-05-21', 'walk, kick');

-- Удалить записи о верблюдах.
DROP TABLE camel;

-- Oбъединить таблицы лошадей и ослов.
CREATE TABLE IF NOT EXISTS horse_and_donkey(
	id SERIAL PRIMARY KEY,
    name VARCHAR(45), 
    type VARCHAR(45), 
    birth_date DATE,
    command VARCHAR(200),
    from_animals_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (from_animals_id) REFERENCES animals(id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO horse_and_donkey(name, type, birth_date, command, from_animals_id)
SELECT name, animal_type as type, birth_date, command, 2 FROM pack_animals p
JOIN horse h ON p.id = h.from_pack_animals_id
UNION
SELECT name, animal_type as type, birth_date, command, 2 FROM pack_animals p
JOIN donkey d ON p.id = d.from_pack_animals_id;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
CREATE TABLE IF NOT EXISTS new_animals_table
(
	id SERIAL PRIMARY KEY,
	name VARCHAR(45), 
	type VARCHAR(45), 
    birth_date DATE,
    command VARCHAR(200)
);
INSERT INTO new_animals_table (name, type, birth_date, command)
SELECT name, animal_type as type, birth_date, command FROM animals a
JOIN pets p ON a.id = p.from_animals_id
JOIN dog d ON p.id = d.from_pets_id
WHERE (TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) / 12) < 3
UNION
SELECT name, animal_type as type, birth_date, command FROM animals a
JOIN pets p ON a.id = p.from_animals_id
JOIN cat c ON p.id = c.from_pets_id
WHERE (TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) / 12) < 3
UNION
SELECT name, animal_type as type, birth_date, command FROM animals a
JOIN pets p ON a.id = p.from_animals_id
JOIN hamster h ON p.id = h.from_pets_id
WHERE (TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) / 12) < 3
UNION
SELECT name, type, birth_date, command FROM animals a
JOIN horse_and_donkey hd ON a.id = hd.from_animals_id
WHERE (TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) / 12) < 3;


-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
-- 1. Pets
CREATE TABLE IF NOT EXISTS general_table_pets(
	id SERIAL PRIMARY KEY,
    name VARCHAR(45), 
    type VARCHAR(45), 
    birth_date DATE,
    command VARCHAR(200)
); 
INSERT INTO general_table_pets(name, type, birth_date, command)
SELECT name, animal_type as type, birth_date, command FROM pets p
JOIN dog d ON p.id = d.from_pets_id
UNION
SELECT name, animal_type as type, birth_date, command FROM pets p
JOIN cat c ON p.id = c.from_pets_id
UNION
SELECT name, animal_type as type, birth_date, command FROM pets p
JOIN hamster h ON p.id = h.from_pets_id;

-- 2. pack_animals
CREATE TABLE IF NOT EXISTS general_table_pack_animals 
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(45),
    type VARCHAR(45),
    birth_date DATE,
    command VARCHAR(200)
); 
INSERT INTO general_table_pack_animals(name, type, birth_date, command)
SELECT name, animal_type as type, birth_date, command FROM pack_animals p
JOIN horse h ON p.id = h.from_pack_animals_id
UNION
SELECT name, animal_type as type, birth_date, command FROM pack_animals p
JOIN donkey d ON p.id = d.from_pack_animals_id;
