import java.util.List;

public class MultiplicationExpression extends ComplexExpression {
    public MultiplicationExpression(Operation operation, List<Complex> args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex a, Complex b) {
        return a.multiplication(b);
    }
}
