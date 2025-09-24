#include<iostream>
#include<string>
using namespace std;

class node{
public:
string name;
node* next;
};
node* front = nullptr;
node* rear = nullptr;

int i = 0;

void newq(){
node* newnode = new node();
cout<<"Enter Customer Name: ";
cin>>newnode->name;
cout<<newnode->name<<" Joined the Queue!\n";
newnode->next = nullptr;
if(rear == nullptr){
front = newnode;
rear = newnode;
}
else{
rear->next = newnode;
rear = newnode;
}
}

void del(){
if(front == nullptr){
cout<<"No customer in Queue!";
}
else{
node* temp = front;
cout<<temp->name<<"'s order is ready. They leave the line.\n";
front = front->next;
if(front == nullptr){
rear = front;
}
delete temp;
}
}

void display(){
if(front == nullptr){
cout<<"Queue is empty!";
}
else{
node* temp = front;
cout<<"Current Line: ";
while(temp != nullptr){
cout<<temp->name;
cout<<" -> ";
temp = temp->next;
}
cout<<"\n";
}
}

int main(){
start:
int ch;
cout<<"Welcome to Coffee Shop!\n1.New Customer Arival\n2.Serve Customer\n3.Show Queue\n4.Exit\nEnter Your Choice: ";
cin>>ch;
cout<<endl;
if(ch == 1){
newq();
goto start;
}
else if(ch == 2){
del();
goto start;
}
else if(ch == 3){
display();
goto start;
}
else if(ch == 4){
}
else{
cout<<"Invalid Input!";
goto start;
}

return 0;
}
