package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class Deocariza_Circular {
    public static class CircularQueue {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int nItems;

        public CircularQueue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
            nItems = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow. Cannot enqueue " + value);
            } else {
                rear = (rear + 1) % maxSize;
                queueArray[rear] = value;
                nItems++;
                System.out.println("Enqueued: " + value);
                displayQueue();
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow. Cannot dequeue.");
                return -1;
            } else {
                int temp = queueArray[front];
                front = (front + 1) % maxSize;
                nItems--;
                System.out.println("Dequeued: " + temp);
                displayQueue();
                return temp;
            }
        }

        public boolean isEmpty() {
            return (nItems == 0);
        }

        public boolean isFull() {
            return (nItems == maxSize);
        }

        public void displayQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
            } else {
                System.out.print("Queue: ");
                int i = front;
                int count = 0;
                while (count < nItems) {
                    System.out.print(queueArray[i]);
                    i = (i + 1) % maxSize;
                    if (count < nItems - 1) {
                        System.out.print(" - ");
                    }
                    count++;
                }
                System.out.println();
                System.out.println("Front: " + front);
                System.out.println("Rear: " + rear);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the Queue: ");
        int size = scan.nextInt();
        CircularQueue queue = new CircularQueue(size);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMENU");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. DISPLAY QUEUE");
            System.out.println("4. EXIT");
            System.out.print("Enter Choice [1..4]: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter a number to enqueue: ");
                    int number = scan.nextInt();
                    queue.enqueue(number);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a valid option [1..4].");
                    break;
            }
        }
        System.out.println("\nDeocariza Jr., Ramil, V.\nExiting the program...");
        scan.close();
    }
}
