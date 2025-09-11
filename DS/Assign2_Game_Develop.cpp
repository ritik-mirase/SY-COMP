#include <iostream>
using namespace std;
int main(){
	int n;

cout<<"How Many Players"<<endl;
cin>>n;
cout<<"Scores of Players: "<<n<<endl;
int player[n];
for(int i=0;i<n;i++){
	cin>>player[i];
}
cout<<"Entered Scores"<<endl;
for(int i=0;i<n;i++){

	cout<<player[i]<<endl;
}
for(int i=0;i<n-1;i++){
	for(int j=0;j<n-1;j++){
		if(player[j]>player[j+1]){
			int temp;
			temp=player[j];
			player[j]=player[j+1];
			player[j+1] = temp;}}}
			
			
cout<<"After Sorting"<<endl;
for(int i=0;i<n;i++){
	cout<<player[i]<<endl;
	}
	return 0;
}
