package OOPsConcepts.multilevelInheritance;

public class Test {

   public static void main(String[] args) {

      A objA =new A();
      objA.printA();

      B objB = new B();
      objB.printA();
      objB.printB();


      C objC = new C();
      objC.printA();
      objC.printB();
      objC.printC();
   }
}
class A{
   public void printA(){
      System.out.println("Calling class A");
   }
}
class B extends A{
   public void printB(){
      System.out.println("Calling class B");
   }
}
class C extends B{

//   public void printA(){
//      System.out.println("Calling class A from C");
//   }
   public void printC(){
      System.out.println("Calling class C");
   }
}
