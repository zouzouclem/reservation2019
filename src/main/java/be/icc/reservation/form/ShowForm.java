package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ShowForm
{
    private Integer id;

    @Size(min=3, max=30)
    @NotBlank(message = "{error.common.slug}")
    private String slug;
    @NotBlank(message = "{error.common.title}")
    @Size(min=3, max=50)
    private String title;

    @NotBlank(message = "{error.common.posterURL}")
    private String posterURL;
    @NotNull(message = "{error.common.location}")
    private int location;
    @NotNull
    private boolean bookable;

    @NotNull(message = "{error.common.price}")
    @NumberFormat(style= NumberFormat.Style.NUMBER)
    @Min(value = 1)
    private BigDecimal price;

    @NotBlank(message = "{error.common.description}")
    private String description;

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

    public String getDescription(){ return description; }

    public void setDescription(String description) { this.description = description; }
}