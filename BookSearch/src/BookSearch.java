import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch{
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();

        while(true){
            System.out.print("Nomnii ner: ");
            String title = scanner.nextLine();

            if(title.equalsIgnoreCase("garah")){
                break;
            }

            System.out.print("Zohiogch: ");
            String author = scanner.nextLine();

            System.out.print("Hevlesen on: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book(title, author, year);
            books.add(book);
        }

        System.out.print("Nomnuud: \n");
        for(Book book : books){
            System.out.println(book);
        }

        System.out.print("Haih nomnii neree oruulna uu: ");
        String search = scanner.nextLine();

        boolean found = false;
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(search)){
                System.out.println(book);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Tanii oruulsan nertei nom baihgui bna.");
        }

        scanner.close();
    }
} 

class Book{
    
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString(){
        return title + " - " + author + " -" + year;
    }
}