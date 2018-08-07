package virtualCommandPrompt;

import java.util.*;

public class VirtualCommandPrompt {
    private Node root;
    private Node currentDirectory;
    
    public VirtualCommandPrompt()
    {
        root=new Node("Root:");
        currentDirectory=root;
    }

    public Node getRoot() {
        return root;
    }
    
    public String makeDirectory(String directoryName)
    {
        String message=null;
        List<Node> listOfChilren=currentDirectory.getListOfChildren();
        for(Node chid:listOfChilren)
        {
            String childName=chid.getName();
            if(directoryName.equals(childName))
            {
                message="directory "+directoryName+" already exists.";
                return message;
            }
        }
        Node newDirectory=new Node(directoryName);
        newDirectory.setParent(currentDirectory);
        currentDirectory.addChild(newDirectory);
        return message;
    }
    
    public String changeDirectory(String directoryName)
    {
        String message=null;
        List<Node> listOfChilren=currentDirectory.getListOfChildren();
        for(Node child:listOfChilren)
        {
            String childName=child.getName();
            if(directoryName.equals(childName))
            {
                currentDirectory=child;
                return message;
            }
        }
        message="directory "+directoryName+" doesn't exists.";
        return message;
    }
    
    public String moveToParentDirectory()
    {
        String currentDiractoryName="";
        if(currentDirectory==root)
        {
            return currentDiractoryName;
        }
        currentDiractoryName=currentDirectory.getName();
        currentDirectory=currentDirectory.getParent();
        return currentDiractoryName;
    }
    
    public List<Node> getListOfSubFolder()
    {
        List<Node> listOfSubFolder=currentDirectory.getListOfChildren();
        return listOfSubFolder;
    }
    
    public void displayDirectoryStructure(Node root)
    {
        List<Node> listOfSubFolder=root.getListOfChildren();
        if(listOfSubFolder.size()==0)
        {
            return;
        }
        for(Node child:listOfSubFolder)
        {
            System.out.println("|-"+child.getName());
            displayDirectoryStructure(child);
        }
    }
    
    

}
