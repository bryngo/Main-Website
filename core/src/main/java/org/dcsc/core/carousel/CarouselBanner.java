package org.dcsc.core.carousel;


import org.dcsc.utilities.image.Image;

import javax.persistence.*;

@Entity
@Table(name = "dcsc_carousel", schema = "public")
public class CarouselBanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private long id;

    @Column(name = "caption")
    private String caption;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "precedence")
    private int order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
