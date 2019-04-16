package denisenko.hw7.dao;

import denisenko.hw7.di.Component;
import denisenko.hw7.model.Human;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryHumanDao implements HumanDao {

    private static final List<Human> storageHumans = new ArrayList<>();

    @Override
    public void save(Human human) {
        storageHumans.add(human);
    }

    @Override
    public Human get() {
        return storageHumans.get(0);
    }
}
