package apps.xenione.com.repoinapp.lib;

import java.util.List;

public class BaseRepository<T> {

    private DataSource<T> mDataSource;

    public BaseRepository(DataSource<T> dataSource) {
        this.mDataSource = dataSource;
    }

    public List<T> match(Matchable<T> criteria) {
        return mDataSource.selector(criteria);
    }

    public T matchSingle(Matchable<T> someCriteria) {
        List<T> matches = match(someCriteria);
        if (matches.isEmpty()) {
            return null;
        }
        return matches.get(0);
    }

    public boolean update(T t) {
        return mDataSource.update(t);
    }

    public long save(T t) {
        return mDataSource.save(t);
    }

    public void delete(T t) {
        mDataSource.delete(t);
    }

    public void delete() {
        mDataSource.clear();
    }
}