// Q38. Write a program to implement a double-ended queue (deque) using an array.

#include<stdio.h>

#define MAX 5

int queue[MAX];
int front = -1, rear = -1;

int isEmpty() {
    return (front == -1);
}

int isFull() {
    return (rear == MAX-1);
}

void enque_rear(int value) {
    if (isFull()) {   // check overflow
        printf("Queue overflow at rear!\n");
        return;
    }
    if (front == -1 && rear == -1) {  // empty queue
        front = 0;
        rear = 0;
    } else {
        rear++;
    }
    queue[rear] = value;
    printf("%d inserted at rear.\n", value);
}

void enque_front(int value) {
    if(front == 0) {
        printf("%d can't be inserted in front.");
        return;
    }
    if(front == -1) {
        front = 0; rear = 0;
        queue[front] = value;
    } else if(front > 0) queue[--front] = value;
    printf("%d inserted at front.\n", value);
}

int deque_front() {
    if(isEmpty()) {
        printf("Queue is empty>\n");
        return -1;
    }
    int x = queue[front++];
    if(front > rear) {
        front = rear = -1;
    }
    return x;
}

int deque_rear() {
    if(rear == -1) {
        printf("Queue is empty.\n");
        return -11111;
    }
    int n = queue[rear];
    if(rear == front) {
        front = rear = -1;
    } else {
        rear--;
    }
    return n;
}

void display() {
    if(front == -1) {
        printf("Queue is empty.\n");
        return;
    }
    printf("\nQueue Elements: ");
    for (int i = front; i <= rear; i++)
        printf("%d ", queue[i]);
}

int main(){
    enque_front(12);
    enque_rear(13);
    deque_front();
    enque_rear(14);
    enque_rear(15);
    deque_rear();
    enque_front(25);
    enque_front(25);
    display();

    return 0;
}