import java.util.*;

public class filesystem {
    public static void main(String[] args) {
        FileMethods fl = new FileMethods();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (true) {
            fl.printCurrentPath();
            String command = sc.nextLine();
            fl.handleCommand(command);
        }

    }
}

class TreeNode {
    private String name;
    private boolean isFile;
    private TreeNode parent;
    private Map<String, TreeNode> children;

    public TreeNode(String name, boolean isFile, TreeNode parent) {
        this.name = name;
        this.isFile = isFile;
        this.parent = parent;
        this.children = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void addChild(TreeNode child) {
        if (!isFile) {
            children.put(child.getName(), child);

        }

    }

    public TreeNode getChild(String name) {
        return children.get(name);
    }

    public TreeNode getParent() {
        return parent;
    }

    public Map<String, TreeNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "TreeNode(name=" + name + ", isFile=" + isFile + ")";

    }

}

class FileMethods {
    private TreeNode root;
    private TreeNode current;

    public FileMethods() {
        root = new TreeNode("root/", false, null);
        current = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getCurrentDirectory() {
        return current;
    }

    public void setCurrentDirectory(TreeNode directory) {
        current = directory;
    }

    public void addDirectory(String dirname) {
        TreeNode newDir = new TreeNode(dirname, false, current);
        current.addChild(newDir);
    }

    public void addFile(String Filename) {
        TreeNode newFile = new TreeNode(Filename, false, current);
        current.addChild(newFile);
    }

    public void changeDirectory(String dirName) {
        if (dirName.equals("/")) {
            current = root;
        } else if (dirName.equals("..")) {
            if (current.getParent() != null) {
                current = current.getParent();

            }

        } else {
            TreeNode targetDir = current.getChild(dirName);
            if (targetDir != null && !targetDir.isFile()) {
                current = targetDir;
            } else {
                System.out.println("Directory not found: " + dirName);
            }
        }
    }

    public void delete(String[] parts) {
        if (parts.length > 1) {
            TreeNode target = current.getChild(parts[1]);
            if (target != null) {
                current.getChildren().remove(parts[1]);
            } else {
                System.out.println("File/Directory not found: " + parts[1]);
            }
        } else {
            System.out.println("Usage: delete <file/directory_name>");
        }

    }

    public void search(String[] parts) {
        if (parts.length > 1) {
            String targetName = parts[1];
            searchHelper(root, targetName);
        } else {
            System.out.println("Usage: search<file/directory_name>");
        }
    }

    private void searchHelper(TreeNode node, String targetName) {
        if (node.getName().equals(targetName)) {
            System.out.println("Found: " + node);
        }
        for (TreeNode child : node.getChildren().values()) {
            searchHelper(child, targetName);
        }
    }

    public void printCurrentPath() {
        StringBuilder path = new StringBuilder();
        buildPath(path, current);
        System.out.print(path.toString() + ">");
    }

    private void buildPath(StringBuilder path, TreeNode node) {
        if (node == root) {
            path.append("/");
        } else {
            buildPath(path, node.getParent());
            path.append(node.getName()).append("/");
        }
    }

    public void handleCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) {
            System.out.println("Invalid");
            return;
        }
        String cmd = parts[0];
        switch (cmd.toLowerCase()) {
            case "adddir":
                if (parts.length > 1) {
                    addDirectory(parts[1]);
                } else {
                    System.out.println("Usage: AddDir <directory_name>");
                }
                break;
            case "addfile":
                if (parts.length > 1) {
                    addFile(parts[1]);
                } else {
                    System.out.println("Usage: AddFile<file_name>");
                }
                break;
            case "cd":
                if (parts.length > 1) {
                    changeDirectory(parts[1]);
                } else {
                    System.out.println("Usage: cd <directory_name");
                }
                break;
            case "Is":
                for (TreeNode child : current.getChildren().values()) {
                    System.out.println(child.getName() + (child.isFile() ? "" : "/"));
                }
                break;
            case "path":
                printCurrentPath();
                System.out.println();
                break;
            case "delete":
                delete(parts);
                break;
            case "search":
                search(parts);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Unknown command: " + cmd);
                break;
        }
    }

}