// Клиент (кинотеатра)
class Client 
{
    // ФИО и возраст клиента
    private String fio;
    private int age;
    
    // Конструктор
    public Client(String fio, int age)
    {
        setFio(fio);
        setAge(age);
    }

    public void setFio(String fio) { this.fio = fio; }
    
    public String getFio() { return fio; }
    
    public void setAge(int age) throws IllegalArgumentException
    {
        if (age < 0 || age > 150) throw new IllegalArgumentException("Неккоректное значение возраста :(");
        else this.age = age;
    }
    
    public int getAge() { return age; }
}

// Фильм (в кинотеатре)
class Film
{
    // Название фильма и ограничение по возрасту
    private String name;
    private int frs;
    
    // Конструктор
    public Film(String name, int frs)
    {
        setName(name);
        setFrs(frs);
    }

    public void setName(String name) { this.name = name; }
    
    public String getName() { return name; }
    
    public void setFrs(int frs) throws IllegalArgumentException
    {
        if (frs < 0 || frs > 21) throw new IllegalArgumentException("Неккоректное значение возрастного ограничения :(");
        else this.frs = frs;
    }
    
    public int getFrs() { return frs; }
}

interface ICinema
{
    public void Access(Client client, Film film);
}

class RealCinema implements ICinema
{
    @Override
    public void Access(Client client, Film film)
    {
        System.out.printf("Клиент %s успешно купил билет на фильм \"%s\"\n", client.getFio(), film.getName());
    }
}

class SecureCinemaProxy implements ICinema
{
    private final ICinema cinema;
    
    public SecureCinemaProxy(ICinema cinema) 
    {
        this.cinema = cinema;
    }
    
    @Override
    public void Access(Client client, Film film) 
    {
        if (client.getAge() < film.getFrs()) System.out.printf("Клиент %s не может купить билет на фильм \"%s\" в силу возрастного ограничения\n", client.getFio(), film.getName());
        else cinema.Access(client, film);
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    Client client = new Client("Иванов Иван Иванович", 16);
	    
	    Film film1 = new Film("Три богатыря. Часть 10", 6);
	    Film film2 = new Film("Пила. Часть 10", 18);
	    
	    SecureCinemaProxy cinema = new SecureCinemaProxy(new RealCinema());
	    
	    cinema.Access(client, film1);
	    cinema.Access(client, film2);
	    
	    /* Пример работы программы:
	    
	    Клиент Иванов Иван Иванович успешно купил билет на фильм "Три богатыря. Часть 10"
	    Клиент Иванов Иван Иванович не может купить билет на фильм "Пила. Часть 10" в силу возрастного ограничения */
	}
}