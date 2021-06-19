package tree.trieDS;

public class TrieTree {

    private TrieNode rootNode;

    public TrieTree(){

        rootNode = new TrieNode();
    }

    public TrieNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TrieNode rootNode) {
        this.rootNode = rootNode;
    }

    public void insert(String stringToStore){

        TrieNode searchNode = rootNode;

        for (int i = 0; i < stringToStore.length(); i++){

            char c = stringToStore.charAt(i);

            int childIndex = c - 'a';
            TrieNode charNode = searchNode.getChildNodes()[childIndex];

            // Not visited earlier. Need to create new child node
            if(charNode == null){

                charNode = new TrieNode();

                charNode.setCh(c);

                if(i == stringToStore.length()-1)
                    charNode.setWordEndFlag(true);
                else
                    charNode.setWordEndFlag(false);

                charNode.setChildNodes(new TrieNode[26]);

                TrieNode[] childNodes = searchNode.getChildNodes();
                childNodes[childIndex] = charNode;
                searchNode.setChildNodes(childNodes);
            }
            else {
                if (i == stringToStore.length() - 1 && !charNode.getWordEndFlag()) {
                    charNode.setWordEndFlag(true);
                }

            }
            searchNode = charNode;

        }
        System.out.println("Root node is "+rootNode);
    }


    public Boolean delete(String stringToDel){

        TrieNode searchNode = rootNode;

        for(int i=0; i <stringToDel.length(); i++){

            Character ch = stringToDel.charAt(i);
            int charIndex = ch - 'a';
            TrieNode charNode = searchNode.getChildNodes()[charIndex];
            if(charNode == null){
                return false;
            }
            if(i == stringToDel.length()-1){
                if(!charNode.getWordEndFlag()){
                    return false;
                }
                else {
                    charNode.setWordEndFlag(false);
                    return true;
                }
            }
            searchNode = charNode;
        }
        return false;
    }

    public Boolean search(String stringToSearch) {

        TrieNode searchNode = rootNode;

        for(int i=0; i < stringToSearch.length(); i++){

            Character ch= stringToSearch.charAt(i);

            int charIndex = ch-'a';

            TrieNode[] childNodes = searchNode.getChildNodes();

            if(childNodes != null && childNodes[charIndex] != null){

                searchNode = childNodes[charIndex];

                if(i == stringToSearch.length()-1){

                    if(searchNode.getWordEndFlag()){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }

            else {
                return false;
            }
        }
        return false;
    }
}
