package jia.tutorial.rxjava.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DynamicInvokeTester<T> {

    private T value;

    public DynamicInvokeTester(T value) {
        this.value = value;
    }

    /**
     * Consumer is the interface or method has signature [(Object v): void]
     * @param consumer
     */
    public void consume(Consumer<? super T> consumer){
        consumer.accept(value);
    }

    /**
     * Supplier is the interface or method has signature [(): Object]
     * @param supplier
     * @return
     */
    public T supply(Supplier<? extends T> supplier) {
        return supplier.get();
    }

    /**
     * Function is the interface or method has signature [(Object v) : Object]
     * @param func
     * @param <U>
     * @return
     */
    public <U> U invoke(Function<? super T, ? extends U> func) {
        return func.apply(value);
    }

    /**
     * Runnable is the interface or method has signature [(): void]
     * @param runnable
     */
    public void run(Runnable runnable) {
        runnable.run();
    }


    public <U> void printGeneric(U v) {
        System.out.println(v);
    }

    public void printString(String s) {
        System.out.println(s);
    }

    public String newString() {
        return "New String";
    }

    public String convert(String s) {
        return s.replace("l", "X");
    }

    public void execute(){
        System.out.println("execute");
    }

    public static void main(String args[]) {
        DynamicInvokeTester<String> tester = new DynamicInvokeTester("Hello World");
        tester.consume(System.out::println);
        tester.consume(tester::printGeneric);
        tester.consume(tester::printString);

        System.out.println(tester.supply(()->new String("Hello")));
        System.out.println(tester.supply(String::new));
        System.out.println(tester.supply(tester::newString));

        System.out.println((String)tester.invoke(s->s.toUpperCase()));
        System.out.println(tester.invoke(tester::convert));

        tester.run(()->System.out.println("Hello run"));
        tester.run(tester::execute);
    }
}
