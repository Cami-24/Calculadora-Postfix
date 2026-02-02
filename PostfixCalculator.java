public class PostfixCalculator {

    public int evaluate(String expression) {

        IStack<Integer> stack = new VectorStack<Integer>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {

                if (stack.size() < 2) {
                    throw new RuntimeException("Operandos insuficientes");
                }

                int b = stack.pop();
                int a = stack.pop();
                int result;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("División entre cero");
                        }
                        result = a / b;
                        break;
                    case "%":
                        result = a % b;
                        break;
                    default:
                        throw new RuntimeException("Operador inválido: " + token);
                }

                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Expresión postfix inválida");
        }

        return stack.pop();
    }
}

