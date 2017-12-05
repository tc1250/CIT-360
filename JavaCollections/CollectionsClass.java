
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tcchr
 */
// Map, Set, List, Tree
public class CollectionsClass {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //starting with maps, specifically, hashmaps
        System.out.println("\n\n**MAPS**\n\n");
        //Like the HashMaps I used in the Application Control Code, maps use a key to get information back out
        //I created a book object that we will use to store objects in the HashMap
        System.out.println("Creating Map to store books...");
        HashMap<String, Book> library = new HashMap<>();
        HashMap<String, Book> library2 = new HashMap<>(); //I'll be using this later in the treeMap section
        System.out.println("\nCreating a few books to store in the Map...");
        Book TWOK = new Book("The Way of Kings", "Brandon Sanderson", "Roshar is a world of stone and storms. Uncanny tempests of incredible power sweep across the rocky terrain so frequently that they have shaped ecology and civilization alike. Animals hide in shells, trees pull in branches, and grass retracts into the soilless ground. Cities are built only where the topography offers shelter.It has been centuries since the fall of the ten consecrated orders known as the Knights Radiant, but their Shardblades and Shardplate remain: mystical swords and suits of armor that transform ordinary men into near-invincible warriors. Men trade kingdoms for Shardblades. Wars were fought for them, and won by them...", "9780765365279");
        Book WOR = new Book("Words of Radiance", "Brandon Sanderson", "Expected by his enemies to die the miserable death of a military slave, Kaladin survived to be given command of the royal bodyguards, a controversial first for a low-status \"darkeyes.\" Now he must protect the king and Dalinar from every common peril as well as the distinctly uncommon threat of the Assassin, all while secretly struggling to master remarkable new powers that are somehow linked to his honorspren, Syl.", "9780765365286");
        Book OB = new Book("Oathbringer", "Brandon Sanderson", "In Oathbringer, the third volume of the New York Times bestselling Stormlight Archive, humanity faces a new Desolation with the return of the Voidbringers, a foe with numbers as great as their thirst for vengeance.", "9780765326379");
        Book TEOTW = new Book("The Eye of the World", "Robert Jordan", "The Wheel of Time turns and Ages come and go, leaving memories that become legend. Legend fades to myth, and even myth is long forgotten when the Age that gave it birth returns again. In the Third Age, an Age of Prophecy, the World and Time themselves hang in the balance. What was, what will be, and what is, may yet fall under the Shadow.", "9780812511819");
        Book TGH = new Book("The Great Hunt", "Robert Jordan", "For centuries, gleemen have told the tales of The Great Hunt of the Horn. So many tales about each of th Hunters, and so many Hunters to tell of...Now the Horn itself is found: the Horn of Valere long thought only legend, the Horn which will raise the dead heroes of the ages. And it is stolen.", "9780812517729");
        Book TDR = new Book("", "", "", "9780812513714");
        System.out.println("\nAdding a couple of books to the Map...");
        //here we add the objects to the map, we will retrieve books with their ISBN
        library.put(TWOK.getIsbn(), TWOK);
        library.put(WOR.getIsbn(), WOR);
        library.put(TEOTW.getIsbn(), TEOTW);
        library.put(OB.getIsbn(), OB);
        library.put(TGH.getIsbn(), TGH);
        library.put(TDR.getIsbn(), TDR);

        library2.put(TWOK.getIsbn(), TWOK);
        library2.put(WOR.getIsbn(), WOR);
        library2.put(TEOTW.getIsbn(), TEOTW);
        library2.put(OB.getIsbn(), OB);
        library2.put(TGH.getIsbn(), TGH);
        library2.put(TDR.getIsbn(), TDR);
        //we can see the number of entries with the size funtion
        System.out.println("\nBook Count: " + library.size() + "\n");

        //We don't nessecarily need to know a book's ISBN to print it out, we can iterate through the whole Map using forEach()
        // note that my toString function caps the descriptions at 100 characters
        library.keySet().forEach((isbn) -> {
            System.out.println(isbn + " - " + library.get(isbn).toString());
        });

        //We can also return data from the hashmap based on the key or a value
        //using the key
        String searchKey = "9780765365279";
        String searchKey2 = "1234567890000";
        if (library.containsKey(searchKey)) {
            System.out.println("\nFound: " + library.get(searchKey) + " - Using searchKey: " + searchKey);
        } else {
            System.out.println("Couldn't find " + searchKey);
        }
        if (library.containsKey(searchKey2)) {
            System.out.println("\nFound: " + library.get(searchKey) + " - Using searchKey: " + searchKey);
        } else {
            System.out.println("Couldn't find " + searchKey2);
        }

        //using the value
        Book searchValue = TWOK;
        if (library.containsValue(searchValue)) {
            System.out.println("\nTWOK exists in this HashMap");
        }

        // clear() Removes all the elements from the map.
        System.out.println("\nClearing out the library...");
        library.clear();

        // Check if it's empty
        System.out.println("Library size: " + library.size());

        //moving on to sets, sets cannot contain duplicate elements
        System.out.println("\n\n**SETS**\n\n");
        Set<Book> set1 = new HashSet<>();

        //adding books to the set
        set1.add(TWOK);
        set1.add(WOR);
        set1.add(OB);
        set1.add(TEOTW);
        set1.add(TGH);
        set1.add(TDR);

        // Print out contents
        System.out.println("set1 = " + set1);

        // Create set2
        Set<Book> set2 = new HashSet<>();

        // Add books to set2
        set2.add(TWOK);
        set2.add(WOR);
        set2.add(OB);
        set2.add(TEOTW);
        set2.add(TGH);
        set2.add(TDR);

        // Print out contents
        System.out.println("set2 = " + set2);

        // We can compare sets to see if they match using .equals(), the below code will return true or false
        System.out.println("\nDoes set1 match set2? " + set1.equals(set2));

        //we can test if false is returned by modifying one set
        System.out.println("\n\nRemove TWOK from set1.");
        set1.remove(TWOK);

        //Then we compare again, to get a result of false, since they no longer match
        System.out.println("\nDoes set1 match set2 still? " + set1.equals(set2));

        //we can access/modify elements with a for loop or an iterator. I'll modify the object TDR since it has no name, author or description in it. 
        // Example of the use of a for each loop
        System.out.println("\nFor Each Loop");
        for (Book book : set1) {
            if (book == TDR) {
                book.setAuthor("Robert Jordan");
                book.setTitle("The Dragon Reborn");
                book.setDescription("Winter has stopped the war―almost―yet men are dying, calling out for the Dragon. But where is he? In the Heart of the Stone lies the next great test of the Dragon reborn.");
                System.out.println("This was the book you were looking for, now called " + book.getTitle() + " after the extensive changes we made here.");
            } else {
                System.out.println("This isn't the book you are looking for. Move along. " + book.getTitle());
            }
        }

        //Test that the contents of the book are properly updated by displaying the set
        System.out.println("\nset1 = " + set1);
        // Did updating the object in set one affect the TDR object in set 2? (It should have, it's the same object, not a different instance of it
        System.out.println("\nset2, notice that TDR is updated here too, since the set contains a pointer to the same object as set1 = " + set2);

        // we can clear the sets, like the maps
        System.out.println("\nClear set1...");
        set1.clear();
        System.out.println("\nSet1 size is now " + set1.size());

        //we can also store sets into arrays with the toArray() function
        System.out.println("\nSending set2 to an array");
        //had to google for this syntax, it didn't like me trying to use toArray to an array of Books
        Book[] arrayOfBooks = set2.toArray(new Book[set2.size()]);

        System.out.println("\nPrint the array of book objects...");
        for (Book book : arrayOfBooks) {
            System.out.println("\n" + book.toString());
        }

        //moving on to trees, I'm using tree map, so I get the key, value functionality of a map, but a tree should sort it
        System.out.println("\n\n**TREES**\n\n");
        TreeMap<String, Book> treeMap = new TreeMap<>();
        //add the same old books to the treeMap, using the ISBN's as the key        
        //I can actually use a constructor that adds a whole map my treeMap, so that library2 map from earlier will come in handy here
        //adding the library2 map to the treeMap
        treeMap.putAll(library2);

        System.out.println("\nPrinting the treeMap, notice that the ISBN's are sorted in order.");
        System.out.println("\ntreeMap: ");
        for (Iterator<String> book = treeMap.keySet().iterator(); book.hasNext();) {
            System.out.println("\nISBN: " + book.next());
        }
        //trees can use first or last, and since they are sorted, it shows us the highest or the lowest values. 
        System.out.println("\nHighest ISBN: " + treeMap.firstKey());
        System.out.println("\nLowest ISBN: " + treeMap.lastKey());
        
        // I could compare two treeMaps
        TreeMap<String, Book> treeMap2 = new TreeMap<>();
        treeMap2.putAll(treeMap);
        
        System.out.println("\nCheck if treeMap equals treeMap2: " +treeMap.equals(treeMap2));
        
        //remove an object from treeMap and test for equality again, then clear both treeMaps
        System.out.println("\nRemove 'The Dragon Reborn' from treeMap...");
        treeMap.remove("9780812513714");
        System.out.println("\n'The Dragon Reborn' is removed from treeMap.");
        
        System.out.println("\nCheck if treeMap still equals treeMap2: " +treeMap.equals(treeMap2));
        
        System.out.println("\nClear both treeMaps and check if they are empty...");
        treeMap.clear();
        treeMap2.clear();
        
        System.out.println("treeMap size: " + treeMap.size());
        System.out.println("treeMap2 size: " + treeMap2.size());
        
        //moving on to Lists, specifically, an ArrayList
        System.out.println("\n\n**ArrayList**\n\n");
        
        System.out.println("\nAdding book titles to an Array List.");
        List<String> titles = new ArrayList();
        titles.add(TWOK.getTitle());
        titles.add(WOR.getTitle());
        titles.add(OB.getTitle());
        titles.add(TEOTW.getTitle());
        titles.add(TGH.getTitle());
        titles.add(TDR.getTitle());
        
        System.out.println("\nPrinting the titles: " + titles);
        
        Collections.sort(titles);
        System.out.println("\nWe can sort an Array List: " + titles);
        Collections.shuffle(titles);
        System.out.println("And then we can shuffle it again: " + titles);
        Collections.sort(titles);
        System.out.println("\nLet's say we want to search this list. We'll sort it first, and then we'll search for... 'The Way of Kings'.");
        System.out.println("Was the title found in the list, and if it was, what position was it: " + Collections.binarySearch(titles, "The Way of Kings"));
        System.out.println("We can try searching for something not in the list, like, The Book of Mormon: " + Collections.binarySearch(titles, "The Book of Mormon"));
        System.out.println("\nLet's add the Book of Mormon and search for it again. According to the documentation, the error code indicates the negative insertion point minus one: "+
                "\nso if we add one to -2 then make it positive (positive 1) that should be the number that is displayed when we add the BOM to the array and search for it again.");
        titles.add("The Book of Mormon");
        Collections.sort(titles);
        System.out.println("Now we search for the Book of Mormon again: " + Collections.binarySearch(titles, "The Book of Mormon"));
        
        
        
    }
}
