CREATE TABLE items
(
	Id SERIAL PRIMARY KEY,
	Title CHARACTER VARYING(30),
	created_at timestamp,
	group_id INT NOT NULL,
	CONSTRAINT fk_group FOREIGN KEY(group_id) REFERENCES groups(id) ON DELETE CASCADE
)