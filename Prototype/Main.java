import java.util.ArrayList;
import java.util.Random;

abstract class Monster
{
    // Параметры монстра
    public int Hp, Atk;
    public double Speed;
    public String Name;
    
    public Monster() {}

    public Monster(Monster monster)
    {
        if (monster != null)
        {
            this.Hp = monster.Hp;
            this.Atk = monster.Atk;
            this.Speed = monster.Speed;
            this.Name = monster.Name;
        }
    }
    
    // Переопределение метода toString()
    @Override
    public String toString()
    {
        String res = "";
        
        res += "Name: " + Name + "\n";
        res += "Hp: " + Hp + "\n";
        res += "Atk: " + Atk + "\n";
        res += "Speed: " + Speed + "\n";
        
        return res;
    }
    
    public abstract Monster clone();
}

class Zombie extends Monster 
{
    public Zombie(int hp, int atk, double speed, String name) 
    {
        Hp = hp;
        Atk = atk;
        Speed = speed;
        Name = name;
    }
    
    public Zombie(Zombie zombie)
    {
        super(zombie);
    }
    
    @Override
    public Monster clone()
    {
        return new Zombie(this);
    }
}

class Skeleton extends Monster
{
    public Skeleton(int hp, int atk, double speed, String name) 
    {
        Hp = hp;
        Atk = atk;
        Speed = speed;
        Name = name;
    }
    
    public Skeleton(Skeleton skeleton)
    {
        super(skeleton);
    }
    
    @Override
    public Monster clone()
    {
        return new Skeleton(this);
    }
}

class Spawner 
{
    private ArrayList<Monster> defaultMobs = new ArrayList<>();
    
    public Spawner()
    {
        Zombie zombie = new Zombie(20, 2, 1, "Zombie");
        Zombie babyZombie = new Zombie(10, 3, 1.5, "BabyZombie");
        Zombie armoredZombie = new Zombie(30, 3, 0.8, "ArmoredZombie");
        Zombie armoredBabyZombie = new Zombie(15, 5, 1.3, "ArmoredBabyZombie");
        
        Skeleton skeleton = new Skeleton(15, 2, 1.5, "Skeleton");
        Skeleton armoredSkeleton = new Skeleton(25, 4, 1.3, "ArmoredSkeleton");
        
        defaultMobs.add(zombie);
        defaultMobs.add(babyZombie);
        defaultMobs.add(armoredZombie);
        defaultMobs.add(armoredBabyZombie);
        
        defaultMobs.add(skeleton);
        defaultMobs.add(armoredSkeleton);
    }
    
    public Monster GetNewMob() throws ArrayIndexOutOfBoundsException
    {
        Random random = new Random();
        int i = random.nextInt(defaultMobs.size() + 1);
  
        if (i < 0 || i >= defaultMobs.size()) throw new ArrayIndexOutOfBoundsException("Случайно сгенерированное число вышло за пределы массива :(");
        else return defaultMobs.get(i);
    }
}

public class Main
{
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException
	{
	    // Создание стандартных врагов
	    Spawner spawner = new Spawner();
		
	    System.out.println("Внимание! Появился новый монстр:");
	    System.out.println(spawner.GetNewMob().toString());
		
		/* Пример работы программы
	
	    Внимание! Появился новый монстр:
        Name: ArmoredSkeleton
        Hp: 25
        Atk: 4
        Speed: 1.3  
        
        Внимание! Появился новый монстр:
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Случайно сгенерированное число вышло за преде�ы массива :(
        at Spawner.GetNewMob(Main.java:113)
        at Main.main(Main.java:126)            */
	}
}