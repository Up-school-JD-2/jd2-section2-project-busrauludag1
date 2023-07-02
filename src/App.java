package src;

public class App {
    private final String name;
    private final String version;

    private final String fullName;
    private final int memory;

    public App(String name, String version, int memory) {
        this.name = name;
        this.version = version;
        this.memory = memory;
        this.fullName = name + "_" + version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getMemory() {
        return memory;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", memory=" + memory +
                '}';
    }
}
