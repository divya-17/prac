package stacks;
/*
Implement 2 stacks (push and pop operations) using one array.

https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
public class ImplementStackUsingArray {

    private static int[] arr = new int[30];
    private static int p1 = 0;
    private static int p2 = arr.length-1;

    public static void main(String[] args) {


        ImplementStackUsingArray obj = new ImplementStackUsingArray();
        obj.push("s1",3);
        System.out.println("Pushed to s1 "+3);
        obj.push("s2",4);
        System.out.println("Pushed to s2 "+4);
        obj.push("s1",10);
        System.out.println("Pushed to s1 "+10);
        obj.push("s1",7);
        System.out.println("Pushed to s1 "+7);
        Integer elem1 = obj.pop("s1");
        System.out.println("Popped from s1 =>"+elem1);
        Integer elem2 = obj.pop("s1");
        System.out.println("Popped from s1 =>"+elem2);
        Integer elem3 = obj.pop("s2");
        System.out.println("Popped from s2 =>"+elem3);
        Integer elem4 = obj.pop("s2");
        System.out.println("Popped from s2 =>"+elem4);

    }

    public void push(String stack,Integer elem){

        if(p1 < p2) {
            if (stack.equals("s1")) {
                arr[p1] = elem;
                p1++;
            }
            if (stack.equals("s2")) {
                arr[p2] = elem;
                p2--;
            }
        }else {
            throw new RuntimeException("Stack full exception !!");
        }
    }

    public Integer pop(String stack){

        if(stack.equals("s1")){
            if(p1 > 0) {
                p1--;
                return arr[p1];
            }
        }
        if(stack.equals("s2")){

            if(p2 < arr.length-1){
                p2++;
                return arr[p2];
            }
        }
        return null;
    }
}
