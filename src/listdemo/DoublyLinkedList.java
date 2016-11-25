package listdemo;

/**
 * Created by chengxiao on 2016/10/18.
 */
public class DoublyLinkedList {
    //头节点
    private Node firstNode ;

    private static class Node{
        //数据域
        private int data;
        //指针域
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    /**
     * 从头部进行插入 时间复杂度O(1);
     * @param data
     */
    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = firstNode;
        firstNode = newNode;
    }

    /**
     * 从尾部进行插入
     * @param data
     */
    public void insertLast(int data){
        Node newNode = new Node(data);
        if(firstNode==null){
            firstNode = newNode;
            return;
        }
        //要找到尾节点，只能从头结点进行遍历了。
        Node currNode = firstNode;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        //在尾部插入新结点
        currNode.next = newNode;

    }
    public void display(){
        Node currNode = firstNode;
        while (currNode!=null){
            System.out.print(currNode.data+" , ");
            currNode = currNode.next;
        }
    }
    public static  void main(String []args){
//        java.util.MyLinkedList linkedList1 = new java.util.MyLinkedList();
//        linkedList1.add(1);
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertLast(2);
        linkedList.insertLast(0);
        linkedList.insertLast(1);
        linkedList.insertLast(6);
        linkedList.display();
    }
}
