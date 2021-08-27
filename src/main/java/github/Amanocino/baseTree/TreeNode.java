package github.Amanocino.baseTree;

import java.util.List;

/**
 * @author : zhicheng chen
 * @date : 2021/7/29
 * @time : 15:22
 */
public interface TreeNode {
    Integer getTreeNodeId();

    Integer getTreeNodePid();

    void setTreeNodePids(String pids);

    String getTreeNodePids();

    void setChildrenTreeNode(List<TreeNode> treeNodes);

    List<TreeNode> getChildrenTreeNode();
}
