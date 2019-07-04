package denisenko.hw7.dao;

import denisenko.hw7.model.Human;

public interface HumanDao {

    void save(Human human);

    Human get();
}
