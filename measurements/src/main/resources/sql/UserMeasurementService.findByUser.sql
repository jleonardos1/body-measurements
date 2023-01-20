select um.measurement_id as "measurementId",
       m.id,
       m.name,
       um.value,
       um.recorded_at    as "recordedAt",
       um.user_id        as "userId"
from app_measurement m
         inner join app_user_measurement um
                    on m.id = um.measurement_id
where um.user_id = :user_id
  and m.active
  and um.active
