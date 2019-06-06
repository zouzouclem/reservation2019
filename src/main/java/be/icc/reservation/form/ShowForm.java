package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ShowForm
{
    private Integer id;
    @Size(min=3, max=30)
    private String slug;
    @NotBlank(message = "Ce champ ne peut pas rester vide")
    @Size(min=3, max=50)
    private String title;

    private String posterURL;
    @NotNull
    private int location;
    @NotNull
    private boolean bookable;
    @NotNull
    @NumberFormat(style= NumberFormat.Style.NUMBER)
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