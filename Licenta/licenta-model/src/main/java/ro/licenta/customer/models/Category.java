package ro.licenta.customer.models;

public enum Category {

    ART,JEWELRY,COLLECTABLES,
    ESTATE,FASHION,VEHICLES;

    public static Category getCategoryByName(final String categoryName) {
        return Category.valueOf(categoryName.toUpperCase());
    }
}
