import java.util.ArrayList;
import java.util.List;

public class ExpressionFactory {
    /*Singletone class*/
    private static ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory() {

    }

    public static ExpressionFactory getInstance() {
        return instance;
    }

    public ComplexExpression createExpression(Operation operation, Complex[] args) {
        List<Complex> numbers = new ArrayList<>();
        for (Complex c : args) numbers.add(c);
        if (operation == Operation.MULTIPLICATION)
            return new MultiplicationExpression(operation, numbers);
        if (operation == Operation.ADDITION)
            return new AdditionExpression(operation, numbers);
        if (operation == Operation.DIVISION)
            return new DivisionExpression(operation, numbers);
        if (operation == Operation.SUBSTRACTION)
            return new SubstractionExpression(operation, numbers);
        return null;
    }
}
