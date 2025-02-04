import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    Person p1, p2, p3, p4, p5, p6;



    @BeforeEach
    void setUp() {
        Person.setIDSeed(1);
        p1 = new Person("000001", "Bob", "Tester1", "Mr.", 1999);
        p2 = new Person("000002", "Sally", "Tester2", "Ms.", 1990);
        p3 = new Person("Josh", "Tester3", "Mr.", 1993);
        p4 = new Person( "Sally", "Tester4", "Mrs.", 1995);
        p5 = new Person( "Alyssa", "Tester5", "Mrs.", 1997);
        p6 = new Person( "Erika", "Tester6", "Ms.", 2000);

    }

    @Test
    void getIDSeed() {
        assertEquals(7, Person.getIDSeed());
    }

    @Test
    void fullName() {
        assertEquals("Bob Tester1", p1.fullName());
        assertEquals("Sally Tester2", p2.fullName());
        assertEquals("Josh Tester3", p3.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. Bob Tester1", p1.formalName());
        assertEquals("Ms. Sally Tester2", p2.formalName());
        assertEquals("Mr. Josh Tester3", p3.formalName());
    }

    @Test
    void setIDSeed() {
        Person.setIDSeed(10);
        assertEquals(10, Person.getIDSeed());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("123456");
        assertEquals("123456", p1.getIDNum());
        
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Robert");
        assertEquals("Robert", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p2.setLastName("Johnson");
        assertEquals("Johnson", p2.getLastName());
    }

    @Test
    void setTitle() {
        p3.setTitle("Dr.");
        assertEquals("Dr.", p3.getTitle());
    }

    @Test
    void setYOB() {
        p4.setYOB(2001);
        assertEquals(2001, p4.getYOB());
    }

    @Test
    void testToString() {
        assertEquals("Person{IDNum='000001', firstName='Bob', lastName='Tester1', title='Mr.', YOB=1999}", p1.toString());
        assertEquals("Person{IDNum='000002', firstName='Sally', lastName='Tester2', title='Ms.', YOB=1990}", p2.toString());
        
                
    }

    @Test
    void testEquals() {
        assertNotEquals(p1, p2);
        Person p7 = new Person("000001", "Bob", "Tester1", "Mr.", 1999);
        assertEquals(p1, p7);
    }

    @Test
    void toJSONRecord() {
        assertEquals("{\"IDNum\":\"000001\", \"firstName\":\"Bob\", \"lastName\":\"Tester1\", \"title\":\"Mr.\", \"YOB\":1999}", p1.toJSONRecord());
        assertEquals("{\"IDNum\":\"000002\", \"firstName\":\"Sally\", \"lastName\":\"Tester2\", \"title\":\"Ms.\", \"YOB\":1990}", p2.toJSONRecord());

    }

    @Test
    void toXMLRecord() {
        assertEquals("<Person><IDNum>000001</IDNum><firstName>Bob</firstName><lastName>Tester1</lastName><YOB>1999</YOB></Person>", p1.toXMLRecord());
        assertEquals("<Person><IDNum>000002</IDNum><firstName>Sally</firstName><lastName>Tester2</lastName><YOB>1990</YOB></Person>", p2.toXMLRecord());
    }


    @Test
    void toCSVRecord() {
        assertEquals("000001,Bob,Tester1,Mr.,1999", p1.toCSVRecord());
        assertEquals("000002,Sally,Tester2,Ms.,1990", p2.toCSVRecord());
        assertEquals("000003,Josh,Tester3,Mr.,1993", p3.toCSVRecord());
        assertEquals("000004,Sally,Tester4,Mrs.,1995", p4.toCSVRecord());
    }
}