// Q27: Write a C program for Circular Doubly Linked List to insert at end, delete by value, and traverse in both directions.

#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Node* head = NULL;

void insertEnd(int value) {
    struct Node* newNode = (struct Node*) malloc (sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated.");
        return;
    }

    newNode->data = value;
    newNode->next = NULL;
    newNode->prev = NULL;

    if(head == NULL) {
        newNode->next = newNode;
        newNode->prev = newNode;
        head = newNode;
        printf("Node %d inserted as first node.\n", value);
        return;
    }
    struct Node* last = head->prev;
    last->next = newNode;
    newNode->prev = last;
    newNode->next = head;
    head->prev = newNode;
    printf("Node %d inserted as last node.\n", value);
}

void deleteNode(int value) {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    int flag = 0;
    struct Node* temp = head;
    do
    {
        if(temp->data == value) {
            flag = 1;
            break;
        }
        temp = temp->next;
    } while (temp != head);
    
    if(flag) {
        if(temp == head) {
            if(temp->next == head) {
                head = NULL;
                return;
            }
            head = head->next;

            temp->prev->next = head;
            head->prev = temp->prev;
        }
        else {
            temp->prev->next = temp->next;
            temp->next->prev = temp->prev;
        }
        printf("Node %d deleted.\n", value);
        free(temp);
    }
    else {
        printf("Node %d not found.\n", value);
    }
}

void traverseFW() {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    printf("Forward traversal: ");
    do{
        if(temp->next == head)
            printf("%d -> NULL\n", temp->data);
        else
            printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
     
}

void traverseBW() {
   if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    printf("Backward traversal: ");
    do{
        if(temp->prev == head)
            printf("%d -> NULL\n", temp->data);
        else
            printf("%d -> ", temp->data);
        temp = temp->prev;
    } while (temp != head);
}

int main(){
    insertEnd(23);
    insertEnd(2);
    insertEnd(237);
    insertEnd(28);
    deleteNode(23);
    traverseFW();
    traverseBW();
    return 0;
}