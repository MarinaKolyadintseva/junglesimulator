package ru.kolyadintseva.jungles.util;

import ru.kolyadintseva.jungles.entity.Tiger;

public class EventSimulator {
    //0 – 40 //40%//тигр поспал - +7 энергии
    //40 – 60//20%//тигр просто пробежал – 5 энергии
    //60 – 80//20%//тигр съел кабана coeff – 10  = energy; + coeff * 4 здоровья
    //80 – 100//20%//на тигра напал бурый медведь – 20 здоровья
    //100 – 120 //40%//тигр поспал - +7 энергии
    //120 – 140//20%//тигр съел косулю coeff – 10  = energy; + coeff * 4 здоровья
    //140 – 160//20%//тигр просто пробежал – 5 энергии
    //160 – 180 //40%//тигр поспал - +7 энергии
    //180 – 200//20%//тигр съел буйвола coeff – 10  = energy; + coeff * 4 здоровья
    //200 – 220//20%//тигр просто пробежал – 5 энергии
    //энергия =  0  то -5 здоровья

    public void startSimulation(Tiger tiger) {
    // 0.0 * 200 = 0
    // 0.46 * 200 = 92.0 => (int) => 92
    // 1.0 * 200 = 200
        while (checkStatus(tiger)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 40) {
                sleepEvent(tiger);
            } else if (eventNumber >= 40 && eventNumber < 60) {
                move(tiger);
            } else if (eventNumber >= 60 && eventNumber < 80) {
                tigerEat(tiger);
            } else if (eventNumber >= 80 && eventNumber < 100) {
                brownBearAttack(tiger);
            } else if (eventNumber >= 100 && eventNumber < 120) {
                sleepEvent(tiger);
            } else if (eventNumber >= 120 && eventNumber < 140) {
                tigerEat(tiger);
            } else if (eventNumber >= 140 && eventNumber < 160) {
                move(tiger);
            } else if (eventNumber >= 160 && eventNumber < 180) {
                sleepEvent(tiger);
            } else if (eventNumber >= 180 && eventNumber < 200) {
                tigerEat(tiger);
            }
        }
        System.out.println("Ооо нет! Тигр умер! The end!");
    }

    public void sleepEvent(Tiger tiger) {
        int energy = tiger.getEnergy();
        energy = energy + 7;
        if (energy > 200) {
            energy = 200;
        }
        tiger.setEnergy(energy);
        checkEnergy(tiger);
        System.out.println("Тигр поспал! + 20 энергии. Текущая энергия: "+ tiger.getEnergy());
    }

    private void move(Tiger tiger) {
        int energy = tiger.getEnergy();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        tiger.setEnergy(energy);
        checkEnergy(tiger);
        System.out.println("Тигр побегал! - 5 энергии. Текущая энергия : " + tiger.getEnergy());
    }

    private void tigerEat(Tiger tiger) {
        int energy = tiger.getEnergy();
        int health = tiger.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health + (int) (tiger.getFANGS() * 4);
        if (health > 200) {
            health = 200;
        }
        tiger.setEnergy(energy);
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("Тигр съел косулю! Текущая энергия: " + tiger.getEnergy() + " Текущее здоровье: " + tiger.getHealth());
    }

    private void brownBearAttack(Tiger tiger) {
        int health = tiger.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }
        tiger.setHealth(health);
        checkEnergy(tiger);
        System.out.println("На тигра напал бурый медведь! Текущее здоровье: " + tiger.getHealth());
    }


    //true – продолжается симуляция
    //false - умер

    private  boolean checkStatus(Tiger tiger) {
        System.out.println("hp:" + (tiger.getEnergy()));
        return tiger.getHealth() > 0;
    }

    private void checkEnergy (Tiger tiger) {
        if (tiger.getEnergy() <= 0) {
            int health = tiger.getHealth();
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
            tiger.setHealth(health);
        }
    }


}

