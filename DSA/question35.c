// Q35. Write a program to count the total number of elements in a queue.

#include<stdio.h>

#define MAX 5

int queue[MAX];
int front = -1, rear = -1;

int isEmpty() {
    return (front == -1 || front > rear);
}

int isFull() {
    return (rear==MAX-1);
}

void enque(int value) {
    if (isFull()) {
        printf("Queue is full.\n");
        return;
    }

    if (front == -1)
        front = 0;

    queue[++rear] = value;
    printf("%d inserted in queue.\n", value);
}

int dequeue() {
    if (isEmpty()) {
        printf("Queue is empty. Deletion not performed.\n");
        return -1;
    }

    int n = queue[front++];
    printf("%d dequeued from queue.\n", n);
    if (front > rear) {   // queue becomes empty
        front = rear = -1;
    }
    
    return n;
}

int count() {
    int count = 0;
    if(isEmpty()) {
        printf("Queue is empty.\n");
        return 0;
    }
    for (int i = front; i <= rear; i++) {
        count++;
    }
    return count;
}

void display() {
    if (isEmpty()) {
        printf("Queue is empty.\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = front; i <= rear; i++){
        printf("%d ",queue[i]);
    }
}

int main(){
    int n;
    do
    {
        int val;
        printf("\nQueue operations...\n");
        printf("1. EnQueue operations\n");
        printf("2. DeQueue operations\n");
        printf("3. Display Queue operations\n");
        printf("4. No. of elements in queue\n");
        printf("0. Exit Queue operations\n");
        printf("Enter the number to do operations: ");
        scanf("%d", &n);
        switch (n){
            case 1:
                printf("Enter the value to enter in queue: ");
                scanf("%d",&val);
                enque(val);
                break;
            
            case 2:
                dequeue();
                break;
            
            case 3:
                display();
                break;

            case 4:
                printf("No. of elements: %d.\n", count());
                break;

            case 0:
                return 0;
            default:
                break;
        }
    } while (n != 0);
    return 0;
}