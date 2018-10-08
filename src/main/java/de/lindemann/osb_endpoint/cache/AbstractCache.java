package de.lindemann.osb_endpoint.cache;

import de.lindemann.osb_endpoint.model.Binding;

import java.util.*;

public abstract class AbstractCache<T> {
    private Map<String, T> cacheMap = new HashMap<>();


    public Optional<T> get(String id) {
        return Optional.ofNullable(cacheMap.get(id));
    }

    public void put(String id, T t) {
        cacheMap.put(id, t);
    }

    public void delete(String id) {
        cacheMap.remove(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(cacheMap.values());
    }
}
