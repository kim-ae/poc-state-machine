CREATE TABLE IF NOT EXISTS  my_stateful_entity (
	id int(11),
	business_id varchar(255),
	state varchar(255) not null,
	property_one varchar(255) ,
	property_two tinyint(1),
	property_three int(11),
	PRIMARY KEY(id),
	UNIQUE(business_id)
);