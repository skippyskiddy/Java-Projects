## Summary

This project builds the assets for a vehicle registration system MVP. It includes implementing concepts such as singletons, association classes, factories, Java collections (Sets), and abstraction.

The registration system has three types of vehicles: motorcycles, automobiles, and boats. The IVehicle interface is to be implemented by the students, and concrete classes must be created for any vehicle required. Besides, the IRegistration interface is provided for registering vehicles in a particular jurisdiction with owners. Students are also required to implement a Jurisdiction interface with an exciseTax() method that determines the tax to be levied based on the type of vehicle and jurisdiction.

The RegistrationSystem is the main class in this project, and it is a Singleton that contains six methods: getInstance(), createVehicle(), register(), getAllRegistrations(), getFilteredList(), and reboot(). The createVehicle() method creates a new instance of a vehicle, while the register() method adds a new registration to the system. The reboot() method resets the system, while the getAllRegistrations() method returns an unmodifiable list of all registrations currently managed by the system. The getFilteredList() method takes a Predicate and returns a sublist filtered based on the query.

The takeaway from this assignment is that it provides a hands-on approach to implementing design principles such as singletons, factories, and association classes. Students also gain experience working with Java collections and abstraction. Additionally, the implementation of the MVP of the vehicle registration system helps to understand the practical application of software design and development concepts.
