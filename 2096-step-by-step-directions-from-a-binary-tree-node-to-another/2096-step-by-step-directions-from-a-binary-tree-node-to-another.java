class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {

        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        startPath.reverse();
        destPath.reverse();
        int i = 0;
        while (i < startPath.length() &&
               i < destPath.length() &&
               startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        StringBuilder ans = new StringBuilder();

        for (int j = i; j < startPath.length(); j++)
            ans.append('U');

        ans.append(destPath.substring(i));

        return ans.toString();
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false;

        if (root.val == target)
            return true;

        if (findPath(root.left, target, path)) {
            path.append('L');
            return true;
        }
        // path.deleteCharAt(path.length() - 1);

        if (findPath(root.right, target, path)) {
            path.append('R');
            return true;
        }
        // path.deleteCharAt(path.length() - 1);

        return false;
    }
}