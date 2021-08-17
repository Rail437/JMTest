public class Operator {
    private String[] operators = {"+","-","*","/"};

    public Operator() {
    }

    public boolean toCheck(String str){
        for (int i = 0; i < operators.length; i++) {
            if(str.equals(operators[i])){
                return true;
            }
        }
        return false;
    }
}

