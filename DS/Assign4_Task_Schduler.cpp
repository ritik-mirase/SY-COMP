#include <iostream>
#include <string>
using namespace std;

class Node {
public:
	string name;
	int priority;
	int execution_time;
	Node* next;

	Node(string name, int priority, int execution_time) {
    	this->name = name;
    	this->priority = priority;
    	this->execution_time = execution_time;
    	this->next = nullptr;
	}
};

// Insert task in descending order of priority
void input_Task(Node*& head, Node* newTask) {
	if (head == nullptr || newTask->priority > head->priority) {
    	newTask->next = head;
    	head = newTask;
    	return;
	}

	Node* current = head;
	while (current->next != nullptr && current->next->priority >= newTask->priority) {
    	current = current->next;
	}
	newTask->next = current->next;
	current->next = newTask;
}

// Display all tasks
void display_task(Node* head) {
	cout << "\nExecution Tasks:\n";
	Node* temp = head;
	while (temp != nullptr) {
    	cout << "Task name: " << temp->name
         	<< " [Priority: " << temp->priority << "] "
         	<< "Execution Time: " << temp->execution_time << " ms\n";
    	temp = temp->next;
	}
}

// Execute tasks
void execute_task(Node* head) {
	cout << "\nExecuting Tasks:\n";
	Node* temp = head;
	while (temp != nullptr) {
    	cout << "Executing Task '" << temp->name
         	<< "' [Priority: " << temp->priority
         	<< "] for " << temp->execution_time << " ms...\n";
    	temp = temp->next;
	}
	cout << "All tasks executed.\n";
}

int main() {
	int n;
	cout << "Enter number of tasks to schedule: ";
	cin >> n;

	Node* head = nullptr;

	for (int i = 0; i < n; i++) {
    	string name;
    	int priority;
    	int execution_time;

    	cout << "\nTask " << i + 1 << " Name: ";
    	cin >> name;
    	cout << "Priority: ";
    	cin >> priority;
    	cout << "Execution Time: ";
    	cin >> execution_time;

    	Node* newTask = new Node(name, priority, execution_time);
    	input_Task(head, newTask);
	}

	display_task(head);
	execute_task(head);

	return 0;
}
