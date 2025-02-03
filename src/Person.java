import java.util.Calendar;

/**
 * Represents a person with details such as ID number, first name, last name, title,
 * and year of birth (YOB). Provides methods to retrieve and manipulate these details
 * as well as generate Strings for subsequent saving in JSON, XML, and CSV formats.
 * Currently, no support for blank or null entries aside from ID, until I know how
 * the file formats handle that.
 *
 * @author: Josh Hampton
 */
public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDSeed = 1;


    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /* Elected to not include support for more overloaded functions yet besides the dropped
    IDNum, since I'm not sure how null or blank values are handled in CVS formatting.
     */


    /**
     *returns the person's full name
     *
     * @return firstName + space + lastName
     */
    public String fullName() {
        return firstName + " " + lastName;
    }


    /**
     * Constructs and returns the formal name of the person.
     * The formal name consists of the person's title followed by their full name.
     *
     * @return title + space + fullName
     */
    public String formalName() {
        return title + " " + this.fullName();
    }

    /**
     * Calculates and returns the current age of the person based on the year of birth
     * and the calendar year
     *
     * @return A String of the person's current age
     */
    public String getAge() {
        Calendar cal = Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - this.YOB;
        return Integer.toString(age);
    }


    /**
     * Calculates and returns the age of the person based on their YOB and
     * the given year
     *
     * @param year int year to calculate the age from
     * @return a String for the age of the person at the given year
     */
    public String getAge(int year) {
        return Integer.toString(year - this.YOB);
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    private String genIDNum() {
        String newID = "" + IDSeed;
        while(newID.length() < 6)
        {
            newID = "0" + newID;
        }

        IDSeed++;

        return newID;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && IDNum.equals(person.IDNum) && firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) && title.equals(person.title);
    }


    /**
     * Converts the Person object into a JSON-formatted String
     * This includes the IDNum, firstName, lastName, title, and year of birth (YOB)
     * Unknown support for null values
     *
     * @return a String in JSON format
     */
    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ", ";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + this.YOB + "}";

        return retString;
    }


    /**
     * Converts the Person object into an XML-formatted String
     * Output includes the IDNum, firstName, lastName,title, and year of birth (YOB)
     * of the person, encapsulated within appropriate XML tags.
     * Unknown support for null values
     *
     * @return a string representing the Person object in XML format
     */
    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Person>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<YOB>" + this.YOB + "</YOB></Person>";

        return retString;
    }

    /**
     * Converts the Person object into a CSV-formatted String.
     * The returned string contains the IDNum, firstName, lastName, title,
     * and year of birth (YOB) fields, separated by commas.
     * Not sure how this handles blank or null values, so requiring all entries
     * to be filled for now.
     *
     * @return a string representing the Person object in CSV format
     */
    public String toCSVRecord() {
        String div = ",";
        return  this.IDNum + div + this.firstName + div + this.lastName + div +
                this.title + div + this.YOB;
    }
}
