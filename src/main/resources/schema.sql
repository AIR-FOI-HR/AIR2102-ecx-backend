CREATE TABLE IF NOT EXISTS users (
                                              `id_user` VARCHAR(32) NOT NULL,
                                              `username` VARCHAR(45) NOT NULL,
                                              `password` CHAR(64) NULL,
                                              `email` CHAR(200) NULL,
                                              `age` INT NULL,
                                              PRIMARY KEY (`id_user`));

CREATE TABLE IF NOT EXISTS materials (
                                                  `id_material` INT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(45) NULL,
                                                  `id_user_created_by` VARCHAR(32) NOT NULL,
                                                  PRIMARY KEY (`id_material`),
                                                  CONSTRAINT `fk_materials_users`
                                                      FOREIGN KEY (`id_user_created_by`)
                                                          REFERENCES users (`id_user`)
                                                          ON DELETE CASCADE
                                                          ON UPDATE CASCADE);