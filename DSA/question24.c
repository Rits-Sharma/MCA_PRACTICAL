// Q24: Write a C program to create a singly linked list dynamically from user input and perform traversal of a given node.

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

void deleteNode(int value) {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    struct Node* prev = NULL;
    int f = 0;
    while (temp != NULL) {
        if(temp->data == value) {
            f = 1;
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    if (f) {
        if(prev == NULL) {
            head = temp->next;
        } 
        else {
            prev->next = temp->next;
        }
        free(temp);
        printf("Node with %d value deleted.", value);
    } else {
        printf("%d not found in linked list.",value);
    }
}

void searchNode(int value) {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    int flag = 0;
    struct Node* temp = head;
    while(temp != NULL) {
        if(temp->data == value) {
            flag = 1;
            break;
        }
        temp = temp->next;
    }
    if(flag)
        printf("\n%d found", value);
    else
        printf("\n%d not found", value);
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
    
    printf("Enter value of node you want to delete : ");
    scanf("%d",&n);
    deleteNode(n);

    printf("\nLimked list dispaly : ");
    displayNode();
    printf("\nEnter value of node you want to search : ");
    scanf("%d",&n);
    searchNode(n);

    return 0;
}