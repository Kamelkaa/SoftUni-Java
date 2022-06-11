package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun model) {
        if (models.stream().noneMatch(gun -> gun.getName().equals(model.getName()))) {
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream()
                .filter(gun -> gun.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
