create table app_user_metrics
(
    id      serial primary key,
    user_id integer,
    items   jsonb,
    active      bool default true,
    created_at  timestamp,
    updated_at  timestamp
);

CREATE TRIGGER trigger_app_user_metrics
    BEFORE INSERT OR
UPDATE ON app_user_metrics
    FOR EACH ROW
    EXECUTE PROCEDURE trigger_set_timestamp();