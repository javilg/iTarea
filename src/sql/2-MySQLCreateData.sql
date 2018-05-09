
-- Task -------------------------------------------------------------

DELETE FROM Task;

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (1, 'Comprar ordenador all-in-one para casa.', '2018-05-08 17:05:31', null, 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (2, 'Reservar cena en restaurante el fin de semana.', '2018-05-08 18:24:12', '2018-05-08 19:50:00', 1);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (3, 'Arreglar cambio de marchas de bicicleta.', '2018-05-08 19:56:44', '2018-05-08 21:15:44', 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (4, 'Revisar lista de compra alimentación.', '2018-05-08 19:59:02', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (5, 'Devolver producto de perfumería en centro comercial.', '2018-05-08 20:14:31', '2018-05-08 23:20:11', 1);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (6, 'Ver serie en Mega.', '2018-05-08 21:30:09', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (7, 'Pedir cita ITV coche para el mes siguiente.', '2018-05-09 09:49:10', null, 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (8, 'LLamar a Juan para felicitarle.', '2018-05-09 09:55:25', '2018-05-09 09:59:25', 1);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (9, 'Recoger paquete de Amazon en Correos mañana.', '2018-05-09 10:15:10', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (10, 'Ir a peluquería el Viernes sin falta.', '2018-05-07 10:40:10', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (11, 'Comprar película Piratas del Caribe para regalo.', '2018-05-07 12:35:10', null, 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (12, 'Subir vídeo nuevo en canal de YouTube.', '2018-05-05 14:35:10', null, 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (13, 'Pagar gastos de la comunidad del mes pasado.', '2018-05-03 16:56:10', '2018-05-03 20:56:10', 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (14, 'Arreglar escritorio habitación.', '2018-05-01 17:10:10', null, 0);
