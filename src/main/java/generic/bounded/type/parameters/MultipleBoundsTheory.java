package generic.bounded.type.parameters;

public class MultipleBoundsTheory {
}

class A{}

interface B{}

interface C{}

class D <T extends A & B & C>{}

//this will give error as class should be first, if one of the bounds is a class
//class E <T extends  B & A & C>{}
