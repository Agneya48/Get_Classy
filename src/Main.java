import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> folks = new ArrayList<>();
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
    }
}