package mg.weather.repository;

//@Repository
public class CurrentWeatherDAO {

//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    public List<CurrentWeather> searchCurrentWeather(String cityNamePart, String descriptionPart) {
//        FullTextQuery jpaQuery = getSearchCurrentWeatherQuery(cityNamePart, descriptionPart);
//        return jpaQuery.getResultList();
//    }
//
//    private FullTextQuery getSearchCurrentWeatherQuery(String cityNamePart, String descriptionPart) {
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
//                .buildQueryBuilder()
//                .forEntity(CurrentWeather.class)
//                .get();
//        Query query = queryBuilder.bool()
//                .should(queryBuilder.keyword()
//                        .fuzzy()
//                        .onField("description")
//                        .matching(descriptionPart)
//                        .createQuery())
//                .should(queryBuilder.keyword()
//                        .fuzzy()
//                        .onField("cityName")
//                        .matching(cityNamePart)
//                        .createQuery())
//                .minimumShouldMatchNumber(2)
//                .createQuery();
//        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, CurrentWeather.class);
//        return fullTextQuery;
//    }
}
