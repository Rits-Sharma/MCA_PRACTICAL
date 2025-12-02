// Q25: Write a C program to implement singly linked list in one program.

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

void insertNodeFirst(int value) {
    struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated!");
        return;
    }
    newNode->data = value;
    newNode->next = head;
    head = newNode;
    printf("%d inserted at start.\n", value);
    
}

void displayNode() {
    if(head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    while (temp != NULL){
        if(temp->next == NULL){
            printf("%d -> NULL\n", temp->data);
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
        printf("Node with %d value deleted.\n", value);
    } else {
        printf("%d not found in linked list.\n",value);
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
        printf("\n%d found\n", value);
    else
        printf("\n%d not found\n", value);
}

int main() {
    int value;
    int choice;
    do
    {
        printf("1.Display Linked List\n");
        printf("2.Insert first Node\n");
        printf("3.Insert last Node\n");
        printf("4.Delete Node\n");
        printf("5.Search Node\n");
        printf("0. Exit.\n");
        printf("\nEnter number of choice : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            displayNode();
            break;
        case 2:
            printf("\nEnter value of node at first: ");
            scanf("%d", &value);
            insertNodeFirst(value);
            break;
        case 3:
            printf("\nEnter value of node at last: ");
            scanf("%d", &value);
            insertNodeLast(value);
            break;
        case 4:
            printf("\nEnter value of node you want to delete : ");
            scanf("%d",&value);
            deleteNode(value);
            break;
        case 5:
            printf("\nEnter value of node you want to search : ");
            scanf("%d",&value);
            searchNode(value);
            break;
        
        case 0:
            return 0;
        
        default:
            printf("Invalid choice...\n");
            break;
        }
    } while (choice != 0);

    return 0;
}