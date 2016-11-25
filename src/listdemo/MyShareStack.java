package listdemo;

/**
 * Created by chengxiao on 2016/10/20.
 */
public class MyShareStack {
    private int[] container;
    //左栈指针
    private int l_top;
    private int r_top ;
    //栈大小
    private int size = 0;
    public MyShareStack(){
        this.container = new int[10];
        this.l_top = -1;
        this.r_top = container.length;
    }
    /**
     * 压栈
     * @param data
     * @return
     * @throws Exception
     */
    public boolean push(int data,String flag) throws Exception {
        //若栈满，抛异常
        if(r_top-l_top==1){
            throw new Exception("栈已满，无法压栈");
        }
        if("l".equals(flag)){
            container[++l_top] = data;
        }else{
            container[--r_top] = data;
        }
        return true;
    }

    /**
     * 出栈
     * @param flag
     * @return
     * @throws Exception
     */
    public int pop(String flag) throws Exception {
        //若空栈，抛异常
        if("l".equals(flag)){
            if(l_top==-1){
                throw new Exception("栈为空，无法出栈");
            }
            return container[l_top--];
        }else{
            if(r_top==container.length){
                throw new Exception("栈为空，无法出栈");
            }
            return container[r_top++];
        }

    }

    /**
     * 列出栈中数据
     */
    public void display(String flag){
        if("l".equals(flag)){
            while(l_top>-1){
                System.out.print(container[l_top--]+" ");
            }
        }else{
            while(r_top<container.length){
                System.out.print(container[r_top++]+" ");
            }
        }
    }
    public static  void main(String []args) throws Exception {
        MyShareStack myShareStack = new MyShareStack();
        myShareStack.push(1,"l");
        myShareStack.push(2,"l");
        myShareStack.push(3,"l");
        myShareStack.push(4,"l");
        myShareStack.push(5,"l");
        myShareStack.push(6,"l");

        myShareStack.push(9,"r");
        myShareStack.push(8,"r");
        myShareStack.push(7,"r");
        myShareStack.push(7,"r");
        myShareStack.push(7,"r");

       myShareStack.display("l");

        System.out.println("=========");
        myShareStack.display("r");
    }
}
