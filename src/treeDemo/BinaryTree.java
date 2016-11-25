package treeDemo;

/**
 * Created by chengxiao on 2016/10/30.
 */
public class BinaryTree {
    //根节点
    private Node root;
    /**
     * 树的结点
     */
    private static class Node{
        //数据域
        private long data;
        //左子结点
        private Node leftChild;
        //右子结点
        private Node rightChild;
        Node(long data){
            this.data = data;
        }
    }

    /**
     * 插入结点
     * @param data
     */
    public void insert(long data){
        Node newNode = new Node(data);
        Node currNode = root;
        Node parentNode;
        //如果是空树
        if(root == null){
            root = newNode;
            return;
        }
        while(true){
            parentNode = currNode;
            //向右搜寻
            if(data > currNode.data){
                currNode = currNode.rightChild;
                if(currNode == null){
                    parentNode.rightChild = newNode;
                    return;
                }
            }else{
                //向左搜寻
                currNode = currNode.leftChild;
                if(currNode == null){
                    parentNode.leftChild = newNode;
                    return;
                }
            }
        }

    }
    public void preOrder(Node currNode){
        if(currNode == null){
            return;
        }
        System.out.println(currNode.data);
        preOrder(currNode.leftChild);
        preOrder(currNode.rightChild);
    }
    public void inOrder(Node currNode){
        if(currNode == null){
            return;
        }
        inOrder(currNode.leftChild);
        System.out.println(currNode.data);
        inOrder(currNode.rightChild);

    }
    public void postOrder(Node currNode){
        if(currNode == null){
            return;
        }
        postOrder(currNode.leftChild);
        postOrder(currNode.rightChild);
        System.out.println(currNode.data);
    }
    public static void main(String []args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(8);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(10);
        System.out.println("前序遍历：");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("================");
        System.out.println("中序遍历：");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("================");
        System.out.println("后序遍历：");
        binaryTree.postOrder(binaryTree.root);
    }
}