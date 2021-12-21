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

INSERT INTO materials (`name`,`description`,`quantity`,`quantity_designation`,`cost`)
VALUES
    ('paper A4','non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor.',6,'six','45.60'),
    ('leather 1','mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat.',1,'one','65.15'),
    ('paper A3','rutrum lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis, tristique ac,',7,'seven','3.84'),
    ('metal 10m','Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus',5,'five','63.06'),
    ('leather 2','tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse',6,'six','23.35'),
    ('metal 5m','at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti sociosqu ad',6,'six','68.75'),
    ('metal 1m','quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie',3,'three','80.85'),
    ('paper A5','leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam auctor, velit eget laoreet posuere, enim nisl elementum purus, accumsan',2,'two','5.89'),
    ('leather 3','libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi sem semper erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque',3,'three','86.19'),
    ('metal 2.5m','Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac',5,'five','89.80');
INSERT INTO materials (`name`,`description`,`quantity`,`quantity_designation`,`cost`)
VALUES
    ('paperA1','quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at augue id ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada',3,'eight','25.65'),
    ('leather 4','mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta',2,'two','91.46'),
    ('fibers','mi. Aliquam gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam auctor, velit eget laoreet',8,'eight','75.66'),
    ('metal 1.5m','a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula aliquet libero. Integer in magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius orci,',2,'two','4.48'),
    ('paper A2','adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et,',6,'six','40.15'),
    ('wood 5m','Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper',5,'five','96.11'),
    ('metal 6m','euismod est arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus',9,'nine','88.19'),
    ('wood 10m','ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed turpis nec mauris blandit mattis. Cras eget nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna. Duis dignissim tempor arcu. Vestibulum ut eros non',6,'six','23.34'),
    ('wood 1m','Donec feugiat metus sit amet ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis non enim.',3,'three','86.77'),
    ('metal','vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel,',1,'one','78.53');

INSERT INTO orders (`customer_po_number`,`document_date`,`status`,`currency`,`payment_term`,`wish_delivery_date`,`first_possible_date`,`incoterm`,`net_worth`,`additional_project_info`)
VALUES
    (4,'2020-12-30','New','USD','CND','2021-01-15','2020-12-30','FOB','15345','Project has much potentional'),
    (14,'2021-01-12','In-progress','USD','contra','2021-04-22','2020-12-30','DDP','20000','Expect late delivery'),
    (11,'2021-01-05','New','EUR','contra','2021-02-02','2020-12-21','DAP','13000','what if'),
    (16,'2021-01-20','New','EUR','CIA','2021-01-28','2020-12-24','DAT','10000','if everything goes fine, this will be over soon'),
    (9,'2021-01-16','New','HRK','COD','2021-01-31','2020-12-19','DDP','17000','this is ok'),
    (7,'2021-01-22','In-progress','USD','contra','2020-12-27','2020-12-20','DAT','100000','looking good'),
    (14,'2021-01-21','In-progress','USD','CND','2021-05-23','2020-12-22','EXM','13000','testing'),
    (5,'2021-01-02','New','USD','contra','2021-01-16','2020-12-25','FAS','125430','good project'),
    (5,'2021-01-02','New','EUR','contra','2021-05-07','2020-12-26','CFR','13090','test your skills'),
    (4,'2021-01-26','In-progress','EUR','CND','2021-02-24','2020-12-30','FAS','10009','materials needed');
INSERT INTO orders (`customer_po_number`,`document_date`,`status`,`currency`,`payment_term`,`wish_delivery_date`,`first_possible_date`,`incoterm`,`net_worth`,`additional_project_info`)
VALUES
    (1,'2021-01-24','In-progress','USD','CWO','2021-06-11','2020-12-20','DDP','1000','this is good'),
    (18,'2020-12-20','New','USD','EOM','2021-04-25','2020-12-28','FAS','11010','looking great'),
    (12,'2020-12-31','New','EUR','EOM','2021-06-12','2020-12-22','CFR','1000','lets do this'),
    (19,'2020-12-31','New','EUR','PIA','2021-05-30','2020-12-19','CFR','1444','just do it'),
    (18,'2021-01-07','New','HRK','COD','2021-02-07','2020-12-25','DDP','19000','ok'),
    (5,'2021-01-26','New','HRK','CWO','2021-03-09','2020-12-24','DAT','34000','no comment'),
    (11,'2020-12-22','In-progress','USD','COD','2021-02-24','2020-12-24','DDP','13000','ambicious project'),
    (13,'2021-01-14','In-progress','EUR','contra','2021-04-16','2020-12-28','CFR','16200','testing your limits'),
    (1,'2021-01-17','New','EUR','EOM','2021-05-20','2020-12-22','CFR','14200','nice job'),
    (10,'2021-01-24','New','EUR','PIA','2021-03-14','2020-12-28','CFR','50000','give me a pass');

INSERT INTO tickets (`ticket_user`,`subject`,`status`,`message`,`resolve_message`)
VALUES
    (6,'application not working','Resolved','sed libero. Proin sed turpis nec mauris','ornare placerat, orci lacus vestibulum lorem'),
    (1,'working late cancel','Resolved','varius. Nam porttitor scelerisque neque. Nullam','aptent taciti sociosqu ad litora torquent per'),
    (1,'not working late','New','quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam',''),
    (2,'application not working','New','eget, volutpat ornare, facilisis eget, ipsum.',''),
    (3,'not working late','In-progress','pede. Praesent eu dui. Cum sociis',''),
    (4,'order damaged application','New','pede ac urna. Ut tincidunt vehicula risus.',''),
    (4,'working late cancel','In-progress','Integer sem elit, pharetra ut, pharetra sed',''),
    (5,'materials order damaged','In-progress','pede. Suspendisse dui. Fusce diam',''),
    (5,'not working late','Resolved','sed, facilisis vitae, orci. Phasellus dapibus quam quis diam.','Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac'),
    (6,'order damaged application','New','odio, auctor vitae, aliquet nec','');
INSERT INTO tickets (`ticket_user`,`subject`,`status`,`message`,`resolve_message`)
VALUES
    (2,'order damaged application','New','est. Mauris eu turpis. Nulla',''),
    (4,'materials order damaged','In-progress','sagittis placerat. Cras dictum',''),
    (5,'damaged application not','Resolved','purus mauris a nunc. In at pede. Cras','elit fermentum risus, at fringilla purus mauris'),
    (4,'working late cancel','New','Mauris nulla. Integer urna. Vivamus molestie dapibus',''),
    (2,'damaged application not','In-progress','metus eu erat semper rutrum. Fusce dolor quam, elementum at,',''),
    (5,'damaged application not','Resolved','adipiscing ligula. Aenean gravida nunc sed pede. Cum sociis','Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a,'),
    (6,'damaged application not','Resolved','vel lectus. Cum sociis natoque penatibus et magnis','nec metus facilisis lorem tristique aliquet. Phasellus'),
    (5,'materials order damaged','New','id sapien. Cras dolor dolor, tempus non, lacinia at,',''),
    (6,'not working late','In-progress','sapien imperdiet ornare. In faucibus. Morbi',''),
    (3,'damaged application not','Resolved','egestas. Fusce aliquet magna a','morbi tristique senectus et netus et');