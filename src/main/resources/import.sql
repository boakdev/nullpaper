INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 1', 'usuário1', 'pasta do admin1', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');
INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 2', 'usuário2', 'pasta do admin2', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');
INSERT INTO tb_computer (computer_name, user_name, user_folder, nameos, versionos, arcos, ip_address_computer, country_system, language_system, serialhd, serialcpu, serial_motherboard, serialmac ) VALUES ('PC 3', 'usuário3', 'pasta do admin3', 'Windows', 'win 10', '32bit', '192.168.0.100', 'Brazil', 'portuguese', 'hd123321', 'cpu222333', 'mb852258', 'mac987789');


INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, computer_id) VALUES ('Lexmark', 'MX410', 'SN444', '192.168.1.151', 1500, 10000, 155000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 1);
INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, computer_id) VALUES ('Lexmark', 'MX511', 'SN555', '192.168.1.151', 5200, 20000, 280000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 2);
INSERT INTO tb_printerread (manufacturer, model, serial_number, ip_address, toner_remaining, toner_capacity, total_pages, date, computer_id) VALUES ('Lexmark', 'MX711', 'SN777', '192.168.1.151', 1800, 45000, 732000, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 3);