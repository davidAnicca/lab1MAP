import java.util.List;

public class AdditionExpression extends ComplexExpression {
    public AdditionExpression(Operation operation, List<Complex> args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex a, Complex b) {
        return a.addition(b);
    }
}
