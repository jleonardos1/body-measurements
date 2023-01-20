package br.com.body_measurements;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtils {

    public static Timestamp convert(Date date) {
        return new Timestamp(date.getTime());
    }
}
