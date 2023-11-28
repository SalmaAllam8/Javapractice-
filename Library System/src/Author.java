public class Author {

    String name;

    String biography;

    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public void getauthorinfo() {

        System.out.println(name + ":" + biography);
    }

}
