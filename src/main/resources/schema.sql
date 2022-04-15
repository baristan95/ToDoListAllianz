DROP TABLE IF EXISTS TBL_JOBS;

CREATE TABLE TBL_JOBS (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               name VARCHAR(250) NOT NULL,
                               description VARCHAR(500) NOT NULL,
                               status VARCHAR(20) DEFAULT NULL
);