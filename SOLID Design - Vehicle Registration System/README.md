## Summary

This project builds the assets for a vehicle registration system MVP. It includes implementing concepts such as singletons, association classes, factories, Java collections (Sets), and abstraction.

The RegistrationSystem is the main class in this project, and it is a Singleton that contains six methods: getInstance(), createVehicle(), register(), getAllRegistrations(), getFilteredList(), and reboot(). The createVehicle() method creates a new instance of a vehicle, while the register() method adds a new registration to the system. The reboot() method resets the system, while the getAllRegistrations() method returns an unmodifiable list of all registrations currently managed by the system. The getFilteredList() method takes a Predicate and returns a sublist filtered based on the query.

The project is a hands-on approach to implementing design principles such as singletons, factories, and association classes. 
