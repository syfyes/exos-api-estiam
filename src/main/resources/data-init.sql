INSERT INTO role (name) VALUES
   ('admin'),
   ('moderator'),
   ('customer');

INSERT INTO app_user (email, password, role_id) VALUES
    ('a@a.com', 'root', 1),
    ('b@b.com', 'root', 2),
    ('c@c.com', 'root', 3);

INSERT INTO project (name, is_private, owner_id) VALUES
    ('gobelet', false, 2),
    ('vase', true, 3),
    ('visage', false, 3);

INSERT INTO tag (name) VALUES
     ('deco'),
     ('entreprise'),
     ('fleurs');

INSERT INTO tag_project (project_id, tag_id) VALUES
   (1, 1),
   (1, 2),
   (2, 1),
   (2, 3);

INSERT INTO image (url, project_id) VALUES
   ('https://picsum.photos/id/10/400/300', 1),
   ('https://picsum.photos/id/11/400/300', 1),
   ('https://picsum.photos/id/12/400/300', 2),
   ('https://picsum.photos/id/13/400/300', 3);
