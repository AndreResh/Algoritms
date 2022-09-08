package alg;


import java.util.Calendar;
import java.util.Collection;

public class Counting {
    public static void main(String[] args) {
        A a = new A(1);
        System.out.println(a instanceof Drawing);
    }
}
interface Drawing {
}

class A {
    int a;

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) throws RuntimeException{
        this.a = a;
    }
}