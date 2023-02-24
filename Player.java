import java.util.Enumeration;
import java.util.Hashtable;

// Кастомизация персонажа
class Skin implements Cloneable
{
    // Цвет прически и глаз
    public String HairColor, EyesColor;
    
    // Цвет верхней одежды, штанов и обуви
    public String OuterwearColor, PantsColor, BootsColor;
    
   // Конструктор
   Skin (String hairColor, String eyesColor, 
         String outerwearColor, String pantsColor, String bootsColor)
    {
        HairColor = hairColor;
        EyesColor = eyesColor;
        OuterwearColor = outerwearColor;
        PantsColor = pantsColor;
        BootsColor = bootsColor;
    }
    
    // Переопределение метода toString()
    @Override
    public String toString()
    {
        String res = "";
        
        res += "HairColor: " + HairColor + "\n";
        res += "EyesColor: " + EyesColor + "\n";
        res += "OuterwearColor: " + OuterwearColor + "\n";
        res += "PantsColor: " + PantsColor + "\n";
        res += "BootsColor: " + BootsColor + "\n";
        
        return res;
    }
    
    // Переопределение метода clone()
    @Override
    public Skin clone() throws CloneNotSupportedException 
    { 
        return (Skin) super.clone(); 
    } 
}

// Хранилище прототипов - стандартные скины
class DefaultSkins
{
    private Hashtable<String, Skin> defaultSkins;
    
    DefaultSkins ()
    {
        defaultSkins = new Hashtable<>();
    }
    
    public void AddSkin(String name, Skin skin)
    {
        defaultSkins.put(name, skin);
    }
    
    public Skin GetByName (String name) throws CloneNotSupportedException 
    {
        // Убираем clone() => возвращаем ссылку на объект из хэш-таблицы
        return defaultSkins.get(name).clone();
    }
}

// Сам персонаж
class Player
{
    public String Name;
    public Skin PlayerSkin;
    
    Player (String name, Skin playerSkin)
    {
        Name = name;
        PlayerSkin = playerSkin;
    }
}

public class Main
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
	    // Создание стандартных скинов
		DefaultSkins defaultSkins = new DefaultSkins();
		defaultSkins.AddSkin("Skin1", new Skin("Purple", "Purple", "Purple", "Black", "White"));
		
		// Новый игрок (взял стандартный скин)
		Player player = new Player("BestPlayer", defaultSkins.GetByName("Skin1"));

        // Теперь он хочет настроить его под себя
        player.PlayerSkin.HairColor = "Brown";
        player.PlayerSkin.EyesColor = "Green";
        player.PlayerSkin.OuterwearColor = "Blue";
        player.PlayerSkin.BootsColor = "Blue";
		
		// Выводим информацию о стандартном скине и о скине нового игрока
		System.out.printf("Skin1:\n%s\n", defaultSkins.GetByName("Skin1").toString());
		System.out.printf("PlayerSkin:\n%s\n", player.PlayerSkin.toString());
	}
}