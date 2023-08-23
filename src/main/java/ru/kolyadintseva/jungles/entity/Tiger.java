package ru.kolyadintseva.jungles.entity;

public class Tiger {
    // 220 hp
    //  220 энергии
    // коэффициент зубов – сколько энергии тигр получает, когда кого-то съест
    private int health = 200;
    private int energy = 200;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFANGS() {
        return 2.5;
    }
}

