package binarySearch;

public class NextAlphabeticalElem {

    public static void main(String[] args) {

        char[] chArr = new char[] {'a', 'c', 'f','h'};
        char searchChar = 'f';

        char nextChar = getNextCharForSearchChar(chArr,searchChar);

        System.out.println("Next character to char "+searchChar+" is "+nextChar);
    }

    private static char getNextCharForSearchChar(char[] chArr, char searchChar) {

        int [] asciiValue = new int[chArr.length];

        int elemToSearch = (int) searchChar;

        for(int i =0; i < chArr.length; i++){
            int intValue = (int) chArr[i];
            asciiValue[i] = intValue;
        }

        int strtIndex = 0;
        int endIndex = asciiValue.length-1;

        while (strtIndex <= endIndex){

            int midIndex = strtIndex + (endIndex-strtIndex)/2;

            if(asciiValue[midIndex] == elemToSearch && midIndex+1 <= endIndex){
                return (char) (asciiValue[midIndex+1]);
            }
            else if (asciiValue [midIndex] < elemToSearch){
                    strtIndex = midIndex+1;
                }

            else if(asciiValue[midIndex] > elemToSearch){
                endIndex = midIndex-1;
            }
        }
        return (char) -1;
    }
}
