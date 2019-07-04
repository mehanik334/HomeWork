
package denisenko.hw7.dao;

import denisenko.hw7.model.Client;

public interface ClientDao {
    void save(Client client);

    Client get();
}
