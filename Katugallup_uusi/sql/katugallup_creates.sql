CREATE TABLE kysymys(
kysymys_id char(8) NOT NULL,
Kysymysteksti varchar(300) NOT NULL,
PRIMARY KEY (kysymys_id)
)Engine="InnoDB";


CREATE TABLE vastaus(
vastaus_id char(8) NOT NULL,
vastausteksti char(255) NOT NULL,
vastausaika varchar(20) NOT NULL,
vastaaja char(100),
kysymys_id char(8),
PRIMARY KEY (vastaus_id),
FOREIGN KEY (kysymys_id) REFERENCES kysymys (kysymys_id)
)Engine="InnoDB";
