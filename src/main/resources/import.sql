INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 1', 'usuário1', 'pasta do admin1', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');
INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 2', 'usuário2', 'pasta do admin2', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');
INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 3', 'usuário3', 'pasta do admin3', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');


INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, id_computer_fk) VALUES ('Lexmark', 'MX410', 'SN444', '192.168.1.151', 1500, 10000, 155000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 1);
INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, id_computer_fk) VALUES ('Lexmark', 'MX511', 'SN555', '192.168.1.151', 5200, 20000, 280000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 2);
INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, id_computer_fk) VALUES ('Lexmark', 'MX711', 'SN777', '192.168.1.151', 1800, 45000, 732000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 3);

INSERT INTO tb_customer(name, cpf_cnpj, email, company, cell_phone, phone, street_address, zip_code_address, number_address, complement_address, district_address, city_address, state_address, country_address, comments) VALUES ('Cliente 1', '012321102', 'cliente1@one.com', 'Empresa One', '(24) 99999-9999', '(24) 2121-2121','Rua do consumo', '27000-000', '111', '1ª rua a direita', 'Campos Elíseos', 'Resende', 'RJ', 'Brasil', 'primeiro cliente da empresa');
INSERT INTO tb_customer(name, cpf_cnpj, email, company, cell_phone, phone, street_address, zip_code_address, number_address, complement_address, district_address, city_address, state_address, country_address, comments) VALUES ('Cliente 2', '012321102', 'cliente1@two.com', 'Empresa Two', '(24) 99999-9999', '(24) 2121-2121','Rua do consumo', '27000-000', '222', '2ª rua a direita', 'Campos Elíseos', 'Resende', 'RJ', 'Brasil', 'segundo cliente da empresa');
INSERT INTO tb_customer(name, cpf_cnpj, email, company, cell_phone, phone, street_address, zip_code_address, number_address, complement_address, district_address, city_address, state_address, country_address, comments) VALUES ('Cliente 3', '012321102', 'cliente1@three.com', 'Empresa Three', '(24) 99999-9999', '(24) 2121-2121','Rua do consumo', '27000-000', '333', '3ª rua a direita', 'Campos Elíseos', 'Resende', 'RJ', 'Brasil', 'segundo cliente da empresa');

INSERT INTO tb_printer (manufacturer, model, serial_number, active) VALUES ('Xerox', 'XC1040', '123XC321', true);
INSERT INTO tb_printer (manufacturer, model, serial_number, active) VALUES ('Minolta', 'MN1060', '12MNC321', true);
INSERT INTO tb_printer (manufacturer, model, serial_number, active) VALUES ('Canon', 'CN2020', '123CN321', true);

INSERT INTO tb_customer_printers(customer_id, printers_id) VALUES (1, 1);
INSERT INTO tb_customer_printers(customer_id, printers_id) VALUES (1, 2);
INSERT INTO tb_customer_printers(customer_id, printers_id) VALUES (2, 3);

INSERT INTO tb_user(first_name, last_name, email, password) VALUES ('Bruno', 'Carvalho', 'boakdev@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user(first_name, last_name, email, password) VALUES ('Andreia', 'Farias', 'andreia@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role(authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2, 1);