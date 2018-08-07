package virtualCommandPrompt;

import java.util.*;

public class VirtualCMDMain {
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        VirtualCommandPrompt virtualCMD=new VirtualCommandPrompt();
        System.out.println("::Welcome to virtual command prompt::");
        System.out.println();
        String currentDirectory=virtualCMD.getRoot().getName()+"\\";
        while(true)
        {
            System.out.print(currentDirectory+">");
            String command=scanner.next();
            String directoryName;
            String message;
            switch(command)
            {
            case "mkdir":
                directoryName=scanner.nextLine();
                message=virtualCMD.makeDirectory(directoryName);
                if(message!=null)
                {
                    System.out.println(message);
                }
                break;
            case "cd":
                directoryName=scanner.nextLine();
                message=virtualCMD.changeDirectory(directoryName);
                if(message!=null)
                {
                    System.out.println(message);
                }
                else
                {
                    currentDirectory+="\\"+directoryName;
                }
                break;
            case "bk":
                String movedDirectoryName=virtualCMD.moveToParentDirectory();
                if(movedDirectoryName!=null)
                {
                    currentDirectory.replace(("\\")+movedDirectoryName, "");
                }
                break;
            case "ls":
                List<Node> subFolderList=virtualCMD.getListOfSubFolder();
                for(Node subFolder:subFolderList)
                {
                    Date creationTime=subFolder.getCreationTime();
                    String name=subFolder.getName();
                    System.out.println(creationTime+" "+name);
                }
                int size=subFolderList.size();
                System.out.println(size+"Folder(s)");
                break;
            case "find":find(current,"");
                break;
            case "tree":
                Node root=virtualCMD.getRoot();
                virtualCMD.displayDirectoryStructure(root);
                break;
            case "exit":
                System.exit(0);
                break;
            default :
                System.out.println("command "+command+" doesn't exist");
            }
        }
    }

}
