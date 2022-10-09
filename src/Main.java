public class Main {
    public static void main(String[] args) {
        try {
            ExpressionParser expressionParser = new ExpressionParser(args);
            Complex e = expressionParser.result();
            System.out.println((int)e.getRe() + "+(" + (int)e.getIm() + "i)");
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }
}