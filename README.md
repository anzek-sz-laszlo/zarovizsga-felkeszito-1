ÍME AZ ÍGÉRT TESZTKÉRDÉSEK 
- ehhez hasonlóak lesznek majd a vizsgán is!
Annyi megjeygzés:
- ahogy az órai munkában is utaltam rá, néhány helyen hiányzik a 
@Override 
annotáció, de kérlek benneteket, ezt ne tikintsük hiányos programkódnak (noha valóban az) -ahová mégis kell, oda "képzeljétek oda", és lefordul a kód!

1. rész: Alapok
Kérdés 1


int x = 5;
int y = 10;
int result = x + y * 2;
System.out.println(result);
Mi lesz az eredmény? 
a) 25
b) 20
c) 15
Helyes válasz: b
Magyarázat: Az operátorok precedenciája miatt a szorzás előbb történik, mint az összeadás, tehát 10 * 2 = 20, majd 5 + 20 = 25.
Kérdés 2


double d = 5.5;
int i = (int) d;
System.out.println(i);
Mi lesz az eredmény? 
a) 5
b) 6
c) 5.5
Helyes válasz: a
Magyarázat: Az explicit típuskonverzió (casting) a double értéket egészre alakítja, elhagyva a tizedesjegyeket.
Kérdés 3


Integer a = 100;
Integer b = 100;
System.out.println(a == b);
Mi lesz az eredmény? 
a) true
b) false
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: Az Integer értékek -128 és 127 között cache-lődnek, így az == operátor true eredményt ad.
Kérdés 4


String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2);
Mi lesz az eredmény? 
a) true
b) false
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: Az == operátor az objektumok referenciáit hasonlítja össze, nem a tényleges string értékeket. A két referencia különbözik.
Kérdés 5


for(int i = 0; i < 5; i++) {
    if(i == 2) {
        continue;
    }
    System.out.print(i + " ");
}
Mi lesz az eredmény? 
a) 0 1 2 3 4
b) 0 1 3 4
c) 0 1 2 4
Helyes válasz: b
Magyarázat: A continue utasítás átugorja a ciklus aktuális iterációját, amikor i értéke 2, így 2 kimarad a kiírásból.
Kérdés 6


int a = 10;
if(a > 5) {
    a++;
} else {
    a--;
}
System.out.println(a);
Mi lesz az eredmény? 
a) 9
b) 10
c) 11
Helyes válasz: c
Magyarázat: Mivel a feltétel (a > 5) igaz, az a értéke megnő 1-gyel, így 11 lesz.
Kérdés 7


int x = 10;
switch(x) {
    case 5:
        x += 5;
        break;
    case 10:
        x += 10;
        break;
    default:
        x += 15;
}
System.out.println(x);
Mi lesz az eredmény? 
a) 10
b) 20
c) 25
Helyes válasz: b
Magyarázat: A switch kifejezés x értékét 10-hez hasonlítja, ami miatt a második case ág fut le, így x 20 lesz.
Kérdés 8


int x = 5;
int y = 3;
if(x < 10 && y > 1) {
    System.out.println("True");
} else {
    System.out.println("False");
}
Mi lesz az eredmény? 
a) True
b) False
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: Mindkét feltétel igaz, ezért a kiírás "True" lesz.
Kérdés 9


boolean flag = false;
if(!flag) {
    System.out.println("Flag is false");
} else {
    System.out.println("Flag is true");
}
Mi lesz az eredmény? 
a) Flag is false
b) Flag is true
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A ! operátor negálja a flag értékét, így a feltétel igaz lesz.
Kérdés 10


int[] arr = {1, 2, 3, 4, 5};
for(int i = 0; i < arr.length; i++) {
    arr[i] *= 2;
}
System.out.println(Arrays.toString(arr));
Mi lesz az eredmény? 
a) [2, 4, 6, 8, 10]
b) [1, 2, 3, 4, 5]
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A ciklus minden elemet megkettőz az arr tömbben, így az új értékek 2, 4, 6, 8, 10 lesznek.
Kérdés 11


int x = 1;
while(x < 5) {
    x++;
}
System.out.println(x);
Mi lesz az eredmény? 
a) 4
b) 5
c) 6
Helyes válasz: b
Magyarázat: A ciklus addig fut, amíg x értéke kisebb, mint 5, majd az utolsó iterációban x értéke 5 lesz.
Kérdés 12


for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 2; j++) {
        System.out.print(i + "," + j + " ");
    }
}
Mi lesz az eredmény? 
a) 0,0 0,1 1,0 1,1 2,0 2,1
b) 0,0 1,0 2,0 0,1 1,1 2,1
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A külső ciklus 0-tól 2-ig, a belső ciklus 0-tól 1-ig fut, így az összes kombináció kiírásra kerül.
Kérdés 13


int a = 5;
int b = 2;
double result = a / b;
System.out.println(result);
Mi lesz az eredmény? 
a) 2.5
b) 2.0
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: Az egész számok osztása egész eredményt ad, még akkor is, ha az eredmény típusa double.
Kérdés 14


int a = 7;
a %= 4;
System.out.println(a);
Mi lesz az eredmény? 
a) 3
b) 1
c) 0
Helyes válasz: a
Magyarázat: Az %= operátor a maradékot adja vissza az osztásból, így 7 % 4 = 3.
Kérdés 15


int x = 10;
if(x < 5 || x > 8) {
    x += 10;
}
System.out.println(x);
Mi lesz az eredmény? 
a) 10
b) 20
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: Mivel x > 8 igaz, az || operátor miatt a feltétel teljesül, így x értéke 20 lesz.
Kérdés 16


int x = 3;
int y = x++;
System.out.println(y);
Mi lesz az eredmény? 
a) 2
b) 3
c) 4
Helyes válasz: b
Magyarázat: A postfix operátor (x++) először az x értékét adja vissza, majd növeli, így y értéke 3 lesz.
Kérdés 17


String str = "Hello";
str += " World";
System.out.println(str);
Mi lesz az eredmény? 
a) Hello
b) Hello World
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A += operátor hozzáfűzi a " World" szöveget az eredeti stringhez.
Kérdés 18


boolean flag = true;
if(flag = false) {
    System.out.println("Flag is false");
} else {
    System.out.println("Flag is true");
}
Mi lesz az eredmény? 
a) Flag is false
b) Flag is true
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: Az if feltételben a flag értéke false-ra változik, így a feltétel hamis lesz, és a "Flag is false" ág fut le.
Kérdés 19


String str1 = "Java";
String str2 = "Ja" + "va";
System.out.println(str1 == str2);
Mi lesz az eredmény? 
a) true
b) false
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A str2 értéke a fordítás során optimalizálódik, így ugyanarra a memóriacímre mutat, mint str1.
Kérdés 20


int x = 1;
do {
    x++;
} while(x < 5);
System.out.println(x);
Mi lesz az eredmény? 
a) 4
b) 5
c) 6
Helyes válasz: b
Magyarázat: A do-while ciklus először növeli x értékét, majd ellenőrzi a feltételt. Az utolsó iteráció után x értéke 5 lesz.
2. rész: Metódusok és osztályok
Kérdés 21


public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.printMessage();
    }
    
    public void printMessage() {
        System.out.println("Hello, World!");
    }
}
Mi lesz az eredmény? 
a) Hello, World!
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A main metódus példányt hoz létre a Main osztályból, és meghívja a printMessage metódust, ami kiírja a "Hello, World!" üzenetet.
Kérdés 22


public class Main {
    static int counter = 0;
    
    public Main() {
        counter++;
    }
    
    public static void main(String[] args) {
        Main obj1 = new Main();
        Main obj2 = new Main();
        System.out.println(counter);
    }
}
Mi lesz az eredmény? 
a) 1
b) 2
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: Minden új példány létrehozásakor a konstruktor növeli a counter változót, így az értéke 2 lesz.
Kérdés 23


interface Printable {
    void print();
}

public class Document implements Printable {
    public void print() {
        System.out.println("Printing document");
    }
    
    public static void main(String[] args) {
        Document doc = new Document();
        doc.print();
    }
}
Mi lesz az eredmény? 
a) Printing document
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A Document osztály implementálja a Printable interfészt, és a print metódus meghívásra kerül, ami kiírja a "Printing document" üzenetet.
Kérdés 24


public class Main {
    public static void main(String[] args) {
        System.out.println(sum(5, 10));
    }
    
    public static int sum(int a, int b) {
        return a + b;
    }
}
Mi lesz az eredmény? 
a) 15
b) A kód nem fordul le
c) 510
Helyes válasz: a
Magyarázat: A sum metódus összeadja a két paramétert és visszaadja az eredményt, ami 15.
Kérdés 25


class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
    
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
    }
}
Mi lesz az eredmény? 
a) Animal makes a sound
b) Dog barks
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A Dog osztály felüldefiniálja az Animal osztály sound metódusát, így a dinamikus kötés miatt a Dog osztály metódusa fut le.
Kérdés 26


interface Drawable {
    void draw();
}

public class Circle implements Drawable {
    public void draw() {
        System.out.println("Drawing Circle");
    }
    
    public static void main(String[] args) {
        Drawable d = new Circle();
        d.draw();
    }
}
Mi lesz az eredmény? 
a) Drawing Circle
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A Circle osztály implementálja a Drawable interfészt, és a draw metódus meghívásra kerül, ami kiírja a "Drawing Circle" üzenetet.
Kérdés 27


public class Main {
    public static void main(String[] args) {
        int result = multiply(2, 3);
        System.out.println(result);
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}
Mi lesz az eredmény? 
a) 5
b) 6
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A multiply metódus visszaadja a két paraméter szorzatát, ami 6.
Kérdés 28


abstract class Shape {
    abstract void draw();
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing Square");
    }
    
    public static void main(String[] args) {
        Shape s = new Square();
        s.draw();
    }
}
Mi lesz az eredmény? 
a) Drawing Square
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A Square osztály megvalósítja az absztrakt Shape osztály draw metódusát, így a draw metódus meghívása a "Drawing Square" üzenetet írja ki.
Kérdés 29


public class Main {
    public static void main(String[] args) {
        String result = concatenate("Hello", "World");
        System.out.println(result);
    }
    
    public static String concatenate(String a, String b) {
        return a + " " + b;
    }
}
Mi lesz az eredmény? 
a) HelloWorld
b) Hello World
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A concatenate metódus összevonja a két paramétert egy szóközzel elválasztva.
Kérdés 30


public class Main {
    public static void main(String[] args) {
        double result = divide(10, 3);
        System.out.println(result);
    }
    
    public static double divide(int a, int b) {
        return (double) a / b;
    }
}
Mi lesz az eredmény? 
a) 3
b) 3.33
c) 3.0
Helyes válasz: b
Magyarázat: Az egyik operandus explicit double típusra konvertálása miatt a művelet lebegőpontos osztást eredményez.
Kérdés 31


class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
    
    void printName() {
        System.out.println(name);
    }
    
    public static void main(String[] args) {
        Person p = new Person("John");
        p.printName();
    }
}
Mi lesz az eredmény? 
a) John
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A konstruktor beállítja a name mezőt, amit a printName metódus kiír.
Kérdés 32


public class Main {
    static void printNumbers(int... numbers) {
        for(int num : numbers) {
            System.out
4o
-- itt most abbahagytad? A 22. kérdést még be sem fejezeted, és amúgy is, hol van ez a 60 kéréshez?
ChatGPT
4o
Folytatod ? - a 32. kérdést sem fejezted még be...
ChatGPT
Rendben, folytatom a kérdéseket és befejezem a 32. kérdést is.
2. rész: Metódusok és osztályok (folytatás)
Kérdés 32 (befejezés)


public class Main {
    static void printNumbers(int... numbers) {
        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        printNumbers(1, 2, 3, 4, 5);
    }
}
Mi lesz az eredmény? 
a) 1 2 3 4 5
b) 12345
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A varargs paraméterek lehetővé teszik, hogy a metódus tetszőleges számú int argumentumot fogadjon, és mindegyik kiírásra kerül szóközzel elválasztva.
Kérdés 33


class Main {
    int x = 10;

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.x);
    }
}
Mi lesz az eredmény? 
a) 10
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: Az obj példányon keresztül elérjük az x változót, amely 10 értékkel van inicializálva.
Kérdés 34


public class Main {
    static int x = 10;

    public static void main(String[] args) {
        x = 20;
        System.out.println(x);
    }
}
Mi lesz az eredmény? 
a) 10
b) 20
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A main metódusban a static változó értéke 20-ra változik.
Kérdés 35


public class Main {
    static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        printMessage("Hello, World!");
    }
}
Mi lesz az eredmény? 
a) Hello, World!
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A printMessage metódus meghívásra kerül a "Hello, World!" argumentummal, és kiírja azt.
Kérdés 36


interface Greetable {
    void greet();
}

public class Main {
    public static void main(String[] args) {
        Greetable g = () -> System.out.println("Hello!");
        g.greet();
    }
}
Mi lesz az eredmény? 
a) Hello!
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A lambda kifejezés implementálja a greet metódust, amely kiírja a "Hello!" üzenetet.
Kérdés 37


public class Main {
    int x = 10;

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.x);
    }
}
Mi lesz az eredmény? 
a) 10
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: Az obj példányon keresztül elérjük az x változót, amely 10 értékkel van inicializálva.
Kérdés 38


public class Main {
    public static void main(String[] args) {
        String result = concatenate("Hello", "World");
        System.out.println(result);
    }

    public static String concatenate(String a, String b) {
        return a + b;
    }
}
Mi lesz az eredmény? 
a) HelloWorld
b) Hello World
c) A kód nem fordul le
Helyes válasz: a
Magyarázat: A concatenate metódus összevonja a két paramétert szóköz nélkül.
Kérdés 39


public class Main {
    public static void main(String[] args) {
        double result = divide(10, 2);
        System.out.println(result);
    }

    public static double divide(int a, int b) {
        return a / b;
    }
}
Mi lesz az eredmény? a) 5.0
b) 5
c) 5.00
Helyes válasz: a
Magyarázat: Az egész számok osztása után a visszatérési érték double típusú, így az eredmény 5.0 lesz.
Kérdés 40


class Main {
    static int x = 10;

    public static void main(String[] args) {
        Main obj1 = new Main();
        Main obj2 = new Main();
        obj1.x = 20;
        System.out.println(obj2.x);
    }
}
Mi lesz az eredmény? 
a) 10
b) 20
c) A kód nem fordul le
Helyes válasz: b
Magyarázat: A static változó megosztott az összes példány között, így ha az egyik példány megváltoztatja az értékét, az az összes példányra kihat.
3. rész: Fájlkezelés és JDBC
Kérdés 41


import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) File created
b) File already exists
c) A kód nem fordul le
Helyes válasz: a vagy b
Magyarázat: Ha a "test.txt" fájl nem létezik, akkor létrejön és kiírja "File created". Ha már létezik, akkor "File already exists" üzenetet ír ki.
Kérdés 42


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write("Hello, World!");
            writer.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? a) Successfully wrote to the file
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A FileWriter sikeresen ír a fájlba és bezárja azt.
Kérdés 43


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) A fájl tartalmát írja ki
b) A kód nem fordul le
c) FileNotFoundException dobódik
Helyes válasz: a
Magyarázat: A Scanner olvassa a fájl tartalmát és kiírja soronként.
Kérdés 44


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("test.txt")));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) A fájl tartalmát írja ki
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A Files.readAllBytes olvassa a fájl tartalmát és stringként visszaadja.
Kérdés 45


import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted");
            } else {
                System.out.println("Failed to delete the file");
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}
Mi lesz az eredmény? 
a) File deleted
b) Failed to delete the file
c) File does not exist
Helyes válasz: a vagy b vagy c
Magyarázat: Az eredmény attól függ, hogy a fájl létezik-e, és sikeresen törölhető-e.
Kérdés 46


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            if (conn != null) {
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Connected to the database
b) Failed to connect to the database
c) SQLException dobódik
Helyes válasz: a vagy b vagy c
Magyarázat: Az eredmény attól függ, hogy sikeresen létrejön-e a kapcsolat az adatbázissal.
Kérdés 47


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE Students (id INT PRIMARY KEY, name VARCHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Table created
b) A kód nem fordul le
c) SQLException dobódik
Helyes válasz: a
Magyarázat: A Statement létrehoz egy új táblát az adatbázisban.
Kérdés 48


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Students (id, name) VALUES (1, 'John Doe')";
            stmt.executeUpdate(sql);
            System.out.println("Record inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Record inserted
b) A kód nem fordul le
c) SQLException dobódik
Helyes válasz: a
Magyarázat: A Statement beszúr egy új rekordot az Students táblába.
Kérdés 49


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) A táblában lévő összes rekordot kiírja
b) A kód nem fordul le
c) SQLException dobódik
Helyes válasz: a
Magyarázat: A ResultSet olvassa az Students tábla összes rekordját és kiírja azokat.
Kérdés 50


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Students SET name='Jane Doe' WHERE id=1";
            stmt.executeUpdate(sql);
            System.out.println("Record updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Record updated
b) A kód nem fordul le
c) SQLException dobódik
Helyes válasz: a
Magyarázat: A Statement frissíti a Students tábla egyik rekordját.
Kérdés 51


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Students WHERE id=1";
            stmt.executeUpdate(sql);
            System.out.println("Record deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Record deleted
b) A kód nem fordul le
c) SQLException dobódik
Helyes válasz: a
Magyarázat: A Statement törli az Students tábla egyik rekordját.
Kérdés 52


abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
    
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
    }
}
Mi lesz az eredmény? 
a) Drawing Circle
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A Circle osztály megvalósítja az absztrakt Shape osztály draw metódusát, így a draw metódus meghívása a "Drawing Circle" üzenetet írja ki.
Kérdés 53


interface Drawable {
    void draw();
}

public class Main {
    public static void main(String[] args) {
        Drawable d = () -> System.out.println("Drawing");
        d.draw();
    }
}
Mi lesz az eredmény? 
a) Drawing
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A lambda kifejezés implementálja a draw metódust, amely kiírja a "Drawing" üzenetet.
Kérdés 54


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
            System.out.println("File copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) File copied
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A fájl tartalmát byte-onként olvassa és írja át egy másik fájlba, majd kiírja "File copied".
Kérdés 55


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) A fájl tartalmát írja ki
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A BufferedReader olvassa a fájl tartalmát és kiírja soronként.
Kérdés 56


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            writer.write("Hello, World!");
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) Successfully wrote to the file
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A BufferedWriter sikeresen ír a fájlba és kiírja a "Successfully wrote to the file" üzenetet.
Kérdés 57


interface Movable {
    void move();
}

abstract class Vehicle implements Movable {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started");
    }

    public void move() {
        System.out.println("Car is moving");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.move();
    }
}
Mi lesz az eredmény? 
a) Car started Car is moving
b) A kód nem fordul le
c) Nincs kimenet
Helyes válasz: a
Magyarázat: A Car osztály implementálja a Vehicle osztály start és move metódusait, így mindkettő meghívása kiírja a megfelelő üzeneteket.
Kérdés 58


import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("test.txt");
        try {
            Files.deleteIfExists(path);
            System.out.println("File deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) File deleted
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A Files.deleteIfExists törli a fájlt, ha létezik, és kiírja a "File deleted" üzenetet.
Kérdés 59


import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("test.txt");
        try {
            long size = Files.size(path);
            System.out.println("File size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) A fájl méretét írja ki
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A Files.size visszaadja a fájl méretét byte-ban, amely kiírásra kerül.
Kérdés 60


import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("target.txt");
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
Mi lesz az eredmény? 
a) File copied
b) A kód nem fordul le
c) IOException dobódik
Helyes válasz: a
Magyarázat: A Files.copy a source.txt fájlt másolja a target.txt fájlba, ha sikeres, kiírja a "File copied" üzenetet.
