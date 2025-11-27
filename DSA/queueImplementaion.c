// Q34. Write a program to implement a simple queue using an array with operations enqueue, dequeue, and display.
// Q35. Write a program to count the total number of elements in a queue.

#include<stdio.h>

#define MAX 10

int queue[MAX];
int front = -1;
int rear = -1;

void enqueue(int n) {
    if(rear == MAX-1) {
        printf("Queue is full\n");
        return;
    }
    if(front == -1) {
        front = 0;
    }
    queue[++rear] = n;
}

int deque() {
    int n;
    if(front == -1) {
        printf("Queue is empty.\n");
        return -1;
    }
    n =  queue[front];
    if (front == rear)
    {
        front = rear = -1;
    }
    else {
        front++;
    }
    return n;
}

void display() {
    if(front == -1) {
        printf("Queue is empty.\n");
        return;
    }
    for (int i = front; i <= rear; i++)
    {
        printf("%d  ", queue[i]);
    }  
}

int count() {
    if(front == -1) {
        return 0;
    }
    return (rear - front + 1);
}


int main(){
    printf("Queue implementation\n");
    enqueue(23);
    enqueue(23);
    enqueue(23);
    enqueue(23);
    enqueue(23);
    enqueue(23);
    enqueue(23);
    deque();
    display();
    printf("\nNo. of elements : %d\n",count());
    return 0;
}