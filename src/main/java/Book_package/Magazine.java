package Book_package;

import java.util.Date;

public class Magazine extends Book {
    final private String series_name;
    final private String category;


    public Magazine(int book_id, String book_name, String ISBN, Date publishDate, String author,
                    Book_position_status status, Date returnDate, String series_name, String category) {
        super(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        this.series_name = series_name;
        this.category = category;
    }

    public String getSeries_name(){ return  series_name; }

    public String getCategory(){ return  category; }
}
