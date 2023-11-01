package yainlang.var;

import java.util.ArrayList;

public class Memory {
    ArrayList<Variable<?>> variables = new ArrayList<>();
    private void put(Variable<?> variable) {
        duplicateCheck(true, variable);
        variables.add(variable);
    }
    private void remove(Variable<?> variable) {
        variables.remove(variable);
    }
    public void remove(String name) {
        remove(get(name));
    }
    private void duplicateCheck(boolean temp , Variable<?> variable){
         System.out.println(variables+" , "+ variables.contains(variable));
        if(temp == variables.contains(variable)){
            System.out.println(variables+" , "+ variables.contains(variable));
            throw new RuntimeException(temp ? "이미 존재하는 변수입니다." : "존재하지 않는 변수입니다.");
        }
    }
    public Variable<?> get(String name) {
        for (Variable<?> variable : variables) {
            if (variable.check(name)) return variable;
        }
        throw new RuntimeException("존재하지 않는 변수입니다.");
    }
    public void set(String name, String value) {
        Variable<String> variable = new Variable<String>(name, value);
        duplicateCheck(true, variable);
        put(variable);
    }
    public void set(String name, int value) {
     Variable<Integer> variable = new Variable<Integer>(name, value);
        duplicateCheck(true, variable);
        put(variable);
    }
    public void set(String name, boolean value) {
     Variable<Boolean> variable = new Variable<Boolean>(name, value);
        duplicateCheck(true, variable);
        put(variable);
    }
    public String toString() {
        return variables.toString();
    }
}

