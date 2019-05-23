package be.icc.reservation.form;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ShowForm
{
    private Integer id;
    @Size(min=3)
    private String slug;
    @Size(min=5)
    private String title;
    @NotNull
    private String posterURL;
    @NotNull
    private int location;
    @NotNull
    private boolean bookable;
    @NotNull
    private BigDecimal price;

    public Integer getId()
    {
        return id;
    }

    public int getLocation()
    {
        return location;
    }

    public void setLocation(int location)
    {
        this.location = location;
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

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
}