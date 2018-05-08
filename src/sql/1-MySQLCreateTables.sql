-- ----------------------------------------------------------------------------
-- "iTarea" Create Tables.
-------------------------------------------------------------------------------

-- Indexes for primary keys have been explicitly created.

-- ---------- Table for validation queries from the connection pool -----------

DROP TABLE IF EXISTS PingTable;
CREATE TABLE PingTable (foo CHAR(1));

-- -----------------------------------------------------------------------------
-- Drop tables. NOTE: before dropping a table (when re-executing the script),
-- the tables having columns acting as foreign keys of the table to be dropped,
-- must be dropped first (otherwise, the corresponding checks on those tables
-- could not be done).

DROP TABLE IF EXISTS Task;

-- ------------------------------- Task ------------------------------------

CREATE TABLE Task (
	taskId BIGINT NOT NULL AUTO_INCREMENT,
	taskDescription VARCHAR(500) NOT NULL,
	startDate TIMESTAMP NULL,
	finishDate TIMESTAMP NULL,
	version BIGINT,
	
	CONSTRAINT TaskPK PRIMARY KEY (taskId)

) ENGINE = InnoDB;
