import java.util.Arrays;

public class BinaryHeap {

    private int [] heap;
    private int size = 0;

    public BinaryHeap(){
        heap = new int[10];
    }

    //returns the positon the parent in the heap
    private int parent(int pos){
        return (pos-1)/2;
    }
    //returns the positon the child in the heap
    private int child(int pos){
        return (pos*2)+1;
    }

    //grows array by 10
    private void grow_array(){
        heap = Arrays.copyOf(heap,heap.length+10);
    }

    // swap values of heap[child] and heap[parent]
    private void swap (int [] heap, int child, int parent){
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }

    private void shiftdown(int parent) {

        int child = child(parent);
        if (child < size) {
            if ((heap[child] > heap[child + 1]) && (child + 1) < size)
                child++;
            if (heap[child] < heap[parent]) {

                swap(heap, child, parent);
                shiftdown(child);

            }
        }
    }

    //adds a value the heap and puts it in the correct position
    public void add(int value) {
        if(size == heap.length) //if size + 1 will be full grow array
            grow_array();

        heap[size++] = value;
        int child = size-1;
        int parent = parent(child);

        while (parent >= 0 && heap[child] < heap [parent]){
            swap(heap,child, parent);
            //if swapped , heap[current] is now at the index it's parent was at and current is the same value
            child = parent;
            parent = parent(child);
        }

    }

    //removes the minimum value, ie the root of the heap
    public int remove() {
        int rem = heap[0];
        heap[0] = heap[--size];
        shiftdown(0);
        return rem;
    }




}
