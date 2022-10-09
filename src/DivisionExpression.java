import java.util.List;

public class DivisionExpression extends ComplexExpression {
    public DivisionExpression(Operation operation, List<Complex> args) {
        super(operation, args);
    }

    @Override
    protected Complex executeOneOperation(Complex a, Complex b) {
        return a.division(b);
    }
}
