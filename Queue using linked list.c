#include <stdio.h>
#include <stdlib.h>

struct node
{
int data;
struct node *link;
}*front, *rear;

int main()
{
int ch;
printf ("Linked List Implementation of Queues\n\n");
do
{
printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n\n");
printf("Enter your choice:");
scanf("%d",&ch);

switch(ch)
{
case 1:insert();
       break;
       
case 2:delete();
       break;

case 3:display();
       break;

case 4:exit(0);
       break;

default:printf("Invalid choice!\n");
        break;
}
} while(ch!=4);

return 0;
}

void insert()  //Function to insert the element in the queue
{
struct node *tmp;

tmp = (struct node*)malloc(sizeof(struct node));
printf("Enter the element to be inserted in the queue: ");
scanf("%d", &tmp->data);
tmp->link = NULL;
if (rear == NULL)
{
front = rear = tmp;
}
else
{
rear->link = tmp;
rear = tmp;
}
}

void delete()     //Function to delete the element in the queue
{
struct node *tmp;
tmp = front;
if (front == NULL)
{
printf("Queue underflow\n");
front = rear = NULL;
}
else
{
printf("The deleted element from the queue is: %d\n", front->data);
front = front->link;
free(tmp);
}
}

void display()        //Function to display the element in the queue according to FIFO rule
{
struct node *tmp;
tmp = front;
int c = 0;
if (front == NULL)
{
printf("Empty queue\n");
}
else
{
printf("The elements of the queue are:\n");
while (tmp)
{
printf("%d\n", tmp->data);
tmp = tmp->link;
c++;
}
}
}



