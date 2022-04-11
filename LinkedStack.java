//Student 1 full name: Weifeng Huang
//Student 2 full name: Weifeng Huang
//==================================================


/**
 * Your documentation for this class ....
 * This class implement the interface Stack.
 * It will override the 6 methods in the interface Stack
 * icluding: isEmpty, peek, pop, push, size and ttb.
 * This class create a stack using a link construction (a class called Elem).
 */

public class LinkedStack implements Stack {
	private static class Elem {
        /**
         * This class has two instance varibale value and next.
         * value may save any object value, and next may save a refernece to class Elem.
         * This class may link two and more Elem.
         * A way for implmenting stack
         * For exmaple:[1,[2,[3,null]]]
         * The first ELem, the value is 3, and next is null.
         * The second Elem, the value is 2, and next is [3,null]
         * The third ELem, the value is 1, and next is [2,[3,null]],
         * That makes the third Elem as the top.
         */
        private Object value;
        private Elem next;

        /**
         * The constructer for class Elem, has two input parameters.
         * They assign to the instance variable ‘value’ and ‘next’ respectively.
         */ 
        private Elem(Object value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem top;
    private int size;

    /**
     * The constructer for class LinkedStack, it doest not have a input parameters.
     * initially, top is assigned to null, size is 0.
     */ 
    LinkedStack(){
        top = null;
        size=0;
    }

    /**
     * isEmpty is a public method with no input parameter.
     * It shows wheather the stack is empty or not.
     * @return top==null with type of boolean
     * it return true if the top of the stack is empty,otherwise it return false;
     */
    public boolean isEmpty(){
        return top==null;
    }

    /**
     * size is a public method with no input parameter.
     * It shows the total number of the stack.
     * @return size with type of int
     * It return the instance variable size with type int.
     */
    public int size(){
        return size;
    }

    /**
     * push is a public method with a input parameter.
     * @param o with type of Object
     * This method is used to add value to the top of the stack.
     * It would create a new object with class Elem, and the top would be that object.
     * The size of the stack would add 1;
     * This method is used on play method to add the value to current stack.
     */
    public void push( Object o){
        if (top==null){
            top = new Elem(o,null);
        }else{
            Elem temp=new Elem(o, top);
            top = temp;
        }
        size++;
    }
    /**
     * pop is a public method with no input parameter.
     * It shows the value on the top of the stack and remove it.
     * @return temp.value
     * It is the value of instance variable top with type Elem.
     * This method is used on play method to delete value on current stack.
     */ 
    public Object pop(){
        Elem temp;
        if (isEmpty()){
            return null;
        }else{size--;}
        temp=top;
        top=top.next;
        return temp.value;
    }
    /**
     * peek is a public method with no input parameter.
     * It shows the value on the top of the stack.
     * @return top.value 
     * It is the value of instance variable top with type Elem.
     * This method is used on play method to dectect the size of value
     */
    public Object peek(){
        if (isEmpty()){
            return null;
        }
        return top.value;
    }

    /**
     * toString is a public method with no input parameter.
     * It print a message of the value on the stack from top to bottom.
     * @return res
     * It is a String that contains value of the top in the stack from top to bottom.
     * This method helps on testing period.
     */
    public String toString(){
        String res ="[";
        if (top != null){
            Elem p = top;
            res=res+p.value;
            p=p.next;
            while(p!=null){
                res = res+","+p.value;
                p=p.next;
            }
        }
        res=res+"]";
        return res;
    }
    /**
     * ttb(top to bottom) is a public method with one input parameter.
     * This method help print the stack vertically.
     * It is mainly use on the HanoiTowerGame.
     * The input parameter
     * @param disks is from the HanoiTowerGame which represent the total disks
     * (setting the empty lines) From the setting, disks would greater and equal to size.
     * @return s 
     * It is a string repersent the stack vertically with the empty lines(disks-size).
     */
    public String ttb(int disks){
        String s = "";
        for (int i=0; i<disks-size();i++){
            s=s+Utils.NEW_LINE;
        }
        if(top != null){
            Elem t = top;
            s=s+t.value;
            t=t.next;
            while (t!=null){
                s=s+Utils.NEW_LINE+t.value;
                t=t.next;
            }
        }
        return s;
    }


}