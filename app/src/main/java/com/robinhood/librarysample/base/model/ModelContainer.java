package com.robinhood.librarysample.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ModelContainer<T> extends Model implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 5654676562017206443L;

    private List<T> models;

    public ModelContainer() {
        this.models = new ArrayList<T>();
    }

    public void clear() {
        models.clear();
    }

    public boolean isEmpty() {
        return models.isEmpty();
    }

    public int count() {
        return models.size();
    }

    public T get(int index) {
        return models.get(index);
    }

    public T getFirst() {
        T model = null;
        if (!isEmpty()) {
            model = models.get(0);
        }
        return model;
    }

    public T getLast() {
        T model = null;
        if (!isEmpty()) {
            model = models.get(count() - 1);
        }
        return model;
    }

    public void add(T model) {
        models.add(model);
    }

    public void addAll(List<T> models) {
        if (models != null) {
            this.models.addAll(models);
        }
    }

    public T remove(int index) {
        return models.remove(index);
    }

    public void remove(T model) {
        models.remove(model);
    }

    public List<T> getModels() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public Iterator<T> iterator() {
        return models.iterator();
    }
}