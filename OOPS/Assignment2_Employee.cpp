#include<iostream>
#include<string>

using namespace std;

	class employee{
		string name,department,date_join,address;
		int empID;
		long long contact;
		
	public:
		employee(string n,string dep,string date_join,string add,int id,long long cont){
			name=n;
			department=dep;
			doj=doj;
			address=add;
			empID=id;
			contact=cont;
		}
		
		employee(){}
		
		void getdata(void);
		void putdata(void);
	};
	
	void employee::getdata(void){
		cout<<"Enter Name: ";
		cin>>name;
		
		cout<<"Enter Department: ";
		cin>>department;
		
		cout<<"Enter Date Of Joining: ";
		cin>>date_join;
		
		cout<<"Enter Address: ";
		cin>>address;
		
		cout<<"Enter Employee ID: ";
		cin>>empID;
		
		cout<<"Enter phone number: ";
		cin>>contact;
	}
	
	void employee::putdata(void){
		cout<<"Employee name: "<<name<<endl;
		cout<<"Department: "<<department<<endl;
		cout<<"Date of joining: "<<date_join<<endl;
		cout<<"Employee Address: "<<address<<endl;
		cout<<"Employee ID: "<<empID<<endl;
		cout<<"Phone Number: "<<contact<<endl;
	}
	
	int  main(){
		int size;
		cout<<"Enter number of employees: ";
		cin>>size;
		
		employee off[size];
		
		for(int i=0;i<size;i++){
			cout<<"\nEnter the Employee Information: "<<i+1<<endl;
			off[i].getdata();
		}
		
		cout<<"\nEmployee information:  "<<endl;
		
		for(int i=0;i<size;i++){
			cout<<"\nDatails of the Employee:  "<<i+1<<endl;
			off[i].putdata();
		}
		
		return 0;
	}
