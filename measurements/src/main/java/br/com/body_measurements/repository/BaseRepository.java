package br.com.body_measurements.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseRepository<Entity> implements PanacheRepository<Entity> {

    public List<Class> search(String query, Map params, Class targetClass) {

        Query q = getEntityManager().createNativeQuery(query);
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            q.setParameter(entry.getKey(), entry.getValue());
        }

        return q.unwrap(NativeQuery.class)
                .setResultTransformer(Transformers.aliasToBean(targetClass))
                .list();
    }
}
