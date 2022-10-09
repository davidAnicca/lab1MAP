import java.util.List;

public class SubstractionExpression extends ComplexExpression {

    public SubstractionExpression(Operation operation, List<Complex> args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex a, Complex b) {
        return a.substraction(b);
    }
}
