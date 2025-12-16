// Q39. Write a program to implement a priority queue.

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

// Structure to represent a priority queue
struct PriorityQueue {
    int data[MAX];
    int priority[MAX];
    int size;
};

// Initialize the priority queue
void initialize(struct PriorityQueue *pq) {
    pq->size = 0;
}

// Function to insert an element into the priority queue
void enqueue(struct PriorityQueue *pq, int value, int prio) {
    if (pq->size == MAX) {
        printf("Queue Overflow!\n");
        return;
    }

    int i = pq->size - 1;

    // Shift elements with lower priority (higher number) to make space
    while (i >= 0 && pq->priority[i] > prio) {
        pq->data[i + 1] = pq->data[i];
        pq->priority[i + 1] = pq->priority[i];
        i--;
    }

    pq->data[i + 1] = value;
    pq->priority[i + 1] = prio;
    pq->size++;
}

// Function to remove the element with highest priority
void dequeue(struct PriorityQueue *pq) {
    if (pq->size == 0) {
        printf("Queue Underflow!\n");
        return;
    }

    printf("Dequeued element: %d\n", pq->data[0]);

    // Shift elements to remove the first element
    for (int i = 0; i < pq->size - 1; i++) {
        pq->data[i] = pq->data[i + 1];
        pq->priority[i] = pq->priority[i + 1];
    }

    pq->size--;
}

// Function to display the priority queue
void display(struct PriorityQueue *pq) {
    if (pq->size == 0) {
        printf("Queue is empty\n");
        return;
    }

    printf("Element\tPriority\n");
    for (int i = 0; i < pq->size; i++) {
        printf("%d\t%d\n", pq->data[i], pq->priority[i]);
    }
}

// Main function
int main() {
    struct PriorityQueue pq;
    initialize(&pq);

    int choice, value, prio;

    while (1) {
        printf("\nPriority Queue Operations:\n");
        printf("1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                printf("Enter its priority: ");
                scanf("%d", &prio);
                enqueue(&pq, value, prio);
                break;
            case 2:
                dequeue(&pq);
                break;
            case 3:
                display(&pq);
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice!\n");
        }
    }
    return 0;
}