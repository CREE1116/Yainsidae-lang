package yainlang.test;

import yainlang.var.Memory;

public class memoryTest {
    Memory memory = new Memory();
    public void testMethod() {
    // memory.set("test1", false);
    // System.out.println(memory);
    // memory.set("test2", 2);
    // System.out.println(memory);
    memory.set("test3", "for test");
    // System.out.println(memory);
    memory.set("test3", "for test it must be error");
    }
   public static void main(String[]args){
    memoryTest test = new memoryTest();
    test.testMethod();
   }
}
