# Assignment1

Problem Statement - 5
Write a program that serializes and deserializes a Student class according to the following criteria -

Write a class Student.class with the following properties/fields -
firstName (String)
dateOfBirth (String)
address (represents instance of Address class)  
Write a class Address.class with following properties/fields -
city (String)
State (String) 
pinCode (Integer)
country (String)
Write appropriate constructors for both Address.class and Student.class classes.
Write a separate class, SerializationTest, that constructs four different Student objects, places them in a List, and then serializes the result to a file specified as command line argument. Run the program twice with different files specified (output1.ser and output2.ser)
Write another program, DeserializationTest, that reads files containing a serialized list of Students created in previous steps and prints the serialized list of Students.. Files to be read are again specified as command line arguments (output1.ser and output2.ser).
Change dateOfBirth type from java.lang.String to java.util.Date and change the constructor implementation accordingly. Don’t change the signature of the constructor. Just use a single parameter constructor of the Date class to assign the passed String Date to “dateOfBirth”.
After recompiling Person, at this point you should verify the following:
If you run DeserializationTest on either output1.ser or output2.ser you should get a runtime exception.
If you run SerializationTest and regenerate output2.ser you will be able to read it back with DeserializationTest, but since output1.ser is in the old format, you won't be able to read that file.
Important - Revise the Student class such that if you rerun SerializationTest to regenerate output 2.ser using the new Student format, BUT LEAVE output1.ser IN THE OLD FORMAT, you will still be able to run DeserializationTest for both files as was done before, even though there are two different Student formats.
While implementing this part, you are only allowed to rewrite and recompile only Student class.


Workflow:-

I). Serialization Workflow
(A) Instantiate Objects:

 - Created instances of the Student class with different formats of dateOfBirth (String and Date) and other required fields.
 - Created instances of the Address class for each Student.

(B) Serialize Objects:

 - The list of Student objects is serialized to a file using the Serialization.java program.
 - In the Serialization.java program:
	- Created a list of Student objects with the desired formats.
	- Used ObjectOutputStream to write the list to a file (output2.ser) specified as a command line argument.
	- Implemented custom serialization handling in the Student class to write the old serialVersionUID along with the new one.

(C) Verified Serialization:

 - Verified the output2.ser generated and it contains the serialized data of Student objects in the new format.

II). Deserialization Workflow
(A) Deserialize New Format:

 - Deserialized the Student objects from output2.ser using the Deserialization.java program.
 - In the Deserialization.java program:
 	- Used ObjectInputStream to read the serialized data from output2.ser.
 	- Verified the new format data that can be deserialized without exceptions.

(B) Deserialize Old Format:

 - Attempted to deserialize the Student objects from output1.ser using the same Deserialization.java program.
 - In the Deserialization.java program:
 	- Implemented custom deserialization handling in the Student class to read the old serialVersionUID.
 	- Checked if the old format data can be handled gracefully without causing runtime exceptions.

(C) Verified Deserialization:

 - Verified that both output1.ser (old format) and output2.ser (new format) can be deserialized successfully using the appropriate handling in the Deserialization.java program.
 - Custom Serialization Handling
 - Custom serialization handling is implemented in the Student class using writeObject and readObject methods.
 - writeObject writes both the new and old serialVersionUID to the serialized file.
 - readObject reads the serialized data and handles old format data gracefully if encountered, ensuring backward compatibility.



(D) Output after regenerating output2.ser in Serializable.java:-

Serialization successful. Data saved to output2.ser


(E) Output after Deserializing output1.ser:-

Deserialization.java:21: warning: [unchecked] unchecked cast
            List<Student> students = (List<Student>) ois.readObject();
                                                                   ^
  required: List<Student>	
  found:    Object
1 warning
Deserialization successful. Data read from output2.ser
Student{firstName='Krishna', dateOfBirth='2004-01-01', address=Address{city='Indore', state='MP', pinCode=123456, country='India'}}
Student{firstName='Avijit', dateOfBirth='2005-01-02', address=Address{city='Bhopal', state='MP', pinCode=234567, country='India'}}
Student{firstName='Aditya', dateOfBirth='2007-03-09', address=Address{city='Nagpur', state='Maharashtra', pinCode=345678, country='India'}}
Student{firstName='Sarthak', dateOfBirth='2006-04-05', address=Address{city='Jaipur', state='Rajasthan', pinCode=456789, country='India'}}
krishna@krishna-HP-Pavilion-Laptop-15-eg2xxx:~/Pictures/Java_AssignmentsHotwax/Assignment1/Serialization/src/main/java/com/example$ java Deserialization.java output1.ser
Deserialization.java:21: warning: [unchecked] unchecked cast
            List<Student> students = (List<Student>) ois.readObject();
                                                                   ^
  required: List<Student>
  found:    Object
1 warning
java.io.InvalidClassException: main.java.com.example.Student; local class incompatible: stream classdesc serialVersionUID = 5461053639669178509, local class serialVersionUID = 1
        at java.base/java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:598)
        at java.base/java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:2063)
        at java.base/java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1912)
        at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2237)
        at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1747)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:525)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:483)
        at java.base/java.util.ArrayList.readObject(ArrayList.java:982)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.io.ObjectStreamClass.invokeReadObject(ObjectStreamClass.java:1108)
        at java.base/java.io.ObjectInputStream.readSerialData(ObjectInputStream.java:2429)
        at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2269)
        at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1747)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:525)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:483)
        at main.java.com.example.Deserialization.main(Deserialization.java:21)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.execute(SourceLauncher.java:264)
        at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.run(SourceLauncher.java:153)
        at jdk.compiler/com.sun.tools.javac.launcher.SourceLauncher.main(SourceLauncher.java:78)


(F) Output after Allowing backward compatibility for deserialization:-
 
 java Serialization.java output1.ser
Serialization successful. Data saved to output1.ser

 
(G) Output of The custom Deserialization handling:-
 
  java Deserialization.java output1.ser
Deserialization.java:21: warning: [unchecked] unchecked cast
            List<Student> students = (List<Student>) ois.readObject();
                                                                   ^
  required: List<Student>
  found:    Object
1 warning
Handling old format data...
Handling old format data...
Handling old format data...
Handling old format data...
Deserialization successful. Data read from output1.ser
Student{firstName='Krishna', dateOfBirth='2004-01-01', address=Address{city='Indore', state='MP', pinCode=123456, country='India'}}
Student{firstName='Avijit', dateOfBirth='2005-01-02', address=Address{city='Bhopal', state='MP', pinCode=234567, country='India'}}
Student{firstName='Aditya', dateOfBirth='2007-03-09', address=Address{city='Nagpur', state='Maharashtra', pinCode=345678, country='India'}}
Student{firstName='Sarthak', dateOfBirth='2006-04-05', address=Address{city='Jaipur', state='Rajasthan', pinCode=456789, country='India'}}
