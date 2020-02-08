package wildcards.guidelines;

import java.util.ArrayList;
import java.util.List;

class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
}

public class GuideLinesRunner {
    public static void main(String[] args) {
        List<EvenNumber> evenNumberList = new ArrayList<>();
        evenNumberList.add(new EvenNumber(1));
        List<? extends NaturalNumber> naturalNumberList = evenNumberList;


        //compile time error
//        naturalNumberList.add(new EvenNumber(1));
//        naturalNumberList.add(new NaturalNumber(1));
        /*
        Because List<EvenNumber> is a subtype of List<? extends NaturalNumber>, you can assign le to ln. But you cannot use ln to add a natural number to a list of even numbers. The following operations on the list are possible:

            You can add null.
            You can invoke clear.
            You can get the iterator and invoke remove.
            You can capture the wildcard and write elements that you've read from the list.

           You can see that the list defined by List<? extends NaturalNumber> is not read-only in the strictest sense of the word, but you might think of it that way because you cannot store a new element or change an existing element in the list.
         */
    }
}
