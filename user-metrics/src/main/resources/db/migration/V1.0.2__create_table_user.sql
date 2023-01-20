create table app_user
(
    id          serial not null primary key,
    email       varchar(255),
    external_id varchar(255),
    name        varchar(255),
    username    varchar(255),
    active      bool default true,
    created_at  timestamp,
    updated_at  timestamp
);

CREATE TRIGGER trigger_app_user
    BEFORE INSERT OR
UPDATE ON app_user
    FOR EACH ROW
    EXECUTE PROCEDURE trigger_set_timestamp();