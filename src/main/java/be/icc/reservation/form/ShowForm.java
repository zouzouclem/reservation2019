package be.icc.reservation.form;

public class ShowForm
{
    private Integer id;
    private String slug;
    private String title;
    private String posterURL;
    private boolean bookable;
    private float price;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSlug()
    {
        return slug;
    }

    public void setSlug(String slug)
    {
        this.slug = slug;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPosterURL()
    {
        return posterURL;
    }

    public void setPosterURL(String posterURL)
    {
        this.posterURL = posterURL;
    }

    public boolean isBookable()
    {
        return bookable;
    }

    public void setBookable(boolean bookable)
    {
        this.bookable = bookable;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
}