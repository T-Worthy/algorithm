package OFFER.TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TEST {

    public static void main(String[] args) throws Exception {
        List<Integer> list= new ArrayList<>();
        Collections.reverse(list);

        Integer [] i = list.toArray(new Integer[10]);
    }

}
