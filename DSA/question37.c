// Q37. Write a program to implement a queue using linked list.

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *front = NULL, *rear = NULL;

void enqueue(int value) {
    struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated.\n");
        return;
    }
    newNode->data = value;
    newNode->next = NULL;
    if(front == NULL && rear == NULL) {
        front = rear = newNode;
    }
    else {
        rear->next = newNode;
        rear = newNode;
    }
    printf("%d inserted into queue.\n", value);
}

void deque() {
    if(front == NULL) {
        printf("Queue is empty.\n");
        return;
    }
    printf("%d deleted from queue.\n", front->data);
    struct Node* temp = front;
    front = front->next;
    if(front == NULL) rear = NULL;
    free(temp);
}

void display() {
    if(front == NULL) {
        printf("Queue is empty.\n");
        return;
    }
    struct Node* temp = front;
    printf("Display elements: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main(){
    enqueue(56);
    enqueue(6);
    enqueue(-26);
    enqueue(23);
    enqueue(85);
    deque();
    display();

    return 0;
}