/**
 * 17683 Data Structures for Application Programmers.
 * Homework 1 MyArray
 *
 * Andrew ID: lsureshk
 * @author Laxmi PriyaDharshini Suresh Kumar
 */

public class MyArray {
//public MyArray()
//public MyArray(int initialCapacity)
// public void add(String text)
//public boolean search(String key)
// public int size()
//public int getCapacity()
//public void display()
//public void removeDups()
    private static int capacity;
    private String[] myarray;
    private int size;

    MyArray(){
    capacity=0;
        myarray=new String[capacity];
    size=0;
    }
    MyArray(int initialCapacity){
        capacity=initialCapacity;
        myarray=new String[capacity];
        size=0;
    }
    public void add(String text){

        if (!validateText(text)) {
            return;
        }

        /*
         * if myArray reached current capacity, double up its capacity
         * create a new array of the new capacity
         * then copy over the elements from old array to the new array
         * and set myArray to point to the new array
         * finally add the text to myArray and increment size by 1
         */
        if(size==myarray.length){
            int newcapacity;
            if(size==0){
                newcapacity=1;
            }
            else {

                newcapacity = 2 * size;
                capacity=newcapacity;
            }
                String[] newarray=new String[newcapacity];
                System.arraycopy(myarray,0,newarray,0,size);
                myarray=newarray;

        }

    myarray[size++]=text;
    }

    public boolean search(String key){
        if(key==null){
            return false;
        }

        for(String sear:myarray){
            if(sear!=null & sear.equals(key)){
                return true;
            }
        }
    return false;
    }
    public int size(){
        return size;
    }
    public int getCapacity(){

        return capacity;
    }
    public void display(){
    for(int i=0;i<size;i++)
    {
        System.out.print (myarray[i]+" ");
    }
    }
    public void removeDups(){
        int dupcounter=0;
        for (int i = 0; i < size - 1; i++) {
            if (myarray[i] == null) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (myarray[j] == null) {
                    continue;
                }
                if (myarray[i].equals(myarray[j])) {
                    dupcounter++;
                    myarray[j] = null;
                }
            }
        }
    size-=dupcounter;
        String[] newArray = new String[getCapacity()];
        int i = 0;
        for (String text : myarray) {
            if (text != null) {
                newArray[i++] = text;
            }
        }
        myarray = newArray;
    }

    private boolean validateText(String text){
        if(text==null){
            return false;
        }
        else
           return text.matches("[a-zA-Z]+");
    }
}
