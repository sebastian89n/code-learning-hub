# Design Patterns in Object-Oriented Programming

Design patterns are reusable solutions to common problems in software design. They provide a way to create flexible and
maintainable code by capturing best practices in various scenarios. In object-oriented programming, there are several
categories of design patterns, including:

## Behavioral Patterns

- **Chain of Responsibility Pattern:** Passes the request along a chain of handlers. Upon receiving a request, each
  handler decides either to process the request or to pass it to the next handler in the chain. It allows you to
  decouple senders and receivers of requests.
- **Mediator Pattern:** Defines an object that encapsulates how a set of objects interact. It promotes loose coupling by
  centralizing communication between objects.
- **Memento Pattern:** Captures and externalizes an object's internal state so the object can be restored to this state
  later. It's used to support undo mechanisms or to provide a snapshot of an object's state.
- **Observer Pattern:** Defines a one-to-many dependency between objects, so when one object changes state, all its
  dependents are notified and updated automatically. It's useful for building distributed event handling systems.
- **State Pattern:** Allows an object to alter its behavior when its internal state changes. The object will appear to
  change its class as its state changes.
- **Strategy Pattern:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy
  lets the algorithm vary independently from clients that use it.
- **Template Method Pattern:** Defines the skeleton of an algorithm in the superclass but lets subclasses override
  specific steps of the algorithm without changing its structure.
- **Visitor Pattern:** Represents an operation to be performed on the elements of an object structure. It allows you to
  define a new operation without changing the classes of the elements on which it operates.

## Creational Patterns

- **Abstract Factory Pattern:** Provides an interface for creating families of related or dependent objects without
  specifying their concrete classes. It allows you to create objects with varying implementations while keeping them
  consistent.
- **Builder Pattern:** Separates the construction of a complex object from its representation, allowing the same
  construction process to create different representations.
- **Factory Method Pattern:** Defines an interface for creating objects, allowing subclasses to alter the type of
  objects that will be created.
- **Prototype Pattern:** Creates new objects by copying an existing object, known as a prototype. It is useful when
  creating objects is more efficient by copying existing instances.
- **Singleton Pattern:** Ensures a class has only one instance and provides a global point of access to it.

## Structural Patterns

- **Adapter Pattern:** Allows the interface of an existing class to be used as another interface. It is useful when you
  want to make existing classes work together, even if their interfaces are incompatible.
- **Composite Pattern:** Composes objects into tree structures to represent part-whole hierarchies. Clients can treat
  individual objects and compositions of objects uniformly. It's useful for creating complex hierarchies of objects.
- **Decorator Pattern:** Attaches additional responsibilities to objects dynamically, providing a flexible alternative
  to subclassing. It's used to add features or behaviors to objects without altering their structure.
- **Facade Pattern:** Provides a simplified, high-level interface to a set of interfaces in a subsystem. It makes
  complex systems easier to use by providing a unified interface.
- **Flyweight Pattern:** Minimizes memory usage or computational expenses by sharing as much as possible with other
  similar objects. It's useful when you need to create a large number of similar objects efficiently.
- **Proxy Pattern:** Provides a surrogate or placeholder for another object to control access to it. It's often used for
  controlling access, managing resource usage, or adding lazy initialization.

These design patterns help software developers solve recurring problems efficiently, making their code more maintainable
and adaptable.
