package mg.weather.repository;

import mg.weather.dbentity.CurrentWeatherDBEntity;
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
public class CurrentWeatherDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<CurrentWeatherDBEntity> searchCurrentWeather(String cityNamePart, String descriptionPart) {
        FullTextQuery jpaQuery = getSearchCurrentWeatherQuery(cityNamePart, descriptionPart);
        return jpaQuery.getResultList();
    }

    private FullTextQuery getSearchCurrentWeatherQuery(String cityNamePart, String descriptionPart) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(CurrentWeatherDBEntity.class)
                .get();
        Query query = queryBuilder.bool()
                .should(queryBuilder.keyword()
                        .fuzzy()
                        .onField("description")
                        .matching(descriptionPart)
                        .createQuery())
                .should(queryBuilder.keyword()
                        .fuzzy()
                        .onField("cityName")
                        .matching(cityNamePart)
                        .createQuery())
                .minimumShouldMatchNumber(2)
                .createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, CurrentWeatherDBEntity.class);
        return fullTextQuery;
    }
}
