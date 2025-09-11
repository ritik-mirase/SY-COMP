#include <iostream>
using namespace std;

int main(){
    int u[5], s1[3], s2[3];
    cout << "Enter All Number : ";
    for(int i = 0; i < 5; i++){
        cin >> u[i];
    }
    cout << "Enter Drama Club Number: ";
    for(int i = 0; i < 3; i++){
        cin >> s1[i];
    }    
    cout << "Enter Science Club Number: ";
    for(int i = 0; i < 3; i++){
        cin >> s2[i];
    }
        
        
    cout<<"Students in Both Club"<<endl;
    for(int i=0;i<3;i++)
       for(int j= 0;j<3;j++)
           if(s1[i]==s2[j])
              cout<<s1[i]<<endl;
              
   cout << "Only Drama Club"<<endl;
    for (int i = 0; i < 3; i++) {
        int flag= 0;
        for (int j = 0; j < 3; j++)
            if (s1[i] == s2[j])
                flag= 1;
        if (!flag)
            cout << s1[i];
    }
    cout << endl; 
    
    cout << "Only Science Club"<<endl;
    for (int i = 0; i < 3; i++) {
        int flag= 0;
        for (int j = 0; j < 3; j++)
            if (s1[i] == s2[j])
                flag= 1;
        if (!flag)
            cout << s2[i];
    }
    cout << endl;
    
    cout<<"NO CLUBS: "<<endl;
    for (int i=0;i<5;i++) {
        int flag=0;
        for(int j=0; j<3; j++)
            if(u[i] == s1[i] || u[i] ==s2[j])
               flag=1;
        if (!flag)
            cout << u[i];       
        
        }

}
