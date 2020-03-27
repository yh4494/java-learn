package classes;

import Other.Father;

public class Son extends Father {

//    public Son() {
//        this.some = true;
//    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        son.some = true;
        System.out.println(son.some);;
    }

}
