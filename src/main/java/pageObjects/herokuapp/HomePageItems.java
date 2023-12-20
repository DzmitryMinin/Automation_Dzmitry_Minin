package pageObjects.herokuapp;

public enum HomePageItems {

    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls");
    private final String item;

    HomePageItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
