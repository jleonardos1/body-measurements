create table app_user_measurement
(
    id             serial primary key,
    user_id        integer NOT NULL,
    measurement_id integer,
    value          numeric,
    recorded_at    timestamp,
    active         bool default true,
    created_at     timestamp,
    updated_at     timestamp
);

CREATE TRIGGER trigger_app_user_measurement
    BEFORE INSERT OR
UPDATE ON app_user_measurement
    FOR EACH ROW
    EXECUTE PROCEDURE trigger_set_timestamp();
