package Junho.실습문제.annotation.notNullAnnotation;


@NotNull
class Book{
    private String name;
    private String author;
    private Integer price;
    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
public class NotNullTest {
    public static void main(String[] args)  {
        Book book = new Book("소설", null, 1000);
        try {
            NotNullValidator.validate(book);
        }catch (IllegalArgumentException  | IllegalAccessException e){
            e.printStackTrace();
        }
//        NotNullValidator.printValue(book);
    }

}
