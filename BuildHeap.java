import java.util.Arrays;
import java.util.Scanner;

public class BuildHeap {

    private int[] heap;
    private int tail;

    public BuildHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return (i+1)*2;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private void heapify(int index) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int max = index;

        if (leftIndex <= this.tail && this.heap[leftIndex] > this.heap[index]) {
            max = leftIndex;
        }
        if (rightIndex <= this.tail && this.heap[rightIndex] > this.heap[max]) {
            max = rightIndex;
        }

        if (max != index) {
            this.swap(index, max);
            heapify(max);
        }
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--)
            heapify(i);
    }

    public String toString() {
        return Arrays.toString(this.heap);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] heapList = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            heapList[i] = Integer.parseInt(nums[i]);
        }

        BuildHeap heap = new BuildHeap(heapList);
        System.out.println(heap.toString());
    }
}
