## Summary 

This project involves implementing an Employee class and a Paycheck class to calculate employee pay for a pay period. The Employee class represents both hourly and salaried employees, differentiated by their pay rate and interval. The Paycheck class calculates the total pay, pay after taxes, and pay rate, and implements the IPaycheck protocol with two concrete implementations: HourlyPaycheck and SalariedPaycheck.

The Employee class has two constructors and methods to return a Paycheck instance and indicate if the employee is a manager. The Paycheck classes have suitable toString() methods and the HourlyPaycheck has additional features such as adding or resetting hours worked and returning the number of hours an employee worked for the current paycheck.

This project provides practice with composition, delegation, and inheritance, as well as working with interfaces and implementing different classes to represent different types of employees and paychecks.
