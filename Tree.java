import java.util.Stack;

public class Tree {
    private Node root;

    public Tree(){
        this.root=new Node();
    }
    public void insert(String word){
        Node current=root;
        for (char c: word.toLowerCase().toCharArray()){
            Node child = findChild(current, c);
            if (child==null){
                child=new Node();
                child.setNodeName(c);
                addChild(current, child);
            }
            current=child;
        }
        current.markEndOfWord();
    }
    public boolean search(String prefix){
        Node current=root;
        for (char c:prefix.toLowerCase().toCharArray()){
            current =findChild(current,c);
            if(current==null){
                return false;
            }
        }
        return true;
    }
    private Node findChild(Node current, char c){
        Node child = current.getFirstChild();
        while (child!=null){
            if(child.getNodeName()==c){
                return child;
            }
            child=child.getNextSibling();
        }
        return null;
    }
    private void addChild(Node current, Node child){
        if(current.getFirstChild()==null){
            current.setFirstChild(child);
        }else{
            Node sibling = current.getFirstChild();
            while (sibling.getNextSibling()!=null){
                sibling=sibling.getNextSibling();
            }
            sibling.setNextSibling(child);
        }
    }
    public void printWords(){
        Stack stack = new Stack();
        printRecursive(root, new StringBuilder(),stack);
        stack.print();
    }
    private void printRecursive(Node current, StringBuilder prefix, Stack stack){
        if(current.isEndOfWord()){
            stack.push(prefix.toString());
        }
        Node child = current.get.FirstChild();
        while(child!=null){
            prefix.append(child.getNodeName());
            printRecursive(child, prefix, stack);
            prefix.deleteCharAt(prefix.length()-1);
            child=child.getNextSibling();
        }
    }

    public void bubbleSortAscending() {
        Stack stack = new Stack();
        printRecursive(root, new StringBuilder(), stack);
        stack.bubbleSortAscending();
    }

    public void bubbleSortDescending(){
        Stack stack = new Stack();
        printRecursive(root, new StringBuilder(), stack);
        stack.bubbleSortDescending();
    }
}
