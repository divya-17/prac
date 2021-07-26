import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {


    public static void main(String[] args) throws ParseException {

        boolean [][] testBoolean = new boolean[2][2];

        for(int i=0; i < 2; i++){
            for(int j=0; j<2; j++){
                System.out.print(testBoolean[i][j]+",");
            }
            System.out.println();
        }

    }
}