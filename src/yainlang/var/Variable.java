package yainlang.var;

public class Variable<T> {
    private T value;
    private String name;
    public Variable(String name, T value) {
        this.name = name;
        this.value = value;

    }
    public T get() {
        return value;
    }
    public String getName() {
        return name;
    }
    public boolean check(String name) {
        return this.name.equals(name);
    }
    public void set(T value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable) {
            Variable<?> variable = (Variable<?>) obj;
            return name.equals(variable.getName());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + name + " :" + value + ")";
    }
}
