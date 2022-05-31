package StringQues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        Map<Character,Integer> map = new HashMap();
        Queue<Character> q = new LinkedList();
        String str = "";
        String A = "aabc";

        for(int i=0;i<A.length();i++)
        {

            if(!map.containsKey(A.charAt(i))){
                map.put(A.charAt(i),1);
            }
            else{
                map.put(A.charAt(i),map.get(A.charAt(i))+1);
            }

            if(map.get(A.charAt(i))==1)
                q.add(A.charAt(i));
            while(!q.isEmpty() && map.get(q.peek())>1)
                q.poll();
            if(q.isEmpty()){
                str+='#';
            }

            else{
                str+=q.peek();

            }

        }

        System.out.println(str);
    }
}
