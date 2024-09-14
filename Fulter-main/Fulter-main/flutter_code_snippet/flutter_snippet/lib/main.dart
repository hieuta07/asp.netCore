import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'OOP Example - Employee',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
        useMaterial3: true,
      ),
      home: const MyHomePage(),
    );
  }
}

// Tạo lớp Employee
class Employee {
  String name;
  int id;
  String department;

  Employee(this.name, this.id, this.department);

  void displayInfo() {
    print('Name: $name, ID: $id, Department: $department');
  }
}

// Tạo lớp con Manager kế thừa từ Employee
class Manager extends Employee {
  int teamSize;

  Manager(String name, int id, String department, this.teamSize)
      : super(name, id, department);

  @override
  void displayInfo() {
    print('Name: $name, ID: $id, Department: $department, Team Size: $teamSize');
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    // Tạo đối tượng Employee và Manager
    Employee employee = Employee("John Doe", 101, "Sales");
    Manager manager = Manager("Alice Smith", 201, "Marketing", 100);

    // Gọi phương thức displayInfo
    employee.displayInfo();
    manager.displayInfo();

    return Scaffold(
      appBar: AppBar(
        title: const Text('OOP Example - Employee'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Employee and Manager Information:',
              style: TextStyle(fontSize: 20),
            ),
            Text(
              'Employee: Name - ${employee.name}, ID - ${employee.id}, Dept - ${employee.department}',
              style: const TextStyle(fontSize: 16),
            ),
            Text(
              'Manager: Name - ${manager.name}, ID - ${manager.id}, Dept - ${manager.department}, Team Size - ${manager.teamSize}',
              style: const TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}
