INSERT INTO instructor (name,email)
VALUES
    ('Arav', 'arav@gmail.com'),
    ('Aria', 'aria@gmail.com'),
    ('Arun', 'arun@gmail.com');

INSERT INTO instructor_profile (bio, experience)
VALUES
    ('I am engineer', 3 ),
    ('I am doctor', 10),
    ('I am teacher', 5);

INSERT INTO course (title, instructor_id)
VALUES
('Maths', 1),
('Science', 2),
('History', 3),
('English', 1),
('Geology', 2),
('Computers', 2);


INSERT INTO Review(rating,  course_id)
VALUES
('Good', 1),
('Nice explanation', 1),
('Very informative', 2);

INSERT INTO Student(name)
VALUES
('Sita'),
('Geeta'),
('Neha');
