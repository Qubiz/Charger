package project.o.charger.planners;

/**
 * Created by Mathijs on 17-3-2016.
 */
public class Planner {

    private int id;
    private String name;
    private String creator;

    public Planner(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return ("Planner [id= " + id + ",name= " + name + ", creator= " + creator + "]");
    }
}
