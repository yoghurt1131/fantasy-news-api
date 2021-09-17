package dev.yoghurt1131.fantasynewsapi.domain;

public enum Category {
    World(1),
    Politics(2),
    Tech(3),
    Science(4),
    Health(5),
    Sports(6),
    Arts(7),
    Books(8),
    Food(9);

    private int id;

    private Category(int id) {
        this.id = id;
    }
}
