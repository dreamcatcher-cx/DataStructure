package listdemo;
/**
 * Created by chengxiao on 2016/10/18.
 */
public class MyLinkedList1 {
    /**
     * 指向头结点的引用
     */
    private Node first ;
    /**
     * 指向尾结点的引用
     */
    private Node rear;
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
        //后继结点的引用
        private Node next;
        //前驱结点的引用
        private Node prev;

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
        if(first == null){
            return false;
        }
        first = first.next;
        size--;
        return true;
    }
    /**
     * 双端链表，从尾部进行插入
     * 步骤：将当前尾结点的next链指向新节点即可
     * 时间复杂度：O(1)
     * @param data
     */
    public void insertLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            first = newNode;
            rear = newNode;
            size++;
            return;
        }
        rear.next = newNode;
        newNode.prev = rear;
        rear = newNode;
        size++;
    }
    /**
     * 取出第i个结点
     * 步骤：从头结点进行遍历，去除第i个结点
     * 时间复杂度：O(n)，此操作对于利用数组实现的顺序存储结构，仅需常数阶O(1)即可完成。
     * @param index
     * @return
     */
    public int get(int index) throws Exception {
        if(index > size-1 ){
            throw new Exception("不存在第"+index+"个元素");
        }
        int flag = 0;
        Node curr = first;
        while(flag != index){
            curr = curr.next;
            flag++;
        }
        return curr.data;

    }
    /**
     * 删除尾结点
     * 主要步骤：1.将rear指向倒数第二个结点 2.处理相关结点的引用链
     * 时间复杂度：O(1)
     * @return
     */
    public void deleteLast() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空");
        }
        Node secondLast = rear.prev;
        rear.prev = null;
        rear = secondLast;
        if(rear == null){
            first = null;
        }else{
            rear.next = null;
        }
        size--;
    }
    /**
     * 遍历线性表
     * 时间复杂度：o(n)
     */
    public void displayList(){
        Node currNode = first;
        while (currNode!=null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == null;
    }
    public static  void main(String []args) throws Exception {

        MyLinkedList1 myLinkedList = new MyLinkedList1();
//        //从头部插入
//        myLinkedList.insertFirst(1);
//        myLinkedList.insertFirst(2);
//        myLinkedList.insertFirst(3);
//        myLinkedList.insertFirst(4);
//        //遍历线性表中元素
//        myLinkedList.displayList();
//        //获取第二个元素
//        System.out.println();
//        System.out.println(myLinkedList.get(2));
//        //删除结点
//        myLinkedList.deleteFirst();
//        myLinkedList.displayList();
        myLinkedList.insertLast(1);
        myLinkedList.insertLast(2);
        myLinkedList.insertLast(3);
        myLinkedList.insertLast(4);
        myLinkedList.displayList();
        System.out.println();
        System.out.println("===");
        myLinkedList.deleteLast();
        myLinkedList.displayList();
        System.out.println();
        System.out.println("===");
        myLinkedList.deleteLast();
        myLinkedList.displayList();
        System.out.println();
        System.out.println("===");
        myLinkedList.deleteLast();
        myLinkedList.displayList();
        System.out.println();
        System.out.println("===");
        myLinkedList.deleteLast();
        myLinkedList.displayList();

    }
}
