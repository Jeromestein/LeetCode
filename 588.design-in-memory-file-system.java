/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start
// Unified Directory and File List
public class FileSystem {
    class File {
        boolean isFile = false;
        // Use hashmap to store all files in current directory
        // <file names, file>
        HashMap<String, File> files = new HashMap<>();
        String content = "";
    }

    File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File curr = root;
        if (!path.equals("/")) {
            String[] levels = path.split("/");
            for (int i = 1; i < levels.length; i++) {
                curr = curr.files.get(levels[i]);
            }
            // If path is a file path,
            // returns a list that only contains this file's name.
            if (curr.isFile) {
                List<String> res = new ArrayList<>();
                res.add(levels[levels.length - 1]);
                return res;
            }
        }
        // If path is a directory path,
        // returns the list of file and directory names in this directory
        // lexicographically.
        List<String> res = new ArrayList<>(curr.files.keySet());
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        // Makes a new directory according to the given path.
        // If the middle directories in the path do not exist,
        // you should create them as well.
        File curr = root;
        String[] levels = path.split("/");
        for (int i = 1; i < levels.length; i++) {
            if (!curr.files.containsKey(levels[i]))
                curr.files.put(levels[i], new File());
            curr = curr.files.get(levels[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File curr = root;
        String[] levels = filePath.split("/");
        for (int i = 1; i < levels.length - 1; i++) {
            curr = curr.files.get(levels[i]);
        }
        // If filePath does not exist, creates that file containing given content.
        if (!curr.files.containsKey(levels[levels.length - 1]))
            curr.files.put(levels[levels.length - 1], new File());
        // If filePath already exists, appends the given content to original content.
        curr = curr.files.get(levels[levels.length - 1]);
        curr.isFile = true;
        curr.content = curr.content + content;
    }

    public String readContentFromFile(String filePath) {
        // Returns the content in the file at filePath.
        File curr = root;
        String[] levels = filePath.split("/");
        for (int i = 1; i < levels.length - 1; i++) {
            curr = curr.files.get(levels[i]);
        }
        return curr.files.get(levels[levels.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end
