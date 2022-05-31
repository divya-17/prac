public class CharTest {

    public static void main(String[] args) {

        String chStr = "12";

        Character ch = '6';
        Integer chVal = Integer.parseInt(chStr);
        System.out.println(chVal);

        System.out.println(ch-'0');

        // Way to convert number 12 to character-> 'l'
        System.out.println((char)('a'+12-1));
    }
}
