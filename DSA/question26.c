// Q26: Write a C program to implement a doubly linked list with insertion, deletion, and traversal operations.

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Node* head;

void insertFirstNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not alloacated.\n");
        return;
    }
    newNode->data = value;
    newNode->prev = NULL;
    newNode->next = NULL;
    if (head==NULL) {
        head = newNode;
    } else {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
    }
    printf("%d inserted at first.\n", value);
}

void insertLastNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not alloacated.\n");
        return;
    }
    newNode->data = value;
    newNode->next = NULL;
    newNode->prev = NULL;
    if(head == NULL) {
        head = newNode;
    }
    else{
        struct Node* temp = head;
        while (temp->next != NULL){
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->prev = temp;
    }
    printf("%d inserted at last.\n", value);
}

void displayNode() {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    printf("Forward Traversal\n");
    while (temp != NULL) {
        if(temp->next == NULL){
            printf("%d -> NULL\n",temp->data);
            break;
        }
        printf("%d -> ",temp->data);
        temp = temp->next;
    }
    printf("Backward Traversal\n");
    do
    {
        if (temp!=NULL) {
            if (temp->prev==NULL) {
                printf("%d -> NULL", temp->data);
            } else {
                printf("%d -> ", temp->data);
            }
        }
        temp = temp->prev;
    } while (temp!=NULL);
    
}

void deleteNode(int value) {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    int flag = 0;
    struct Node* temp = head;
    while(temp != NULL) {
        if(temp->data == value){
            flag = 1;
            break;
        }
        temp = temp->next;
    }
    if(flag) {
        if(temp == head){
            if(temp->next == NULL) {
                head = NULL;
            }
            else {
                head = temp->next;
                head->prev = NULL;
            }
            // free(temp);
        }
        else {
            temp->prev->next = temp->next;
            temp->next->prev = temp->prev;
        }
        free(temp);
        printf("%d deleted from list.\n", value);
    }
    else {
        printf("%d not found in list.\n", value);
    }
}

int main(){

    insertFirstNode(34);
    insertFirstNode(34);
    insertFirstNode(3);
    insertLastNode(45);
    insertLastNode(45);
    insertLastNode(4);
    deleteNode(45);
    displayNode();
    // deleteNode(3);
    deleteNode(34);
    
    displayNode();
    return 0;
}