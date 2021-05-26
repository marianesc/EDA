import java.util.Scanner;

public class MaxHeap {

    private int[] heap;
    private int tail;

    public MaxHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return (i+1)*2;
    }

    public boolean isMax() {
        for (int i = 0; i < this.heap.length; i++) {
            int left = left(i);
            int right = right(i);
            if (left <= this.tail && this.heap[left] > this.heap[i]) return false;
            if (right <= this.tail && this.heap[right] > this.heap[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] heapList = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            heapList[i] = Integer.parseInt(nums[i]);
        }

        MaxHeap heap = new MaxHeap(heapList);
        System.out.println(heap.isMax());
    }
}
