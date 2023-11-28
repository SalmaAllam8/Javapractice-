import java.util.ArrayList;

public class BookShelf {



    ArrayList<Book> books = new ArrayList<Book>();


    public  void addbook(Book book){

        books.add(book);
    }


    public void Request(Long userid,String bookname, String start, String end){


        assert !books.isEmpty(): "No books are available right now ";
        for(Book book: books){

            if(book.title.equals(bookname)&&book.available.equals(true)){

                book.available = false;
                book.setBorrowingstart(start);
                book.setBorrowingend(end);
                book.userId = userid;

                break;

            }else {

                System.out.println("Book is unavailable right now");
            }

        }



    }


    public void  handback(Book book){


        for( Book bookk:books){

            if(bookk.id.equals(book.id)){

                bookk.available =true;
                bookk.borrowingstart = null;
                bookk.borrowingend =null;
                bookk.userId = null;
            }
        }
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "books=" + books.toString() +
                '}';
    }
}
