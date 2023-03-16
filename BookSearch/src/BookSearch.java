    import java.util.ArrayList;
    import java.util.Scanner;

    public class BookSearch{
        
        public static void main(String[] args){
            
            Scanner scanner = new Scanner(System.in);
            ArrayList<Book> books = new ArrayList<Book>();

            while(true){

                System.out.print("Delguuriin ner: ");
                String store = scanner.nextLine();
                if(store.equalsIgnoreCase("garah")){
                    break;
                }

                System.out.print("Nomnii ner: ");
                String title = scanner.nextLine();

                System.out.print("Zohiogch: ");
                String author = scanner.nextLine();

                System.out.print("Hevlesen on: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                Book book = new Book(store,title, author, year);
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
                    System.out.println("Tanii haisan nom oldloo.");
                    System.out.println("Tanii haisan nom " + book.getStore() + " delguurt baina.");
                    System.out.println("Tanii haisan nomiig " + book.getAuthor() + " bichsen.");                  
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
        
        private String store;
        private String title;
        private String author;
        private int year;

        public Book(String store,String title, String author, int year){
            this.store = store;
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getStore(){
            return store;
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

        public String toString(){
            return store + " - " + title + " - " + author + " - " + year;
        }
    }
