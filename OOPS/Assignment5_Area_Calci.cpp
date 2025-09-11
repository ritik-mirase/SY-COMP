#include<iostream>
using namespace std;

class Shape {
public:
    float area;
    float a, b;
    virtual void computeArea() = 0; 
};

class Triangle : public Shape {
public:
    Triangle(float base, float height) {
        a = base;
        b = height;
    }

    void computeArea() {
        area = 0.5 * a * b;  
    }

    void display() {
        cout << "Area of the Triangle is: " << area << endl;
    }
};

class Rectangle : public Shape {
public:
    Rectangle(float width, float length) {
        a = width;
        b = length;
    }

    void computeArea() {
        area = a * b;  
    }

    void display() {
        cout << "Area of the Rectangle is: " << area << endl;
    }
};

int main() {
    cout << "Enter your choice for Area" << endl;
    cout << "1 for Triangle" << endl;
    cout << "2 for Rectangle" << endl;
    int choice;
    cin >> choice;

    if (choice == 1) {
        cout << "Enter base and height for Triangle" << endl;
        float base, height;
        cin >> base >> height;
        Triangle T(base, height);
        T.computeArea();
        T.display();
    } else if (choice == 2) {
        cout << "Enter width and length for Rectangle" << endl;
        float width, length;
        cin >> width >> length;
        Rectangle R(width, length);
        R.computeArea();
        R.display();
    } else {
        cout << "Invalid choice!" << endl;
    }

    return 0;
}
