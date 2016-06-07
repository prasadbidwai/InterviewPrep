// A Simple Java program to show working of user defined
// Generic classes
  
// We use < > to specify Parameter type
class Test<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}
  
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());
  
        // instance of String type
        Test <String> sObj =
                          new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
    }
}

/*
Output:

15
GeeksForGeeks

*/


//We can also pass multiple Type parameters in Generic classes.

// A Simple Java program to show multiple
// type parameters in Java Generics
 
// We use < > to specify Parameter type
class Test<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U
 
    // constructor
    Test(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
 
    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
 
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        Test <String, Integer> obj =
            new Test<String, Integer>("GfG", 15);
 
        obj.print();
    }
}


/*
Output:

15
GeeksForGeeks
*/