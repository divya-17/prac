package tree.trieDS;

public class TrieTreeImpl {

    public static void main(String[] args) {

        TrieTree trieTree = new TrieTree();

        // Insertion
        trieTree.insert("divya");
        trieTree.insert("divansh");
        trieTree.insert("d");

        //Search
        String strToSearch = "diva";
        String strToSearch1 = "divya";
        String strToSearch2 = "d";

        System.out.println("String "+strToSearch+" found => "+trieTree.search(strToSearch));
        System.out.println("String "+strToSearch1+" found => "+trieTree.search(strToSearch1));
        System.out.println("String "+strToSearch2+" found =>"+trieTree.search(strToSearch2));


        //Deletion -> Just update the word end flag if wordi is found or else return false


        Boolean deleted = trieTree.delete("divya");
        System.out.println("Deleted => "+deleted);

        Boolean found = trieTree.search("divya");
        System.out.println("Found => "+found);

        Boolean deleted1 = trieTree.delete("dipesh");
        System.out.println("Deleted =>"+deleted1);
    }

}
