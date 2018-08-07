package virtualCommandPrompt;

import java.util.*;

public class Node {
    private String name;
    private List<Node> listOfChildren;
    private Node parent;
    private Date creationTime;
    
    public Node(String name)
    {
        this.name=name;
        listOfChildren=new ArrayList<Node>();
        parent=null;
        creationTime=new Date();
    }

    public Date getCreationTime() {
        Date time=creationTime;
        return time;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getListOfChildren() {
        return listOfChildren;
    }

    public void setListOfChildren(List<Node> listOfChildren) {
        this.listOfChildren = listOfChildren;
    }
    
    public void addChild(Node child)
    {
        listOfChildren.add(child);
    }

}
