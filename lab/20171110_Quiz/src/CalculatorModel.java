public class CalculatorModel {
    // logic

    private double num1;
    private double num2;
    private String op;

    public void setNum2(double n){
        num2 = n;
    }

    public CalculatorModel(){
        num1 = 0;
        num2 = 0;
        op = "+";
    }

    public void clear(){
        num1=0;
        num2=0;
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
            num1/=num2;
        }

        op = operator;
        return  num1;
    }
}
