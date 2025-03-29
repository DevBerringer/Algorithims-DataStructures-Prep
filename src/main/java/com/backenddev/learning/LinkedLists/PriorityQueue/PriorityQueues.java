package com.backenddev.learning.LinkedLists.PriorityQueue;
import java.util.*;

public class PriorityQueues {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> mapEn : map.entrySet()) {
            pq.add(mapEn);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result[--k] = pq.poll().getKey();
        }
        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int nextLargest = maxHeap.poll();

            if (largest != nextLargest) {
                maxHeap.offer(largest - nextLargest);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }


    public int[][] kClosest(int[][] points, int k) {
        // Custom comparator to sort based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA); // Max-heap
        });

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Convert the heap to an array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the initial nodes of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        PriorityQueues priorityQueues = new PriorityQueues();

        int[][] visits1 = {{1,2},{2,2},{3,3},{4,4}};
        int[][] closestUsers = priorityQueues.kClosest(visits1, 2);
        for (int[] user : closestUsers) {
            System.out.println("User: (" + user[0] + ", " + user[1] + ")");
        }

        int[] case1 = {1,1,1,2,2,3};
        int[] result = priorityQueues.topKFrequent(case1, 2);
        System.out.println(Arrays.toString(result));
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


