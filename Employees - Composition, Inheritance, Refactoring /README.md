## Summary 

This assignment involves implementing an Employee class that represents both hourly and salaried employees, and a Paycheck class that calculates employee pay for a pay period. Employees are differentiated based on their pay rate (hourly or yearly) and their pay interval. The Paycheck class implements the IPaycheck protocol and has two concrete implementations: HourlyPaycheck and SalariedPaycheck.

The Employee class is implemented with two constructors: one for salaried employees and another for hourly employees. The Employee class has a method to return a Paycheck instance and a method to indicate if the employee is a manager. The Paycheck class implements the IPaycheck protocol, with methods to return the total pay, pay after taxes, and pay rate.

There are also two concrete Paycheck classes: HourlyPaycheck and SalariedPaycheck. HourlyPaycheck has additional features, such as the ability to add or reset hours worked and return the number of hours an employee worked for the current paycheck. The Paycheck classes should have suitable toString() methods to represent the employee's name, ID, and payment after taxes.

Overall, this assignment provides practice with composition, delegation, and inheritance, as well as working with interfaces and implementing different classes to represent different types of employees and paychecks.
