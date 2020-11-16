package basicTextGame;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Game variables
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Player
        int health = 100;
        int attackDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // percentange

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME: 
        while (running) {
            System.out.println("_____________________________________________");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " apeared! #\n");

            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " in retaliation!");

                    if(health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to continue!");
                        break;
                    }
                } else if (input.equals("2")){
                    if(numHealthPots > 0) {
                        health += healthPotionHealAmount;
                        numHealthPots--;
                        System.out.println(
                                "\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "." 
                                + "\n\t> You have now " + health + " HP."
                                + "\n\t> You have " + numHealthPots + " health potions left.\n");
                    } else {
                        System.out.println("You have no health potions left! Defeat enemies for a chance to reveive one");
                    }

                } else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("Invalid command!");
                }
            }

            if(health < 1) {
                System.out.println("You limp out of the dungeon, weak from the battle.");
                break;
            }

            System.out.println("_____________________________________________");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPots++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numHealthPots + " health potion(s). #");
            }
            System.out.println("_____________________________________________");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit the dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if(input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }

        System.out.println("\n###################");
        System.out.println("Thanks for playing!");
        System.out.println("###################");
    }
}
