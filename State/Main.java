interface OperationState
{
    public int calc(int a, int b) throws ArithmeticException;
}

class Sum implements OperationState
{
    @Override 
    public int calc(int a, int b) throws ArithmeticException { return a + b; }
}

class Subtraction implements OperationState 
{
    @Override 
    public int calc(int a, int b) throws ArithmeticException { return a - b; }
}

class Multiplication implements OperationState
{
    @Override 
    public int calc(int a, int b) throws ArithmeticException { return a * b; }
}

class Division implements OperationState
{
    @Override 
    public int calc(int a, int b) throws ArithmeticException
    {
        if (b == 0) throw new ArithmeticException("На ноль делить нельзя!");
        else return a / b;
    }
}

class Operation
{
    private OperationState state;
    
    public Operation(OperationState state)
    {
        setState(state);
    }
    
    public void setState(OperationState state)
    {
        this.state = state;
    }
    
    public int operationResult(int a, int b)
    {
        return state.calc(a, b);
    }
}

public class Main
{
	public static void main(String[] args) throws ArithmeticException
	{
	    Operation op = new Operation(new Sum());
	    
	    System.out.printf("%d + %d = %d\n", 5, 5, op.operationResult(5, 5));
	    
	    op.setState(new Subtraction());
	    
	    System.out.printf("%d - %d = %d\n", 5, 5, op.operationResult(5, 5));
	    
	    op.setState(new Multiplication());
	    
	    System.out.printf("%d * %d = %d\n", 5, 5, op.operationResult(5, 5));
	    
	    op.setState(new Division());
	    
	    System.out.printf("%d / %d = %d\n", 5, 5, op.operationResult(5, 5));
	    System.out.printf("%d / %d = %d\n", 5, 5, op.operationResult(5, 0));
	    
	    /* Результат выполнения программы
	    
	    5 + 5 = 10
            5 - 5 = 0
            5 * 5 = 25 
            5 / 5 = 1 
        
            Exception in thread "main" java.lang.ArithmeticException: На ноль делить нельзя!
            at Division.calc(Main.java:29)
            at Operation.operationResult(Main.java:50)
            at Main.main(Main.java:73)                      */
	}
}
