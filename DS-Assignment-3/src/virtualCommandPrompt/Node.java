package virtualCommandPrompt;

import java.util.*;

public class Node {
    String name;
    List<Node> listOfChildren;
    
    public Node(String name)
    {
        this.name=name;
        listOfChildren=new ArrayList<Node>();
    }

}
