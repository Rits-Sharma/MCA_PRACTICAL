// Q22: Write a C program to create a singly linked list with n nodes entered by the user and display its elements.

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
};

struct Node* head = NULL;


void insertNodeLast(int value) {
    struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated!");
        return;
    }
    newNode->data = value;
    newNode->next = NULL;

    if(head == NULL) {
        head = newNode;
    } else {
        struct Node* temp = head;
        while (temp->next != NULL){
            temp = temp->next;
        }
        temp->next = newNode;
    }

    printf("%d insserted at last.\n", value);
}

void displayNode() {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    while (temp != NULL){
        if(temp->next == NULL){
            printf("%d -> NULL", temp->data);
        } else {
        printf("%d -> ", temp->data);
        }
        temp = temp->next;
    }
}

int main() {
    int n;
    printf("Enter number of nodes : ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++){
        int value;
        printf("Enter value of node %d : ", i+1);
        scanf("%d", &value);
        insertNodeLast(value);
    }
    
    printf("\nLimked list dispaly : ");
    displayNode();

    return 0;
}