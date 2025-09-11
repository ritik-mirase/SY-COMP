#include<iostream>
#include<string>
using namespace std;

class staff {
	string name;
	string department;
	string address;
	int emp_id;
	
	public:
	void input() {
		cout<<"Enter Your Name: ";
		cin.ignore();
		getline(cin,name);
		cout<<"Enter Your Department: ";
		getline(cin,department);
		cout<<"Enter Your ID No.: ";
		cin>>emp_id;
		cin.ignore();
		cout<<"Enter Your Address: ";
		getline(cin,address);
	}
	void output(){
		cout<<"Name: "<<name<<endl;
		cout<<"ID: "<<emp_id<<endl;
		cout<<"Department: "<<department<<endl;
		cout<<"Address: "<<address<<endl;
	}
};

class student:public staff {
	int year;
	string branch;
	
	public:
	void input() {
		staff::input();
		cout<<"Enter Your Year: ";
		cin>>year;
		cin.ignore();
		cout<<"Enter Your Branch: ";
		getline(cin,branch);
	}
	void output() {
		staff::output();
		cout<<"YEAR:"<<year<<endl;
		cout<<"BRANCH:"<<branch<<endl;
	}
};

int main() {
	
	int choice;
	
	cout<<"1. Staff"<<endl;
	cout<<"2. Student"<<endl;
	cout<<"Enter Your Choice: ";
	cin>>choice;
	
	if(choice==1){
		
	staff obj;
	obj.input();
	cout<<endl;
	obj.output();
}
else if(choice==2){
	
	student obj2;
	obj2.input();
	cout<<endl;
	obj2.output();
}
else{
	cout<<endl;
	cout<<"Invalid Choice";
}
	return 0;
}
