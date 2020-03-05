package datastructure.array;

/**
 * <p> 类描述: 动态数组
 *
 * @author liqinghui
 * @version 1.0
 * @date 2020/03/03 23:04
 * @since 2020/03/03 23:04
 */
public class Array<T extends Comparable<T>> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 指定
     *
     * @param capacity 数组初始大小
     */
    public Array(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void addLast(T item) {
        add(this.size, item);
    }

    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * 在特定索引处增加元素
     *
     * @param index
     * @param item
     */
    public void add(int index, T item) {
        if (index > this.data.length || index < 0) {
            throw new IllegalArgumentException("out of range.");
        }

        // 扩容
        if(this.size == this.data.length) {
            resize(this.data.length * 2);
        }


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = item;
        size++;

    }


    /**
     * 数组元素个数
     *
     * @return 数组中元素个数
     */
    public int size() {
        return this.size();
    }

    /**
     * 数据空间大小
     *
     * @return 数组容量
     */
    public int capacity() {
        return this.data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int newSize){
        T[] newData = (T[]) new Comparable[newSize];
        for( int i = 0 ; i < this.size ; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Array:");
        stringBuilder.append("size = ").append(this.size);
        stringBuilder.append(", capacity = ").append(this.data.length).append(", data:[");
        for(int i = 0; i < size; i++) {
            stringBuilder.append(data[i].toString());
            if(i < size -1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 获取
     * @param index
     * @return
     */
    public T get(int index) {
        if(index < 0 || index >= this.size) {
            throw new IllegalArgumentException("out of range.");
        }
        return data[index];
    }

    public T removeElement(T item) {
        int index = indexOf(item);
        if(index != -1) {
            remove(index);
        }
        return null;
    }

    public void removeAllElement(T item) {
        int index = -1;
        while( (index = indexOf(item) ) != -1) {
            remove(index);
        }
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(this.size -1);
    }

    public T remove(int index) {
        if(index < 0 || index >= this.size) {
            throw new IllegalArgumentException("out of range.");
        }

        T ret = data[index];
//        for (int i = index; i < size - 1; i++) {
//           data[i] = data[i+1];
//        }

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size --;
        // gc
        data[size] = null;

        // 缩容
        if(size == data.length / 2) {
            resize(data.length/2);
        }

        return ret;
    }

    /**
     * 修改
     * @param index
     * @param item
     */
    public void set(int index, T item) {
        if(index < 0 || index >= this.size) {
            throw new IllegalArgumentException("out of range.");
        }
         data[index] = item;
    }

    public int indexOf(T item) {
        for (int i = 0; i < this.size; i++) {
            if(data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
       return indexOf(item) != -1;
    }

    /**
    * main
    */
    public static void main(String[] args){
        Array<Integer> arr = new Array(8);
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addFirst(4);
        System.out.println(arr);


        System.out.println(arr.remove(1));
        System.out.println(arr);

        arr.addLast(1);
        arr.addFirst(1);
        arr.add(2, 1);
        System.out.println(arr);
//        arr.removeAllElement(1);
//        System.out.println(arr);

        arr.addLast(5);
        arr.addLast(6);
        arr.addLast(7);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);
    }

}
