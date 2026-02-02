public class PostfixCalculator {

    private IStack<Integer> stack;

    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }

    public int evaluate(String expression) {

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            // Si es número
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            }
            // Si es operador
            else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Operandos insuficientes");
                }

                int b = stack.pop();
                int a = stack.pop();

                if (token.equals("+")) {
                    stack.push(a + b);
                } 
                else if (token.equals("-")) {
                    stack.push(a - b);
                } 
                else if (token.equals("*")) {
                    stack.push(a * b);
                } 
                else if (token.equals("/")) {
                    if (b == 0) {
                        throw new ArithmeticException("División entre cero");
                    }
                    stack.push(a / b);
                } 
                else if (token.equals("%")) {
                    if (b == 0) {
                        throw new ArithmeticException("Módulo entre cero");
                    }
                    stack.push(a % b);
                } 
                else {
                    throw new RuntimeException("Operador inválido");
                }
            }
        }

        return stack.pop();
    }
}
