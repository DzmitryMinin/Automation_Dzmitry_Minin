package pageObjects.herokuapp;

public enum HomePageItems {

    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    SORTABLE_DATA_TABLES("Sortable Data Tables");
    private final String item;

    HomePageItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
