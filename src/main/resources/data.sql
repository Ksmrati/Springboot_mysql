insert into user_details(id,name,birthdate)
values(1001,'pradeep',current_date());
insert into user_details(id,name,birthdate)
values(1002,'smrati',current_date());
insert into user_details(id,name,birthdate)
values(1003,'ishu',current_date());

insert into post(id,description,user_id)
values(101, 'i want to learn AWS', 1002);

insert into post(id,description,user_id)
values(102, 'i want to learn Azure', 1002);

insert into post(id,description,user_id)
values(103, 'i want to learn Microservices', 1001);