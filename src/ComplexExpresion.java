import java.util.List;

public abstract class ComplexExpresion {
    private Operation operation;
    private List<Complex> args;

    public ComplexExpresion(Operation operation, List<Complex> args) {
        this.operation = operation;
        this.args = args;
    }

    protected abstract Complex executeOneOperation(Complex a, Complex b);

    public Complex execute(){
        Complex a = args.get(0);
        Complex b = args.get(1);
        a = executeOneOperation(a, b);
        int i;
        for(i = 2; i< args.size(); i++){
            b = args.get(i);
            a = executeOneOperation(a, b);
        }
        return a;
    }
}
