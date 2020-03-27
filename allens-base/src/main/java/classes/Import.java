package classes;

import org.apache.commons.collections4.collection.SynchronizedCollection;
import some.TestFather;

import java.util.HashSet;

public class Import extends TestFather {

    public static void main(String[] args) {
        Import im = new Import();
        System.out.println(im.a);
        HashSet hashSet = new HashSet();
        SynchronizedCollection.synchronizedCollection(hashSet);
    }

}
