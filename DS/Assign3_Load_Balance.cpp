#include<iostream>
using namespace std;

int main () {
	int a, b, val;
	cout<<"Enter the Number of Server: ";
	cin>>a;
	cout<<"Enter the Number of Requests: ";
	cin>>b;
	
	int hash_server[a]={};
	int hash_value;
	
	for(int i=0;i<b;i++){
		cin>>val;
		hash_value = val%a;
		if(hash_server[hash_value]=='\0'){
			hash_server[hash_value]=val;
		}
		else{
			for( int i=0;i<a-1;i++){
				hash_value=hash_value+1;
				hash_server[hash_value]=val;
			}
			if(hash_server[hash_value]=='\0'){
					hash_server[hash_value]=val;
					}
			else
			continue;
		}
	}
	for(int i=0;i<a;i++){
		cout<<hash_server[i]<<endl;
	}
	
	return 0;
}
