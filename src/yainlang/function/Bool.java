package yainlang.function;

public class Bool {
    public boolean isBiggerThan(int a, int b) {
        return a > b;
    }
    public boolean isSmallerThan(int a, int b) {
        return a < b;
    }
    public boolean isEqual(int a, int b) {
        return a == b;
    }
    public boolean isEqual(String a, String b) {
        return a.equals(b);
    }
    public boolean getBool(String s){
        return Boolean.parseBoolean(s);
    }
}
