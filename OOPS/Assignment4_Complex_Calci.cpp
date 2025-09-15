#include<iostream>
using namespace std;

class complex {
	public:
	float real,img;

	complex() {

	real=0;
	img=0;
	}
	void get(){
	cout<<"Enter real no:";
	cin>>real;
	cout<<"Enter imaginary no:";
	cin>>img;
	}
		void display() {
			cout<<real<<"+"<<img<<"i"<<endl;
			}
		complex operator+(complex);
		complex operator-(complex);
		complex operator*(complex);
		
		
		friend ostream &operator<<(ostream &,complex &);
		friend istream &operator>>(istream &,complex &);
};

complex complex::operator+(complex obj) {
	complex temp;
	temp.real=this->real+obj.real;
	temp.img=this->img+obj.img;
	return temp;
}

complex complex::operator-(complex obj) {
	complex temp;
	temp.real=this->real-obj.real;
	temp.img=this->img-obj.img;
	return temp;
}

complex complex::operator*(complex obj){
	complex temp;
	temp.real=( this->real*obj.real)-(this->img*obj.real);
	temp.img=( this->real*obj.img)+(this->img*obj.img);
	return temp;
}


ostream &operator<<(ostream &out,complex &obj){
	out<<obj.real<<"+"<<obj.img<<"i"<<endl;
	return out;
}
	
istream &operator>>(istream &in,complex &obj){
	cout<<"Enter Real No.";
	in>>obj.real;
	cout<<"Enter Img No."<<endl;
	in>>obj.img;
	return in;
}

int main () {
	complex C1,C2,C3,C4,C5,C6;
	C1.get();
	C2.get();
	C3=C1+C2;
	C4=C1-C2;
	C5=C1*C2;
	
//Result
	cout<<"\nC1 = ";
	C1.display();
	cout<<"C2 = ";
	C2.display();
	cout<<"C3 = ";
	C3.display();
	cout<<"C4 = ";
	C4.display();
	cout<<"C5 = ";
	C5.display();
	
	//Using Operator Overloading << and >>;
	cin>>C6;
	cout<<C6;
	return 0;	
	
}
