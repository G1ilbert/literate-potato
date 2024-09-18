#include <stdio.h>
#include <stdlib.h>


struct Treenode {
 int data;
 struct Treenode *leftChild,*rightChild;
 struct Treenode *mother;
};
struct Treenode *Root = NULL;

struct Treenode* createNode(int data)
{
    struct Treenode *new_node;
    new_node= (struct Treenode*) malloc(sizeof(struct Treenode));
    new_node->data =data;
    new_node->leftChild =NULL;
    new_node->rightChild=NULL;
    new_node->mother=NULL;
    return new_node;
}

void Tree_insert(int data)
{
    struct Treenode *nn = createNode(data);
    struct Treenode *y = NULL;
    struct Treenode *t = Root;
    while(t != NULL)
    {
        y = t;
        if(data < t->data)
            t = t->leftChild;
        else
            t = t->rightChild;
    }
    if(y == NULL)
        Root = nn;
    else
    {
        nn->mother = y;
        if(nn->data < y->data)
            y->leftChild = nn;
        else
            y->rightChild = nn;
    }
}

void Inorder(struct Treenode *root)
{
    if (root == NULL) {
        return;
    }
    Inorder(root->leftChild);
    printf("%c", root->data);
    Inorder(root->rightChild);
}
void Postorder(struct Treenode *root)
{
    if(root == NULL)
        return;
    Postorder(root->leftChild);
    Postorder(root->rightChild);
    printf("%c", root->data);
}
void Preorder(struct Treenode *root)
{
    if(root == NULL)
        return;
    printf("%c", root->data);
    Postorder(root->leftChild);
    Postorder(root->rightChild);

}

struct Treenode* Tree_Find(struct Treenode *Root ,int key)
{
    struct Treenode *t = Root;
    while(t != NULL)
    {
        if(t->data == key)
            return t;
        if(t->data < key)
            t = t->rightChild;
        else
            t = t->leftChild;
    }
    return NULL;
}

struct Treenode* FindMin(struct Treenode *Root)
{
    struct Treenode *ptr = Root;
    while(ptr && ptr->leftChild != NULL)
    {
        ptr = ptr->leftChild;
    }
    return ptr;
}

struct Treenode* FindMax(struct Treenode *Root)
{
    struct Treenode *ptr = Root;
    while(ptr && ptr->rightChild != NULL)
    {
        ptr = ptr->rightChild;
    }
    return ptr;
}

void Tree_delete(struct Treenode *root,int data)
{
    struct Treenode *x,*y;
    x = Tree_Find(root,data);
    if(x==NULL)
        printf("value is not found in the three\n");
    else
    {
        if(x->leftChild != NULL && x->rightChild != NULL)
        {
            y = FindMax(x->leftChild);
            x->data = y->data;
            Tree_delete(x->leftChild,y->data);
        }
        else if(x->leftChild == NULL && x->rightChild == NULL)
        {
            if (x->mother != NULL)
            {
                if (x->mother->leftChild == x)
                    x->mother->leftChild = NULL;
                else
                    x->mother->rightChild = NULL;
            }
            free(x);

        }
        else {
            struct Treenode  *child = (x->leftChild != NULL) ? x->leftChild : x->rightChild;
            child->mother = x->mother;

            if (x->mother != NULL) {
                if (x->mother->leftChild == x) {
                    x->mother->leftChild = child;
                } else {
                    x->mother->rightChild = child;
                }
            }


            free(x);
        }
    }
}



int main()
{
  char text[100]={};
  scanf("%s",text);

  for(int i=0;text[i] != '\0';i++)
        Tree_insert(text[i]);


   Preorder(Root);
}
