import java.util.Comparator;
import java.util.List;

public class Main {
    record Section(String name, int priority, int minWidth) {}

    public static void main(String[] args) {
        int viewportWidth = 1280;
        List<Section> sections = List.of(
                new Section("Hero", 1, 900),
                new Section("About", 2, 700),
                new Section("Projects", 1, 1000),
                new Section("Skills", 3, 600),
                new Section("Contact", 2, 500));

        System.out.println("=== Portfolio Layout Planner ===");
        System.out.println("Viewport: " + viewportWidth + "px");

        sections.stream()
                .sorted(Comparator.comparingInt(Section::priority))
                .forEach(section -> {
                    String layout = viewportWidth >= section.minWidth() ? "two-column possible" : "single-column";
                    System.out.printf("%-10s priority=%d -> %s%n", section.name(), section.priority(), layout);
                });
    }
}
