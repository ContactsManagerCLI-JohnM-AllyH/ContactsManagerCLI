package menu;

public class MenuItem implements Action {
    private String description;

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
