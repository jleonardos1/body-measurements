CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  IF(OLD.created_at is null) THEN
    NEW.created_at = NOW();
  END IF;

  NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;