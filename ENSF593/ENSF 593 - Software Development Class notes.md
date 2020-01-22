# Class Relationships 



Modelling the relationships between objects **(Design)**

* What types of relationships exist between objects? **(what is the design?)**
* How good is the design? 
  * Coupling :arrow_down: & cohesion :arrow_up: ... 
    * SOLID design principles...
      **S**ingle Responsibility
      **O**pen/Closed
      **L**iskov Substitution
      **I**nterface Segregation
      **D**ependency Inversion



![](/home/bryce/Pictures/Screenshot from 2019-09-26 10-44-00.png)

## Association

The association relationship expresses a semantic connection between classes:

* There is no hierarchy.
* It is a relationship where two classes are weakly
connected; i.e. they are merely “associates.”
– All object have their own life-cycle;
– There is no ownership.
– There is no whole-part relationship.

---

Normally an association relationship represents a bi-directional relationship between classes of objects. 

*  A typical type of association is the "Using" relationship

  [Company] -----------(Employs (Uses))-------------[Person]

  Association is often bi-directional, **But** we have one-directional association as well. (to be discussed)

  > **Another association... Computer and printer. Multiple printers can associate with a single computer and multiple printers can associate with one computer. **

> #### Multiplicity / Cardinality
>
> * Multiplicity defines the number of objects that are linked to one another. 
>   * 1 Exactly one
>   * 0..* Zero or more
>   * 1..* One or more
>   * 0..1 One or Zero
>   * 5..7 Specific Range (5,6, or 7)
>   * 4..7, 9 Combination (4,5,6,7, or 9)

![](/home/bryce/Pictures/Screenshot from 2019-09-26 11-00-51.png)

## Aggregation 

Example.. Room can have one or many doors. **Room** > [1] -----> [1..*] **Door** (This is a one directional relationship)  

* Room has a relationship (ownership) whole-part relationship. 
  [Airplane] :large_blue_diamond:------*[Passengers]:large_blue_diamond:-------[Position]
  Aggregation ... UML notation​  <>​-----  (hollow diamond attached to a line. )

  Whole-part relationship. 

  * It's a one directional relationship
    * The owner has access to the part's data
    * The part **does not** know the owner

# Composition

UML notatation: :large_orange_diamond: --- (filled in diamond attached to a line!)

A strong type of aggregation, when deletion of the whole causes the deletion of the part, is called *composition* . 

[person] :large_orange_diamond:---[heart]

# Association, Aggregation, Composition in code (Java) 

How to tell if a relation is association... if you call the part object's constructor inside the constructor, that is association. 

If you construct in the constructor, that is composition. 

![](/home/bryce/Pictures/Screenshot from 2019-09-26 11-28-18.png)

---

> #### Association
>
> * A has an object of type B. And B has and object of type A. **(But neither constructs the other one**)
> * Also the objects of A in B, and B in A, are not assigned in the constructor of the class
> * These objects are assigned in other member functions (i.e. instance methods)
>
> 

> #### Aggregation 
>
> - A has an object of type B (and not the other way around)
> - A does not construct objects of type B
> - The object of type B is assigned **Inside** the construcior of A
> - **(Once A dies, B does NOT die)**

> #### Composition
>
> - A has an object of type B
> - A **DOES** construct an object of type B
> - The object of type B is constructed inside or outside of the constructor of A **(Once A dies, B dies)**

#### In Memory!

![](/home/bryce/Pictures/Screenshot from 2019-09-26 11-38-51.png)

> #### Association
>
> Two Directional

> #### Aggregation
>
> - As soon as A is constructed, myB is assigned to an object of type B. 
> - If the whole (i.e. container) is destroyed object of type B (i.e. myB) is not desroyed. 

> #### Composition
>
> - If the container (i.e. A) is destroyed (i.e. a = null), the part (i.e. myB) is also destroyed. 

---

### One way Association

![](/home/bryce/Pictures/Screenshot from 2019-09-26 11-43-04.png)

It's exactly like aggregation but the object of type Car is **NOT** assigned in the constructor of person. Rather, it's assigned in another instance method. 

---

>  A computer has at least one CPU and at most 4. A computer can have any # of monitors and a computer uses a printer. 
>
> ![](/home/bryce/Pictures/Screenshot from 2019-09-26 11-52-10.png)

# Dependency

UML notation : -----------> (this is an arrow.)

[A]----->[B]

> #### [Client]---->[Server]
>
> This means that the client uses the methods of the server. 

So in the following case:

> #### [A]----->[B]
>
> A is dependant on B, which means that A does not have an object of type B inside, instead A receives an object of type B as an argument , only to use it for invoking the methods of B. **(Or creates objects of type B in various methods)**

# Reflexive Association

A class can be associated with itself, using reflexive association. 

![](/home/bryce/Pictures/Screenshot from 2019-09-26 12-09-16.png)

# Example in Code!

```java

public class MyClassA {
	private MyClassB myB;
	
	MyClassA (MyClassB b){
		myB = b; //Shallow Copy?
		MyClassC myC = new MyClassC ();
	}
	
	public static void main(String [] args) {
		MyClassB b1 = new myClassB();
		MyClassA a1 = new MyClassA();
	}
	

}

```

![](/home/bryce/Pictures/Screenshot from 2019-09-26 12-23-19.png)

* B is aggregated to A
* A is dependant on C

# Inheritance

Inheritance is a relationship where a subclass inherits the structure and behaviour of its superclass. 

Structure: Instance variables 

Behaviour 

# Abstract Classes vs. Interfaces

## Abstract

- Can only extend one class
- Can have both abstract and concrete methods
- can have protected and public abstract methods
- can have static, final or static final variables with any access identifiers (public, private, protected)

# Interfaces

- Can extend any number of interfaces
- An interface can only extend another interface
- Can only have abstract methods, unless the methods are declared as default
  - we will talk more about default methods
- It is optimal to use the abstract keywords for method (implicitly abstract)
- can only have public abstract methods
- can only have public static final (constant) variables. 

# Static and default methods in Interfaces in Java

were added to java since java 8.0 (amongst other things)

## Default Methods



```java
public interface someInterface{
    public void foo(); //abstract method
    
    default void fun(){
        system.out.print("Fun!"); // Has an implementation
    }
} 
// a default method is a method that is implemented in the abstract. 
public class classA implements someInterface {
    //code...
    @Override
    public void foo(){system.out.print("Foo");}
}
// ClassA must implement ALL abstract methods in interface someInterface.
// So we must implement foo(), but we simply inherit the behaviour of fun().
// NOTE: we can override fun.

```

# Java Lambda Expressions (LE)

- New and important feature introduced in Java 8. 
- a concise way to represent one method interfaces using an expression
- useful for many things such as :
  - event handling
  - collection libraries (ie iterators)
- Lambda expressions in Java are treated as a function, so the compiler does not create .class files. 

## Functional Interface (FI)

Lambda Expressions (LE) provide the implementation of FIs.

An interface that has only one abstract method is called a FI.

Java has an annotation for these interfaces @FunctionalInterface 

### Why LE?

- Provide implementation for functional FI
- To pass **functionality** instead of data as parameter
- 3 components of lambda expressions...

1. Argument List - Can be empty
2. Arrow Token -> used to link argument list and body of expression
3. Body - statements.

( ) -> {

}

(P1) ->{
	//Body
}

# Intro to System Architecture

System divide ----> separate code based on **LOGIC** (ENSF 593/594) or based on **Physical Location** (ENSF 607) -----> tiers... e.g. client servers 

## 3 Layered Architecture <-- Logical view

A tier is a physical location, a layer is  a logical separation

![](/home/bryce/Pictures/3layerarchetecture.png)

# Database 

what is a database?

- SQL
  - statement vs prepared statement
  - security issues with DB and some solutions
    - SQL Injections

Full Stack Dev

- Front End
- Back End

## Object Design

- Class Diagrams (uml)
- Objects are loaded onto RAM

## DB Design

- Entry Relationship Diagram (ERD) //*
- DB stored on disk
- Use relational (ra)



---

Ideally we want to map our model from MVC to our database. 

Mapping class diagrams to ERD is challenging in the real world.

**What is a SQL-based database?**

Collection of data tiles that are connected with some attributes

This is done thorough the use of "Tables"

<Diagram of some tables>

We use JDBC to connect to the Database 

And we use SQL to write Quiries ----> Requests (ie opertions performed by the DB)

- insert row (one record)
- delete row (one record)
- list data 
  - list all data
  - list a particular range or value

The structure of SQL quiries is as follows:

> select		**What data??** eg * to select all data
>
> from 		what Table? ... Table Student
>
> where 	Condition on the data

## JDBC 

- Statement
  - Used for general access to DB
  - Useful for using static statement at runtime 
  - statement interface does not accept parameters
- Prepared statements (PS)
  - used when SQL statements are to be used many times
  - PS interface accepts parameters at runtime.
- Callable Statement (Won't cover)
  - used when access is needed to database stored procedures. also accepts parameters at runtime. 

## Methods

```java
boolean execute (String s)
    returns true if result set (RS) can be retrieved
        
int executeUpdate(String s)
   returns the # of rows affected
        
ResultSet exectuteQuery (String s)
   returns the RS
        
close()
   for closing the statement
        

```

