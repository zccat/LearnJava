package zx.learn.jdbc;

public class Website {

    int id;
    String name;
    String url;
    int alexa;
    String country;

    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", alexa=" + alexa +
                ", country='" + country + '\'' +
                '}';
    }
}
