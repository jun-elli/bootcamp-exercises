package com.ironhack.bootcamp.w5_3.intefaces;

public class  Warrior extends Character{

    private Long strength;
    private Long stamina;

    public Warrior () {
        super("generic");
        this.setName("Warrior " + this.getName());
        this.strength = new Double(Math.random() * 100).longValue();
        this.stamina = new Double(Math.random() * 100).longValue();
    }
    public Warrior (String name, Long strength, Long stamina) {
        super(name);
        this.setName("Warrior" + this.getName());
        this.strength = strength;
        this.stamina = stamina;
    }

    private void weakAttack(Character opponent) {
        opponent.hit(strength/4);
        this.stamina += DEFAULT_RECOVERY;
    }

    private void strongAttack(Character opponent) {
        opponent.hit(strength/2);
        this.stamina -= DEFAULT_WASTE;
    }

    @Override
    public boolean isAlive() {
        return stamina > 0;
    }

    @Override
    public void throwAttack(Character opponent) {
        if (stamina > 5 ) {
            strongAttack(opponent);
        } else {
            weakAttack(opponent);
        }
    }

    @Override
    public void hit(Long points) {
        this.stamina -= points;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getStamina() {
        return stamina;
    }

    public void setStamina(Long stamina) {
        this.stamina = stamina;
    }
}
