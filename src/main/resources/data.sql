INSERT INTO building_types (type, description) VALUES
    ('Business Building', 'Various business centers and Offices buildings.'),
    ('Storage Building', 'Various warehouses, transit sheds and buildings for storage or shelter of goods.'),
    ('Industrial Building', 'Various buildings, where products or material are fabricated, assembled or processed.'),
    ('Educational Building', 'Buildings exclusively used for a school or college recognized.');
INSERT INTO builder_specialties (specialty, description) VALUES
    ('Construction worker', 'A worker employed in manual labour of the physical construction of the built environment and its infrastructure.'),
    ('Construction inspector', 'Construction inspectors examine buildings, sewer and water systems, bridges, dams, and other structures.'),
    ('Flooring installer', 'Flooring installers are hired to complete new floor installations in homes and businesses.'),
    ('Brick mason', 'A worker whose trade is building with stones, bricks, cinder blocks, or tiles.'),
    ('Roofer', 'A worker who constructs or repairs roofs.');
INSERT INTO building_state (state, description) VALUES
    ('Planned construction', 'The construction is planned but not started.'),
    ('In progress', 'The construction has begun.'),
    ('Completed', 'The building is completed.'),
    ('Put into operation', 'Еhe building is put into operation.');
-- INSERT INTO user_roles (role, description) VALUES
--     ('Basic user', 'Read-only rights'),
--     ('Moderator', 'Moderator can edit data and add new buildings.'),
--     ('Admin', 'Admin can edit data and add new users and buildings.');
INSERT INTO machinery_types (type, description) VALUES
    ('Bulldozer', 'A powerful track-laying tractor with caterpillar tracks and a broad curved upright blade at the front for clearing ground.'),
    ('Excavator', 'A large machine for digging and moving earth.'),
    ('Trencher', 'A trencher is a piece of construction equipment used to dig trenches, especially for laying pipes or electrical cables, for installing drainage, or in preparation for trench warfare.'),
    ('Backhoe Loader', 'A machine that consists of a tractor-like unit fitted with a loader-style shovel/bucket on the front and a backhoe on the back.');
INSERT INTO machinery (producer, quantity, type) VALUES
    ('Cat', 2, 1),
    ('Volvo', 3, 2),
    ('Komatsu', 4, 3),
    ('Takeuchi', 3, 4),
    ('JCB', 4, 1),
    ('Cat', 2, 2);
INSERT INTO builders (first_name, last_name, specialty) VALUES
    ('John', 'Doe', 1),
    ('Bob', 'Marley', 2),
    ('Sherlock', 'Holmes', 3),
    ('Jane', 'Doe', 4),
    ('Tom', 'Sawer', 1),
    ('Tod', 'Smith', 2),
    ('David', 'Smith', 3);