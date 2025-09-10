#include <iostream>
using namespace std;

class BankAccount {
private:
    string name;
    string accountType;
    int accountNumber;
    double balance;

public:
    BankAccount(string n, string t, int ano, double bal) {
        name = n;
        accountType = t;
        accountNumber = ano;
        balance = bal;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Amount deposited successfully\n";
        } else {
            cout << "Invalid deposit amount\n";
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            cout << "Amount withdrawn successfully\n";
        } else {
            cout << "Insufficient balance or invalid amount\n";
        }
    }

    void display() {
        cout << "\nAccount Details:\n";
        cout << "Name: " << name << endl;
        cout << "Account Type: " << accountType << endl;
        cout << "Account Number: " << accountNumber << endl;
        cout << "Available Balance: ₹" << balance << endl;
    }
};

int main() {
    BankAccount* bk = 0;
    int ch;
    do {
        cout << "Menu"<<endl;
        cout << "1. Fill The Information"<<endl;
        cout << "2. Deposit"<<endl;
        cout << "3. Withdraw"<<endl;
        cout << "4. Display"<<endl;
        cout << "5. Exit"<<endl;
        cout << "Enter Your Choice: "<<endl;
        cin >> ch;

        switch (ch) {
            case 1: {
                int n;
                string nm, t;
                double a;
                cout << "Enter Account Number: ";
                cin >> n;
                cout << "Enter Your Name: ";
                cin>>nm;
                cout << "Enter Your Account Type: ";
                cin>>t;
                cout << "Enter Your Balance: ";
                cin >> a;

                if (bk != 0) {
                    delete bk;
                }
                bk = new BankAccount(nm, t, n, a);
                cout << "Account created successfully"<<endl;
                break;
            }
            case 2: {
                if (bk == 0) {
                    cout << "Create an account first"<<endl;
                    break;
                }
                double depAmount;
                cout << "Enter deposit amount: "<<endl;
                cin >> depAmount;
                bk->deposit(depAmount);
                break;
            }
            case 3: {
                if (bk == 0) {
                    cout << "Create an account first"<<endl;
                    break;
                }
                double withAmount;
                cout << "Enter withdraw amount: "<<endl;
                cin >> withAmount;
                bk->withdraw(withAmount);
                break;
            }
            case 4: {
                if (bk == 0) {
                    cout << "Create an account first"<<endl;
                    break;
                }
                bk->display();
                break;
            }
            case 5:
                cout << "Exiting program"<<endl;
                break;
            default:
                cout << "Invalid choice! Try again"<<endl;
        }
    } while (ch != 5);

    return 0;
}
