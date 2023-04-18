DESIGN OVERVIEW

The implementation consists of classes and interfaces to represent shapes, transformations, and 
a photo album containing snapshots of shapes. I will talk about the various design choices made 
below, categorically and overall:

Shape Hierarchy

The Shape class is an abstract class representing a generic shape with a name, position, and 
color. It provides common attributes & methods that are shared by all shape objects. 
I chose to use an abstract class instead of an interface because:

1. Some shared properties and methods have concrete implementations, such as name, x, y, and 
   color. There are also many common methods / transformations (or interactions) shared throughout 
   various shapes. 
2. The abstract class allows for common functionality to be implemented within the class, 
while still providing flexibility for subclasses to override or extend the behavior. The 
   abstract shape class is designed such that any new shape can be easily implemented into the 
   photo album system as long as it overrides methods appropriately based on its unique 
   properties, and can be easily used with any ITransformation method.


Two concrete shape classes, Rectangle and Oval, extend the Shape class and provide an 
example for how the abstract class can be used. Both of these classes implement the abstract 
methods specific to their unique geometric properties.

Color Enum

The Color enum is used to represent the available colors for shapes. I chose 
to use an enum for colors because:

1. Enums provide a fixed set of predefined constant values, which makes the code 
more readable and less error-prone.
2. Enums are type-safe, ensuring that invalid values cannot be assigned to color properties.

The obvious design tradeoff (at least in the current implementation) is that the shapes in the 
album are bound the color enums already listed. Being able to generate a color by a string input 
was an initial design decision for me, but I decided against it later because it would be quite 
difficult to protect the shape attribute from non-color inputs, if we want to respect the fact 
that color inputs should simply be actual color inputs (and not any String). In the future, 
limiting inputs to a HEX code or RGB codes  could be interesting, as I assume they 
have a protected range and would be a sweet in-between protecting inputs and allowing 
attribute flexibility. 

Transformations

The ITransformation interface defines a single 
apply method that applies a transformation to a given shape. 
Classes implementing this interface provide concrete transformations, 
such as Move, Scale, and ChangeColor. I chose to use an interface with a single method because:

1. It allows for different transformation implementations to be easily added or swapped out, 
promoting flexibility and extensibility.
2. The apply method makes the interface simple to understand and implement, allowing for easy 
   debugging and convenient reuse for creative transformation-related applications. 

Photo Album & Snapshots

The ShapesPhotoAlbum class represents a photo album 
containing snapshots of shapes. Initially, the photo album wasn't a singleton, but halfway 
through the design of this Model I realized that true object equivalence and initialization 
would create a potential spaghetti design and relationship between the controller, multiple unique 
photo album instances, and multiple shape and snapshot lists that they manipulate. Keeping the 
solution limited 
to a single album was much more accessible and clean, and works well as the album can be reset 
whenever necessary. 

The Snapshot class represents a snapshot containing 
a list of shapes, a timestamp, and a description. 
It also provides a method to generate a text description of the snapshot.
The snapshots in the album are unmodifiable, as they represent
a historical record of the album's state. I have achieved this my making a defensive copy of the 
shapes list every time it's passed into the constructor, so the shapes list, along with the 
timestamp, can't be modified directly. 



