package spira.network;

import java.net.Socket;

public interface ReaderListener {

	//cr8ing own interface allows u to be able to reusable code
	//listeners are observers=listeners are basically there to observe when event happens
	//design patterns - patterns in programming that will see over and over again
	// = singleton, factory, listeners-observers,builder pattern-string builder=objects complicated to construct than u may create a builder
	//for it in stead of cr8ing whole bunch of diff constructers to it. and then use builder.build, also there is a gson builder object which allows u to modify b4 contructing it
	//check wikipedia on software design patterns
	
	
	
	void onLineRead(String line);

	void onCloseSocket(Socket socket);
	
	

	
	//diff bet adapter and listener
	
	
	//diff bw class - has methods , field variables
	//interface- unimplemented methods that u must implement, constants, in java8 interface can have methods, 
	//abstract class- ex is mouse adapter- sometimes can have listener that creates bunch diff methods which sometimes annoying if only want one
	// so instead can extend a mouse adapter. abstract means not defined, so a reg classes can be instantiated, in abstract class cannot instantiate
	// its kinna in bet class and interface. but can define own methods in abstract class and can define abstract method in abstract class
	// where sub classes need to implement the methods. u would need to extend it. 
	//if create jfame so extend jfame and want it to handle mouse events. but cannot use mouse adapter cuz cannot extend 2 diff things
	
}
