package question1;


/**
 * Write a description of class TestObjectList here.
 * 
 * @author Manuel Colorado 
 * @version 19/10/2017
 */
public class TestObjectList
{
   public static void main(String[] args)
   {
       ObjectList ol = new ObjectList(3);
       
       String s = "Im Happy";
       Dog d = new Dog();
       DVD v = new DVD();
       Integer i = 1234;
       
       System.out.println(ol.add(s)); //Add the string Im happy to the list, and prints the result
       System.out.println(ol.add(d)); //Add the Dog object to the list, and prints the result
       System.out.println(ol.add(v)); //Add the DVD object to the list, and prints the result
       System.out.println(ol.add(i)); //Tries to add 1234 to the list, but it's full
       
       ol.remove(0); //Removes first element of the list (the string)
       System.out.println(ol.add(i)); //Tries to add 1234 again, it works now
       
       
       System.out.println("Is the list full? "+ ol.isFull()); //Tests if the list is full (should be)
       System.out.println("Is the list empty? "+ ol.isEmpty()); //Tests if the list is empty (shouldn't be)
       
       System.out.println("Total number of objects in the list: " + ol.getTotal()); //Prints the total elements on the list
       
       Object g = ol.getObject(0); //index needs to be changed, dog is no longer object 1
       ((Dog) g).bark(); //this needs casting, as Object doesn't have a bark() method
       // The other solution would be to add bark() method to DVD class, as it's the one at position 1
       // and add the casting to DVD in line 36
   }
}

