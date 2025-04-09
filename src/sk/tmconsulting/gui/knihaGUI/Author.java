package sk.tmconsulting.gui.knihaGUI;

public class Author {
    private String name;
    private String bio;
    private int age;
    private String dateofbirth;
    private String gender;

    public Author(String name, String bio, int age, String dateofbirth, String gender) {
        this.name = name;
        this.bio = bio;
        this.age = age;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }
    public int getAge(){
        return age;
    }
    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }
}
