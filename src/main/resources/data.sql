INSERT INTO building_types (type) VALUES
    ('Multi-story building'),
    ('Business center');
INSERT INTO builder_specialties (specialty) VALUES
    ('Builder'),
    ('Electrician');
INSERT INTO buildings (progress, floors, building_type, builder_company) VALUES
    (75, 9, 1, 'Avalon'),
    (100, 10, 2, 'DBK');
INSERT INTO builders (first_name, last_name, specialty) VALUES
    ('John', 'Doe', 1),
    ('Bob', 'Marley', 2),
    ('David', 'Smith', 1);