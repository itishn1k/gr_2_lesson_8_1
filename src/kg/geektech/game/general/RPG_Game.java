package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(2500, 70, "Thanos");
        Warrior warrior = new Warrior(280, 20, "Nurbol");
        Medic doc = new Medic(250, 5, 15, "Kayrat");
        Magic magic = new Magic(275, 15, 10, "Ilyas");
        Berserk berserk = new Berserk(280, 15, "Aziz");
        Medic assistant = new Medic(280, 10, 5, "Abdulaziz");
        Hacker hacker = new Hacker(240, 20, "Indus");
        Thor thor = new Thor(300, 20, "JaneFoster");
        Uchiha uchiha = new Uchiha(200, 15, "Itachi");
        Hero[] heroes = {uchiha, warrior, doc, magic, berserk, assistant, hacker, thor};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getAbility() != boss.getDefence()
                    && hero.getHealth() > 0) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\n"+"ROUND " + roundNumber + " --------------------------------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        System.out.println();
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
