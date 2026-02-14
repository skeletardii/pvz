package Entities.Interfaces;

public interface Attacker {
  final int ATTACK_COOLDOWN = 10;
  final int ATTACK_RATE = 100;

  public abstract void attack();

  public abstract void shoot();
}
