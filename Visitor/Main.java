// Город
interface ICity
{
    public void accept(IVisitor visitor);
}

// Посетитель города
interface IVisitor
{
    public void visitMoscow(Moscow moscow);
    public void visitRome(Rome rome);
    public void visitParis(Paris paris);
}

class Moscow implements ICity 
{
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visitMoscow(this);
    }
}

class Rome implements ICity 
{
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visitRome(this);
    }
}

class Paris implements ICity 
{
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visitParis(this);
    }
}

class Food implements IVisitor
{
    @Override
    public void visitMoscow(Moscow moscow)
    {
        System.out.println("В Москве можно поесть борщ");
    }
    
    @Override
    public void visitRome(Rome rome)
    {
        System.out.println("В Риме можно поесть пиццу");
    }
    
    @Override
    public void visitParis(Paris paris)
    {
        System.out.println("В Париже можно поесть круассаны");
    }
}

class Sight implements IVisitor
{
    @Override
    public void visitMoscow(Moscow moscow)
    {
        System.out.println("В Москве есть Красная площадь");
    }
    
    @Override
    public void visitRome(Rome rome)
    {
        System.out.println("В Риме есть Колизей");
    }
    
    @Override
    public void visitParis(Paris paris)
    {
        System.out.println("В Париже есть Эйфелева башня");
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    Moscow moscow = new Moscow();
	    Rome rome = new Rome();
	    Paris paris = new Paris();
	    
	    Food food = new Food();
	    Sight sight = new Sight();
	    
	    food.visitMoscow(moscow);
	    sight.visitMoscow(moscow);
	    
	    food.visitRome(rome);
	    sight.visitRome(rome);
	    
	    food.visitParis(paris);
	    sight.visitParis(paris);
	    
	    /* Результат работы программы
	    
	    В Москве можно поесть борщ
        В Москве есть Красная площадь
        В Риме можно поесть пиццу
        В Риме есть Колизей
        В Париже можно поесть круассаны
        В Париже есть Эйфелева башня     */
	}
}