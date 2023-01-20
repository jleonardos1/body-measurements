create table app_measurement
(
    id         serial primary key,
    name       varchar NOT NULL,
    active     bool default true,
    created_at timestamp,
    updated_at timestamp
);

CREATE TRIGGER trigger_app_measurement
    BEFORE INSERT OR
UPDATE ON app_measurement
    FOR EACH ROW
    EXECUTE PROCEDURE trigger_set_timestamp();

insert into app_measurement (name)
values ('Weight');
insert into app_measurement (name)
values ('Chest');
insert into app_measurement (name)
values ('Waist');
insert into app_measurement (name)
values ('Hip');
insert into app_measurement (name)
values ('Left triceps');
insert into app_measurement (name)
values ('Right triceps');
insert into app_measurement (name)
values ('Left biceps');
insert into app_measurement (name)
values ('Right biceps');
insert into app_measurement (name)
values ('Left biceps');
insert into app_measurement (name)
values ('Right biceps');
insert into app_measurement (name)
values ('Left thigh');
insert into app_measurement (name)
values ('Right thigh');
insert into app_measurement (name)
values ('Left calf');
insert into app_measurement (name)
values ('Right calf');