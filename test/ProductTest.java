import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4;

    @BeforeEach
    void setUp() {
        Product.setIDSeed(1);
        p1 = new Product("apple", "red fruit", 1.25);
        p2 = new Product("orange", "orange fruit", 1.75);
        p3 = new Product("banana", "yellow fruit", 1.75);
        p4 = new Product("pear", "green fruit", 2.0);
    }


    @Test
    void setIDNum() {
        p1.setIDNum("123456");
        assertEquals("123456", p1.getIDNum());
    }

    @Test
    void setName() {
        p1.setName("pear");
        assertEquals("pear", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("green fruit");
        assertEquals("green fruit", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(2.0);
        assertEquals(2.0, p1.getCost());
    }

    @Test
    void testToString() {
        assertEquals("Product{IDNum='000001', name='apple', description='red fruit', cost='1.25'}", p1.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(p1, p2);
        Product p7 = new Product("apple", "red fruit", 1.25);
        assertEquals(p2.getCost(), p3.getCost());
    }

    @Test
    void toJSONRecord() {
        assertEquals("{\"IDNum\":\"000001\",\"name\":\"apple\", \"description\":\"red fruit\", \"cost\":\"1.25}", p1.toJSONRecord());
    }

    @Test
    void toXMLRecord() {
        assertEquals("<Product><IDNum>000001</IDNum><name>apple</name><description>red fruit</description><cost>1.25</cost></Product>", p1.toXMLRecord());
    }

    @Test
    void toCSVRecord() {

            assertEquals("000001,apple,red fruit,1.25", p1.toCSVRecord());
            assertEquals("000002,orange,orange fruit,1.75", p2.toCSVRecord());
            assertEquals("000003,banana,yellow fruit,1.75", p3.toCSVRecord());
            assertEquals("000004,pear,green fruit,2.0", p4.toCSVRecord());

    }
}