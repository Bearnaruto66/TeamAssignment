package drinkgame;

import java.util.Random;

public class Person
{
    private String name;
    private int age;
    private int height;
    private int weight;
    private double balance;
    private int intoxication;
    private String drunkStatus;
    
    public Person(String name, int height, int weight)
    {
        Random randomBalance = new Random();
        
        this.name = name;
        this.height = height;
        this.weight = weight;
        
        //create random amount of money for player to spend (min $500 max $1k)
        balance = randomBalance.nextInt(101) * 5 + 500;
    }
    
    public void drinkDrink(int volume, int price)
    {
        //takes volume of alcohol and adds to current intoxication
        this.alcoholTolerance(volume);
        
        //sends price of drink to setBalance to subtract from current balance
        this.setBalance(price);
    }
    
    public void setDrunkStatus()
    {
        switch(intoxication)
        {
            case 1 : intoxication = 20; break;
            case 2 : intoxication = 40; break;
            case 3 : intoxication = 60; break;
            case 4 : intoxication = 80; break;
            case 5 : intoxication = 100; break;
            default : drunkStatus = "Sober";
        }
    }
    
    public String getDrunkStatus()
    {
        return drunkStatus;
    }
    
    public void setBalance(double price)
    {
        // value of price - negative value of price subtracts, positive value adds
        balance += price;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void alcoholTolerance(int volume)
    {
        intoxication += volume;
    }
           
    private enum Intoxication {SOBER,TIPSY,DRUNK,SHITFACED}
}
