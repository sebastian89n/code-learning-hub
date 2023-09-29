# spring-aop

Examples of Spring Aspect Oriented Programming.

Aspect-oriented Programming (AOP) complements Object-oriented Programming (OOP) by providing another way of thinking
about program structure. The key unit of modularity in OOP is the class, whereas in AOP the unit of modularity is the
aspect. Aspects enable the modularization of concerns (such as transaction management) that cut across multiple types
and objects. (Such concerns are often termed "crosscutting" concerns in AOP literature.)

- Aspect: A modularization of a concern that cuts across multiple classes. Transaction management is a good example of a
  crosscutting concern in enterprise Java applications. In Spring AOP, aspects are implemented by using regular
  classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).

- Join point: A point during the execution of a program, such as the execution of a method or the handling of an
  exception. In Spring AOP, a join point always represents a method execution.

- Advice: Action taken by an aspect at a particular join point. Different types of advice include "around", "before",
  and "after" advice. (Advice types are discussed later.) Many AOP frameworks, including Spring, model an advice as an
  interceptor and maintain a chain of interceptors around the join point.

- Pointcut: A predicate that matches join points. Advice is associated with a pointcut expression and runs at any join
  point matched by the pointcut (for example, the execution of a method with a certain name). The concept of join points
  as matched by pointcut expressions is central to AOP, and Spring uses the AspectJ pointcut expression language by
  default.

