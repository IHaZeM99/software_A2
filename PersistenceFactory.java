public class PersistenceFactory {

    public static IpersistanceMechanism loadMechanism(String type) {
        return switch (type.toLowerCase()) {
//            case "sql" -> new SQLPersistence();
//            case "json" -> new JSONPersistence();
            case "text" -> new TextPersistence("users.txt");
            default -> throw new IllegalArgumentException("Unsupported persistence type: " + type);
        };
    }
}
