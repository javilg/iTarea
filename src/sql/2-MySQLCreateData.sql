
-- Task -------------------------------------------------------------

DELETE FROM Task;

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (1, 'Comprar ordenador all-in-one para casa.', '2018-05-08 17:05:31', null, 0);

INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (2, 'Reservar cena en restaurante el fin de semana.', '2018-05-08 18:24:12', '2018-05-08 19:50:00', 1);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (3, 'Arreglar cambio de marchas de bicicleta.', '2018-05-08 19:56:44', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (4, 'Revisar lista de compra alimentación.', '2018-05-08 19:59:02', null, 0);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (5, 'Devolver producto de perfumería en centro comercial.', '2018-05-08 20:14:31', '2018-05-08 23:20:11', 1);
	
INSERT INTO Task (taskId, taskDescription, startDate, finishDate, version)
	VALUES (6, 'Ver serie en Mega.', '2018-05-08 21:30:09', null, 0);
