package listdemo;
/**
 * Created by chengxiao on 2016/10/18.
 */
public class MyLinkedList {
    /**
     * 指向头结点的引用
     */
    private Node first ;
    /**
     * 线性表大小
     */
    private int size;
    /**
     * 结点类
     */
    private static class Node{
        //数据域
        private int data;
        //指向后继结点的引用
        private Node next;
        Node(int data){
            this.data = data;
        }
    }
    /**
     * 从头部进行插入
     * 步骤：1.新结点的next链指向当前头结点；2.将first指向新节点
     * 时间复杂度：O(1)
     * @param data
     */
    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        size++;
    }
    /**
     * 从头部进行删除操作
     * 步骤：1.跳过要删除的头结点，将first引用直接指向头结点的next结点即可
     * 时间复杂度为：O(1)
     * @return
     */
    public boolean deleteFirst(){
        if(isEmpty()){
            return false;
        }
        Node secondNode = first.next;
        first.next = null;
        first = secondNode;
        size--;
        return true;
    }
    /**
     * 取出第i个结点
     * 步骤：从头结点进行遍历，去除第i个结点
     * 时间复杂度：O(n)，此操作对于利用数组实现的顺序存储结构，仅需常数阶O(1)即可完成。
     * @param index
     * @return
     */
    public int get(int index) throws Exception {
        if(!checkIndex(index)){
            throw new Exception("index不合法！");
        }
        Node curr = first;
        for(int i=0;i<index;i++){
            curr = curr.next;
        }
        return curr.data;
    }
    /**
     * 遍历线性表
     * 时间复杂度：O(n)
     */
    public void displayList(){
        Node currNode = first;
        while (currNode!=null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * index是否合法
     * @param index
     * @return
     */
    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }
    /**
     * 链表大小
     * @return
     */
    public int size() {
        return size;
    }
    public static  void main(String []args) throws Exception {

        MyLinkedList myLinkedList = new MyLinkedList();
        //从头部插入
        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(4);
        //遍历线性表中元素
        myLinkedList.displayList();
        //获取第二个元素
        System.out.println(myLinkedList.get(3));
        //删除结点
        myLinkedList.deleteFirst();
        myLinkedList.displayList();
    }
}