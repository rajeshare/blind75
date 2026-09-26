import java.util.Arrays;
import java.util.PriorityQueue;

public class CalenderMeetings {

    public static void main(String[] args) {
        int[][] intervals=new int[][]{
                {12,13},{9,10},{9,12},{10,11},{11,13}
        };
        System.out.println(minRooms(intervals));
    }


    public static int minRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // A room is free
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // Allocate room
            minHeap.offer(end);
        }

        return minHeap.size();
    }

}
