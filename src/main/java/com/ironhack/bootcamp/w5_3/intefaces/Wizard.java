package com.ironhack.bootcamp.w5_3.intefaces;

public class Wizard extends Character{


    private Long mana;
    private Long intelligence;

    public Wizard() {
        this.setName("Wizard " + this.getName());
        this.mana = new Double(Math.random() * 100).longValue();
        this.intelligence = new Double(Math.random() * 100).longValue();
    }

    private void starHit(Character opponent) {
        opponent.hit(intelligence/4);
        this.mana += DEFAULT_RECOVERY;
    }

    private void fireball(Character opponent) {
        opponent.hit(intelligence/2);
        this.mana -= DEFAULT_WASTE;

    }


    @Override
    public boolean isAlive() {
        return mana > 0;
    }

    @Override
    public void throwAttack(Character opponent) {
        if (mana > 5) {
            fireball(opponent);
        } else {
            starHit(opponent);
        }
    }

    @Override
    public void hit(Long points) {
        this.mana -= points;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }

    public Long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Long intelligence) {
        this.intelligence = intelligence;
    }

}
