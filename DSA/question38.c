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

// void enque_front(int value) {
//     if()
// }

void enque_rear(int value) {
    if (rear == MAX - 1) {   // check overflow
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


int main(){
     

    return 0;
}