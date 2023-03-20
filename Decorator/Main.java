import java.util.ArrayList;

interface Blini
{
    public String description();
    public int price();
}

class SimpleBlini implements Blini
{
    @Override 
    public String description()
    {
        return "Блины";
    }
    
    @Override
    public int price() 
    {
        return 50;
    }
}

abstract class Topping implements Blini
{
    protected Blini blini;
}

class StrawberryJam extends Topping
{
    public StrawberryJam(Blini blini)
    {
        this.blini = blini;
    }
    
    @Override
    public String description()
    {
        return this.blini.description() + " с клубничным вареньем";
    }
    
    @Override
    public int price()
    {
        return this.blini.price() + 25;
    }
}

class RaspberryJam extends Topping
{
    public RaspberryJam(Blini blini)
    {
        this.blini = blini;
    }
    
    @Override
    public String description()
    {
        return this.blini.description() + " с малиновым вареньем";
    }
    
    @Override
    public int price()
    {
        return this.blini.price() + 20;
    }
}

class Chocolate extends Topping
{
    public Chocolate(Blini blini)
    {
        this.blini = blini;
    }
    
    @Override
    public String description()
    {
        return this.blini.description() + " с шоколадом";
    }
    
    @Override
    public int price()
    {
        return this.blini.price() + 20;
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    Blini blini1 = new SimpleBlini();
	    
	    blini1 = new StrawberryJam(blini1);
	    blini1 = new Chocolate(blini1);
	    
	    System.out.printf("%s, %d руб\n", blini1.description(), blini1.price());
	    
	    Blini blini2 = new SimpleBlini();
	    
	    blini2 = new RaspberryJam(blini2);
	    blini2 = new Chocolate(blini2);
	    
	    System.out.printf("%s, %d руб\n", blini2.description(), blini2.price());
	    
	    /* Результат работы программы
	    
	    Блины с клубничным вареньем с шоколадом, 95 руб
        Блины с малиновым вареньем с шоколадом, 90 руб */
	}
}