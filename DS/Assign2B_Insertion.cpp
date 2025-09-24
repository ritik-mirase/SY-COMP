#include<iostream>
using namespace std;

int main () {

	int cards[20], original[20];
	int size;
	cout<<"Enter number of cards: ";
	cin>>size;
	cout<<"Enter"<<size<<"size values:\n";
	for(int i=0;i<size;i++){
		cin>>cards[i];
		original[i]=cards[i];
	}
	for(int i=1;i<size;i++){
		int key=cards[i];
		int j=i-1;
		while(j>=0&&cards[j]>key){
			cards[j+1]=cards[j];
			j--;
		}
		cards[j+1]=key;
		cout<<"After Step"<<i<<" ";
		for(int k=0;k<size;k++){
			cout<<cards[k]<<" ";
		}
		cout<<endl;
	}
	cout<<"\nOriginal Hand: ";
	for(int i=0;i<size;i++){
		cout<<original[i]<<" ";
	}
	cout<<endl;
	cout<<"Sorted hand: ";
	for(int i=0;i<size;i++){
		cout<<cards[i]<<" ";
	}
	cout<<endl;
	return 0;
}
