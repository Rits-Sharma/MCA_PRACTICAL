// Q36. Write a program to implement a circular queue.

#include<stdio.h>

#define size 5

int queue[size];
int front = -1, rear = -1;

void enque(int value) {
    if((front == 0 && rear == size-1) || rear+1 == front) {
        printf("Queue is full.\n");
        return;
    }
    if(front == -1) {
        front = 0;
    }
    rear = (rear+1) % size;
    queue[rear] = value;
    printf("%d enqueued in queue.\n", value);
}

int deque() {
    if(front == -1) {
        printf("Queue is empty.\n");
        return -1;
    }
    int n = queue[front];
    printf("%d deleted from queue.\n", n);
    if(front == rear) {
        front = rear = -1;
    } else {
        front = (front+1) % size;
    }
    return n;
}

void display() {
    if(front == -1) {
        printf("Queue is empty.\n");
        return;
    }
    printf("Circular queue elements: ");
    for(int i = front; i <= rear; i++) {
        printf("%d ", queue[i]);
    }
    printf("\n");
}

int main(){
    enque(34);
    enque(34);
    enque(44);
    enque(4);
    display();
    deque();
    display();
    deque();
    display();

    return 0;
}