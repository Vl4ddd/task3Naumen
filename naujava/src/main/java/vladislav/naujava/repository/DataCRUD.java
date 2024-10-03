package vladislav.naujava.repository;

public interface DataCRUD<U, ID> {
    void create(U entity);

    U read(ID id);

    void update(U entity);

    void delete(ID id);
}
