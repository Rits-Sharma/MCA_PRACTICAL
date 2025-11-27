// Q40. Write a program to implement basic operations (creation, insertion, traversals — preorder, inorder, postorder — and counting nodes) on a Binary Tree.

#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* root = NULL;

struct Node *createNode(int value) {
    struct Node *newNode = (struct Node*) malloc(sizeof(struct Node));
    if(newNode == NULL) {
        printf("Memory not allocated.\n");
        exit(0);
    }
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* insertNode(struct Node* root, int value) {
    if(root == NULL) {
        return createNode(value);
    }
    int choice;
    printf("Enter %d to left(1) or right(2) to %d : ", value, root->data);
    scanf("%d", &choice);

    if(choice == 1) {
        root->left = insertNode(root->left, value);
    } else {
        root->right = insertNode(root->right, value);
    }
    return root;
}

void preOrder(struct Node* root) {
    if(root == NULL) {
        printf("Tree is empty.\n");
        return;
    }
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
}

void inOrder(struct Node* root) {
    if(root == NULL) {
        printf("Tree is empty.\n");
        return;
    }
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

void postOrder(struct Node* root) {
    if(root == NULL) {
        printf("Tree is empty.\n");
        return;
    }
    postOrder(root->left);
    postOrder(root->right);
    printf("%d ", root->data);
}

int countNodes(struct Node* root) {
    if (root == NULL)
    return 0;
    return 1 + countNodes(root->left) + countNodes(root->right);
}

int main(){
    // root = insertNode(root, 45);
    // root = insertNode(root, 55);
    // root = insertNode(root, 65);
    // root = insertNode(root, 4);
    // preOrder(root);
    // printf("\n");
    // postOrder(root);
    
    int n;
    do{
        printf("Tree operations...\n");
        printf("1. Insert Node in tree.\n");
        printf("2. Inorder Traversals.\n");
        printf("3. Preorder Traversals.\n");
        printf("4. Postorder Traversals.\n");
        printf("5. Count Nodes.\n");
        printf("0. Exit.\n");

        printf("Enter a number to perform operations : ");
        scanf("%d", &n);
        int val;
        switch (n)
        {
        case 1:
            printf("Enter the value to insert in node: ");
            scanf("%d", &val);
            root = insertNode(root, val);
            break;
        case 2:
            printf("Inorder traversals : ");
            inOrder(root);
            printf("\n");
            break;
        case 3:
            printf("Preorder traversals : ");
            preOrder(root);
            printf("\n");
            break;
        case 4:
            printf("Postorder traversals : ");
            postOrder(root);
            printf("\n");
            break;
        case 5:
            printf("Total number of nodes in tree: %d\n", countNodes(root));
            break;
        case 0:
            return 0;
        
        default:
            break;
        }
    } while (n!=0);
    
    return 0;
}