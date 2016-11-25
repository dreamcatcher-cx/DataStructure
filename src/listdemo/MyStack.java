package listdemo;

/**
 * Created by chengxiao on 2016/10/20.
 */
public class MyStack {
    private int[] container = new int[20];
    //栈顶指针
    private int top = -1;
    //栈大小
    private int size = 0;

    /**
     * 压栈
     * @param data
     * @return
     * @throws Exception
     */
    public boolean push(int data) throws Exception {
        //若栈满，抛异常
        if(top == container.length-1){
            throw new Exception("栈空间已满，无法压栈");
        }
        top++;
        container[top] = data;
        return true;
    }

    /**
     * 出栈
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        //若空栈，抛异常
        if(top==-1){
            throw new Exception("栈空间为空，无法出栈");
        }

        int result = container[top] ;
        container[top] = 0;
        top--;
        return result;
    }

    /**
     * 列出栈中数据
     */
    public void display(){
       while(top > -1){
           try {
               System.out.print(this.pop()+" ");
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
    public static  void main(String []args) throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(12);
        myStack.push(34);
        myStack.push(23);
        myStack.push(34);
        myStack.display();
    }
}
