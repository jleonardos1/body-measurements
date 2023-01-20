package br.com.body_measurements;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Dependent
public class QueryLoaderUtil {
    private static final String EXTENSION = ".sql";

    public String getQuery(String path, String queryName) {

        try {
            return new String(Files.readAllBytes(Paths.get(path.concat(queryName).concat(EXTENSION))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
