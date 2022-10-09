import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;

public class ExpressionParser {
    String[] args;
    Operation operation;

    public ExpressionParser(String[] args) {
        this.args = args;
        //test();
    }

    private void test() {
        Complex[] numbers = new Complex[3];
        numbers[0] = (new Complex(2, 3));
        numbers[1] = (new Complex(5, -4));
        numbers[2] = (new Complex(-1, 8));
        ExpressionFactory expressionFactory = ExpressionFactory.getInstance();
        ComplexExpression exp = expressionFactory.createExpression(Operation.SUBSTRACTION, numbers);
        Complex result2 = exp.execute();
        System.out.println(result2.getRe());
        System.out.println(result2.getIm());

        System.out.println(validateComplex("a"));
        System.out.println(validateComplex("4+3*i"));
        System.out.println(validateComplex("42-23*i"));
    }

    private boolean valid() {
        if (args.length % 2 == 0)
            return false;

        String op = "";
        if (args.length > 1)
            op = args[1];
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 1 && !Objects.equals(args[i], op)) {
                return false;
            }
            if (i % 2 == 0 && !validateComplex(args[i]))
                return false;
        }
        return true;
    }

    private boolean validateComplex(String arg) {
        int offset = 0;
        if (Objects.equals(arg.charAt(0), '-')) offset = 1;
        String[] splitet = arg.split("[*+-/]");
        if (splitet.length != offset + 3)
            return false;
        splitet[offset + 0] = splitet[offset + 0].replaceAll("[^0-9]", "");
        splitet[offset + 1] = splitet[offset + 1].replaceAll("[^0-9]", "");
        if (Objects.equals(splitet[offset + 0], "") || splitet[offset + 1].equals(""))
            return false;
        return true;
    }

    private void selectOperation() {
        if (Objects.equals(args[1], "+")) operation = Operation.ADDITION;
        if (Objects.equals(args[1], "x")) operation = Operation.MULTIPLICATION;
        if (Objects.equals(args[1], "/")) operation = Operation.DIVISION;
        if (Objects.equals(args[1], "-")) operation = Operation.SUBSTRACTION;
    }

    private Complex stringToComplex(String strComplex){
        int offset = 0;
        if (strComplex.charAt(0) == '-') offset = 1;
        String[] splitet = strComplex.split("[*+-/]");
        String re = splitet[offset + 0];
        String im = splitet[offset + 1];
        int sgn = 1;
        if (offset == 1) sgn = -1;
        return  new Complex(sgn * Double.parseDouble(re), Double.parseDouble(im));
    }

    private Complex[] parse() {
        Complex[] numbers = new Complex[args.length / 2 + 1];
        int j = 0;
        for (int i = 0; i < args.length; i += 2) {
            String arg = args[i];
            numbers[j] = stringToComplex(arg);
            j++;
        }
        return numbers;
    }

    public Complex result() throws Exception {
        if (!valid()) {
            throw new Exception("expresie invalidă la argumente");
        }
        if (args.length == 1){
            if(!validateComplex(args[0])){
                throw new Exception("expresie invalidă la argumente");
            }else{
                return stringToComplex(args[0]);
            }
        }
        selectOperation();
        ExpressionFactory expressionFactory = ExpressionFactory.getInstance();
        return expressionFactory.createExpression(operation, parse()).execute();
    }
}
