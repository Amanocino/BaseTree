package github.Amanocino.baseTree;

import io.netty.handler.codec.mqtt.MqttPublishMessage;

import java.util.List;
import java.util.TreeMap;

/**
 * @author : zhicheng chen
 * @date : 2021/7/29
 * @time : 15:20
 */
public abstract class BaseTree {
    public String createNewTreeNode(TreeNode treeNode){
        if (!treeNode.getTreeNodePid().equals(0)){
            TreeNode treeNodeP = getTreeNode(treeNode.getTreeNodePid());
            if (null==treeNodeP){
                return "false";
            }
            treeNode.setTreeNodePids(treeNodeP.getTreeNodePids()+treeNode.getTreeNodePid()+",");
        }
        insertTreeNode(treeNode);
        return "true";
    }

    public String editTreeNode(TreeNode treeNode){
        TreeNode treeNodeOri = getTreeNode(treeNode.getTreeNodeId());
        if (null==treeNodeOri){
            return "false";
        }
        if (!treeNodeOri.getTreeNodePid().equals(treeNode.getTreeNodePid())){
            //批量修改子级节点pids值

//            treeNode.setTreeNodePids(treeNodeP.getTreeNodePids()+treeNode.getTreeNodePid()+",");
        }
        updateTreeNode(treeNode);
        return "true";
    }

    public List<TreeNode> queryTreeNodeList(TreeNode treeNode, boolean isTree){
        List<TreeNode> treeNodes = queryTreeNodes(treeNode);
        if (isTree){
            for (TreeNode treeNodeTmp:treeNodes){
                 for (TreeNode treeNodeTmp1:treeNodes){
                     if (treeNodeTmp1.getTreeNodeId().equals(treeNodeTmp.getTreeNodePid())){
                         List<TreeNode> treeNodeTmpChildrenList = treeNodeTmp1.getChildrenTreeNode();
                         treeNodeTmpChildrenList.add(treeNodeTmp);
                         treeNodes.remove(treeNodeTmp);
                         treeNodeTmp1.setChildrenTreeNode(treeNodeTmpChildrenList);
                         break;
                     }
                 }

            }

        }
        return treeNodes;
    }

    public abstract Integer insertTreeNode(TreeNode treeNode);

    public abstract Integer updateTreeNode(TreeNode treeNode);

    public abstract Integer batchUpdateTreeNode(TreeNode treeNode);

    public abstract TreeNode getTreeNode(Integer id);

    public abstract List<TreeNode> queryTreeNodes(TreeNode treeNode);
}
