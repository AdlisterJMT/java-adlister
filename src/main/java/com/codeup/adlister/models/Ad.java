package com.codeup.adlister.models;

//@Entity
//@Table(name="ads")

public class Ad {

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="ads_categories",
//            joinColumns={@JoinColumn(name="ad_id")},
//            inverseJoinColumns={@JoinColumn(name="category_id")}
//    )
//    private List<AdCategory> categories;
//}

    private long id;
    private long userId;
    private String title;
    private String description;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;

    }


    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
