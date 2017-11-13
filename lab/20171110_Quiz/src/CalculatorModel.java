public class CalculatorModel {
    // logic

    private double num1;
    private double num2;
    private String op;

    public void setNum2(double n){
        num2 = n;
    }

    public CalculatorModel(){
        this.clear();
    }

    public void clear(){
        num1=0;
        num2=0;
        op = "+";
    }

    public double calculate(String operator){
        if(operator.isEmpty())
            return num1;

        if(op.equals("+")){
            num1+=num2;
        }
        else if(op.equals("-")) {
            num1-=num2;
        }
        else if(op.equals("*")) {
            num1*=num2;
        }
        else if(op.equals("/")) {
            if(num2 != 0)
                num1/=num2;
        }
        else if(op.equals("^2")){
            num1 = Math.pow(num2,2);
        }
        else if(op.equals("log")) {
            num1 = Math.log(num2);
        }
        else if(op.equals("sin")){
            num1 = Math.sin(num2);
        }
        else if(op.equals("cos")) {
            num1 = Math.cos(num2);
        }

        op = operator;
        return  num1;
    }
}
