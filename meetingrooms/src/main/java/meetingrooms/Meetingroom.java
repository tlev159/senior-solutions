package meetingrooms;

public class Meetingroom {

    private long id;

    private String name;

    private int with;

    private int length;

    public Meetingroom(String name, int with, int length) {
        this.name = name;
        this.with = with;
        this.length = length;
    }

    public Meetingroom(long id, String name, int with, int length) {
        this.id = id;
        this.name = name;
        this.with = with;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWith() {
        return with;
    }

    public int getLength() {
        return length;
    }

    public long getArea() {
        return with * length;
    }

    @Override
    public String toString() {
        return "Meetingroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", with=" + with +
                ", length=" + length +
                '}';
    }
}
