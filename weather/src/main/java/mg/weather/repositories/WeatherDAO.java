package mg.weather.repositories;

import mg.weather.dbentities.CurrentWeatherDBEntity;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WeatherDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<CurrentWeatherDBEntity> searchCurrentWeather(String cityNamePart) {
        FullTextQuery jpaQuery = getSearchCurrentWeatherQuery(cityNamePart);
        return jpaQuery.getResultList();
    }

    private FullTextQuery getSearchCurrentWeatherQuery(String cityNamePart) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(CurrentWeatherDBEntity.class)
                .get();
        Query query = queryBuilder.keyword().fuzzy().onField("cityName").boostedTo(5f).matching(cityNamePart).createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, CurrentWeatherDBEntity.class);
        return fullTextQuery;
    }
}
