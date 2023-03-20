abstract class Dish
{
    public String name;
    abstract public void eat();
}

class Borsch extends Dish
{
    public Borsch()
    {
        this.name = "Борщ";
    }
    
    @Override 
    public void eat()
    {
        System.out.println("Очень сытный борщ, наполняет зарядом сил на весь день!");
    }
}

class Blini extends Dish
{
    public Blini()
    {
        this.name = "Блины";
    }
    
    @Override 
    public void eat()
    {
        System.out.println("Сладкие блины даже самого угрюмого заставят улыбнуться!");
    }
}

interface Chef
{
    public Dish cook();
}

class PotagerChef implements Chef 
{
    @Override
    public Dish cook() { return new Borsch(); }
}

class PastryChef implements Chef 
{
    @Override
    public Dish cook() { return new Blini(); }
}

public class Main
{
	public static void main(String[] args) 
	{
	    Chef Ivan = new PotagerChef();
	    Chef Olga = new PastryChef();
	    
	    Dish d1 = Ivan.cook(), d2 = Olga.cook();
	    
	    d1.eat();
	    d2.eat();
	    
	    /* Результат работы программы
	    
	    Очень сытный борщ, наполняет зарядом сил на весь день!
        Сладкие блины даже самого угрюмого заставят улыбнуться! */
	}
}