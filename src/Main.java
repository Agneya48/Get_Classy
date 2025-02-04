import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> folks = new ArrayList<>();
        Person test1 = new Person ("000001", "Test", "Test", "Mr", 1999);
        folks.add(test1);
        Person bilbo = new Person("Bilbo", "Baggins",
                "Esq.", 1150);

        folks.add(bilbo);

        Person frodo = new Person("Frodo", "Baggins", "Esq.", 1200);
        folks.add(frodo);

        Person sam = new Person("Samwise", "Gamgee", "Esq.", 1201);
        folks.add(sam);

        System.out.println(bilbo.getFirstName());
        System.out.println(bilbo.getIDNum());
        System.out.println(bilbo.getLastName());



        bilbo.setLastName("Waggins");
        System.out.println(bilbo.getLastName());

        System.out.println(frodo.fullName());
        System.out.println(sam.formalName());

        System.out.println(bilbo.getAge());
        System.out.println(bilbo.getAge(1300));

        for(Person p: folks) {
            System.out.println(p);
        }
        System.out.println(folks);
        for(var p: folks) {
            System.out.println(p.toCSVRecord());
        }

        String cvsTest1, cvsTest2, cvsTest3;
        cvsTest1 = "";
        cvsTest2 = "1";
        cvsTest3 = "";
        String div = ",";
        String result = cvsTest1 + div + cvsTest2 + div + cvsTest3;
        System.out.println(result);

        String result2 = String.join(cvsTest1, div, cvsTest3, div, cvsTest2);
        System.out.println(result2);

        ArrayList<Product> goods = new ArrayList<>();
        Product apple = new Product("apple", "red fruit", 1.99);
        goods.add(apple);
        Product orange = new Product("orange", "orange fruit", 1.25);
        goods.add(orange);
        Product banana = new Product("banana", "yellow fruit", 1.00);
        goods.add(banana);

        for (Product p: goods) {
            System.out.println(p);
        }
        System.out.println(goods);
        for (Product p: goods) {
            System.out.println(p.toString());
        }

        for (var p: goods) {
            System.out.println(p.toCSVRecord());
        }
        for (var p: folks) {
            System.out.println(p.toCSVRecord());
        }
        for (var p: goods) {
            System.out.println(p.toJSONRecord());
        }
        for (var p: folks) {
            System.out.println(p.toJSONRecord());
        }
        for (var p: goods) {
            System.out.println(p.toXMLRecord());
        }
        for (var p: folks) {
            System.out.println(p.toXMLRecord());
        }
    }
}