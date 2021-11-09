INSERT INTO users (`id_user`, `username`, `email`, `age`, `password`) VALUES ('25b39673bfa841c7aba80f4233d32c41', 'filip', 'filip@mail.com', 32, 'sha256-hash');
INSERT INTO users (`id_user`, `username`, `email`, `age`, `password`) VALUES ('25b39673bfa841c7aba80f4233d32c42', 'marin', 'marin@mail.com', 27, 'sha256-hash');
INSERT INTO users (`id_user`, `username`, `email`, `age`, `password`) VALUES ('25b39673bfa841c7aba80f4233d32c43', 'mislav', 'mislav@mail.com', 22, 'sha256-hash');

INSERT INTO materials (`id_material`, `name`, `id_user_created_by`) VALUES (1, 'Drvo', '25b39673bfa841c7aba80f4233d32c41');
INSERT INTO materials (`id_material`, `name`, `id_user_created_by`) VALUES (2, 'Metal', '25b39673bfa841c7aba80f4233d32c42');
INSERT INTO materials (`id_material`, `name`, `id_user_created_by`) VALUES (3, 'Čelik', '25b39673bfa841c7aba80f4233d32c42');
INSERT INTO materials (`id_material`, `name`, `id_user_created_by`) VALUES (4, 'Pijesak', '25b39673bfa841c7aba80f4233d32c42');
INSERT INTO materials (`id_material`, `name`, `id_user_created_by`) VALUES (5, 'Plastika', '25b39673bfa841c7aba80f4233d32c43');