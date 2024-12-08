package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class Deocariza_Queues {
    public static class QueueArray {
        private int maxSize;
        private int[] queueArray;
        private int front;
        private int rear;
        private int nItems;

        public QueueArray(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;
            rear = -1;
            nItems = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue overflow. Cannot enqueue " + value);
            } else {
                if (rear == maxSize - 1) {
                    rear = -1;
                }
                queueArray[++rear] = value;
                nItems++;
                System.out.println("Enqueued: " + value);
                displayQueue();
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue underflow. Cannot dequeue.");
                return -1;
            } else {
                int temp = queueArray[front++];
                if (front == maxSize) {
                    front = 0;
                }
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
                while (i != rear) {
                    System.out.print(queueArray[i] + " ");
                    i = (i + 1) % maxSize;
                }
                System.out.println(queueArray[rear]);
                System.out.println("Front: " + front);
                System.out.println("Rear: " + rear);
            }
        }
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class QueueLinkedList {
        private Node front;
        private Node rear;

        public QueueLinkedList() {
            front = null;
            rear = null;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                front = newNode;
            } else {
                rear.next = newNode;
            }
            rear = newNode;
            System.out.println("Enqueued: " + value);
            displayQueue();
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue underflow. Cannot dequeue.");
                return -1;
            } else {
                int temp = front.data;
                front = front.next;
                if (front == null) {
                    rear = null;
                }
                System.out.println("Dequeued: " + temp);
                displayQueue();
                return temp;
            }
        }

        public boolean isEmpty() {
            return (front == null);
        }

        public void displayQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
            } else {
                System.out.print("Queue: ");
                Node current = front;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
                System.out.println("Front: " + (front != null ? front.data : "null"));
                System.out.println("Rear: " + (rear != null ? rear.data : "null"));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("=== WELCOME TO QUEUEING! ===");
            System.out.println("\nMENU");
            System.out.println("1. ARRAY IMPLEMENTATION");
            System.out.println("2. LINKED LIST IMPLEMENTATION");
            System.out.println("3. EXIT");
            System.out.print("Enter Choice [1..3]: ");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    System.out.print("\nEnter the size of the Queue: ");
                    int sizeArray = scan.nextInt();
                    QueueArray arrayQueue = new QueueArray(sizeArray);
                    boolean exitArray = false;
                    while (!exitArray) {
                    	System.out.println("\nMENU");
                        System.out.println("1. ENQUEUE");
                        System.out.println("2. DEQUEUE");
                        System.out.println("3. DISPLAY QUEUE");
                        System.out.println("4. EXIT");
                        System.out.print("Enter Choice [1..4]: ");
                        int choiceArray = scan.nextInt();
                        switch (choiceArray) {
                            case 1:
                                System.out.print("\nEnter a number to enqueue: ");
                                int number = scan.nextInt();
                                System.out.println();
                                arrayQueue.enqueue(number);
                                break;
                            case 2:
                            	System.out.println();
                                arrayQueue.dequeue();
                                break;
                            case 3:
                            	System.out.println();
                                arrayQueue.displayQueue();
                                break;
                            case 4:
                                System.out.println("\nExiting Array Implementation...\n");
                                exitArray = true;
                                break;
                            default:
                                System.out.println("\nPlease enter a valid option [1..4].");
                                break;
                        }
                    }
                    break;
                case 2:
                    QueueLinkedList linkedListQueue = new QueueLinkedList();
                    boolean exitLinkedList = false;
                    while (!exitLinkedList) {
                    	System.out.println("\nMENU");
                        System.out.println("1. ENQUEUE");
                        System.out.println("2. DEQUEUE");
                        System.out.println("3. DISPLAY QUEUE");
                        System.out.println("4. EXIT");
                        System.out.print("Enter Choice [1..4]: ");
                        int choiceLinkedList = scan.nextInt();
                        switch (choiceLinkedList) {
                            case 1:
                                System.out.print("\nEnter a number to enqueue: ");
                                int number = scan.nextInt();
                                System.out.println();
                                linkedListQueue.enqueue(number);
                                break;
                            case 2:
                            	System.out.println();
                                linkedListQueue.dequeue();
                                break;
                            case 3:
                            	System.out.println();
                                linkedListQueue.displayQueue();
                                break;
                            case 4:
                                System.out.println("\nExiting Linked List Implementation...\n");
                                exitLinkedList = true;
                                break;
                            default:
                                System.out.println("\nPlease enter a valid option [1..4].");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nDeocariza Jr., Ramil, V.\nExiting the program...");
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease enter a valid option [1..3].\n");
                    break;
            }
        }
        scan.close();
    }
}
