-- passwords are "test1" for everyone except for the pair "admin"-"Test1234"

INSERT INTO users (`last_name`, `email`, `first_name`, `password`, `phone_number`, `fax_number`, `title`)
VALUES ('admin', 'admin@wb.com', 'admin', '6iFFXZ1ot+1V2YNBJ8ttyA==.LVn//EVRnSBvBp50mwgTGrNHjCwLS6lrVCPoQKgZ6ss=',
        '(048) 16355847', '(039807) 631847', 'scrum'),
       ('Jurić Grgić', 'luka@wb.com', 'Luka',
        '3PNLE+sy8S6dfIq1IM3GNQ==.Y+yesFXlVXgvHbEj1vsl9bUarR90xHOKBMULPQXChK0=', '(01755) 7878680', '(0211) 11691332',
        'dr.'),
       ('Matijević', 'mislav@wb.com', 'Mislav',
        'tsqZpTysbKCx7rUXWh5TRA==.JSbuKeGkgtjZQtUwJ7QFh+G2ADerk7zM9olWnF9rYsM=', '(0598) 14581772', '(03219) 3283921',
        'prof.'),
       ('Mustać', 'mateo@wb.com', 'Mateo', 'kMMijQwFPHQ5lYxnasqbWg==.XuU3WnnzQbHa8I81p8BGeJgvkgTqML4rJ6xLoBkn/lo=',
        '(008) 83646456', '(0351) 32886447', 'mr.'),
       ('Nižić', 'mario@wb.com', 'Mario', '+2//mjdnM8wdydXs0fySYg==.bJ/fBd/H8Ssj9HOqJX7EZG9rnuwFYw3UmZBc1rzQ19o=',
        '(073) 92161434', '(038874) 178445', 'mr.'),
       ('Posarić', 'lovro@wb.com', 'Lovro', 'Fn8sgw9iy4j3Xom5CHuoTQ==.ejc75exCjOZs4JNwmSt6PcBjm5XCfqP1oD076L1E44Q=',
        '(032411) 025193', '(037695) 513296', 'doc.');


--
INSERT INTO CUSTOMERS (`ADDRESS_CITY`, `ADDRESS_COUNTRY_CODE`, `ADDRESS_POST_CODE`, `ADDRESS_STREET`, `APPROVED`,
                       `NAME`, `PARW`)
VALUES ('September', 'Be', '18732', '384-9700 Nonummy St.', 'n', 'Non Lobortis PC', 'yz'),
       ('Darrel', 'Me', '65328', '7649 Consequat St.', 'n', 'Nisl Quisque Ltd', 'yy'),
       ('Bell', 'Ge', '7372 NS', '5997 Orci. Av.', 'y', 'Tellus Justo Sit Limited', 'xx'),
       ('Noelani', 'Au', '54996-141', '1457 Orci Ave', 'y', 'Sit Amet Ltd', 'zz'),
       ('Declan', 'Sw', '7279', '876-7212 Sociosqu Road', 'y', 'Lorem Lorem Industries', 'zz'),
       ('Abra', 'Pa', '6717 NQ', '715-8694 Molestie Rd.', 'y', 'Velit Pellentesque Ltd', 'yz'),
       ('Haviva', 'Co', '22512', 'Ap #353-1908 Nulla Road', 'y', 'Quis Turpis Incorporated', 'zx'),
       ('Oleg', 'Ge', '2478', 'P.O. Box 675, 7755 Amet Avenue', 'y', 'Dolor Dapibus Gravida PC', 'zz'),
       ('Dustin', 'Pe', '20632-509', 'P.O. Box 415, 8531 Risus, Ave', 'n', 'A Scelerisque LLP', 'yy'),
       ('Rafael', 'Ch', '307520', 'P.O. Box 618, 4912 At Av.', 'n', 'Tellus Sem Industries', 'xx');
INSERT INTO CUSTOMERS (`ADDRESS_CITY`, `ADDRESS_COUNTRY_CODE`, `ADDRESS_POST_CODE`, `ADDRESS_STREET`, `APPROVED`,
                       `NAME`, `PARW`)
VALUES ('Shelly', 'Me', '31768', 'Ap #759-2082 Nullam St.', 'n', 'Auctor Mauris Vel Consulting', 'zx'),
       ('Fay', 'Ge', '691138', '344-8253 Natoque Rd.', 'n', 'Faucibus Morbi PC', 'zz'),
       ('Zachary', 'Ch', '25770-365', '3604 Odio. St.', 'y', 'Lorem Sit Associates', 'zx'),
       ('Mohammad', 'Sp', '63116', '900-2252 Euismod St.', 'y', 'Mauris Aliquam Industries', 'yy'),
       ('Germaine', 'Au', '1026', '976-1198 Sed Avenue', 'n', 'Mauris Inc.', 'yy'),
       ('Kirsten', 'Ni', '58851-265', '838-3128 Erat Ave', 'y', 'Gravida Sagittis Duis Associates', 'yy'),
       ('Paloma', 'Be', '410774', '5835 Sociis Avenue', 'y', 'Sed Incorporated', 'zz'),
       ('Joelle', 'Br', 'O4W 4BY', '427-7672 Varius Avenue', 'n', 'Lacinia Sed PC', 'xx'),
       ('Arthur', 'Pa', '51952', 'Ap #610-735 Vehicula Avenue', 'n', 'Risus Odio Ltd', 'yz'),
       ('Zelenia', 'Sw', '3136', '1763 Feugiat St.', 'y', 'Mauris Aliquam Industries', 'zx');

INSERT INTO USERS_CUSTOMERS (`ID_USER`, `ID_CUSTOMER`)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 7),
       (2, 12),
       (2, 15),
       (3, 15),
       (3, 16),
       (3, 20),
       (4, 15),
       (4, 12),
       (4, 17),
       (5, 19),
       (5, 20),
       (5, 11),
       (6, 9),
       (6, 8),
       (6, 1);