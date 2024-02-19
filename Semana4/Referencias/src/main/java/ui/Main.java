package ui;

import model.Value;

public class Main {
    public static void main(String[] args) {
        Value v1 = new Value();
        System.out.println(v1);
        v1.setValue(7);
        System.out.println(v1.getValue());

        Value v2 = v1;
        System.out.println(v2);
        System.out.println(v2.getValue());

        System.out.println("*************************************");
        v2.setValue(5);
        System.out.println(v2.getValue());
        System.out.println(v1.getValue());

        System.out.println("*************************************");
        Value v3 = new Value();
        System.out.println(v3);
        v3.setValue(9);
        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
        System.out.println(v3.getValue());

        System.out.println("*************************************");
        Value v4 = null;
        v1 = v4;

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);


        System.out.println("*************************************");
        v4 = v3;

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println("*************************************");
        System.out.println(v3 == v4);

        v2.setValue(5);
        v3.setValue(5);

        System.out.println(v2 == v3);
        System.out.println(v2.equals(v3));

        System.out.println("*************************************");
        v1 = v2.clone();
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v1 == v2);

        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
        System.out.println(v1.equals(v2));

    }
}
