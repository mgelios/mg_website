package mg.weather.mock;

import mg.weather.entity.OneCall;
import mg.weather.repository.OneCallRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMock {

    public static OneCallRepository getOneCallRepository() {
        OneCallRepository repository = Mockito.spy(OneCallRepository.class);
        List<OneCall> repositoryData = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(repositoryData);
        return repository;
    }
}
