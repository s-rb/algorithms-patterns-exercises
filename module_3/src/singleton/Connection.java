package singleton;

// Для примера Connection
// Соединение с БД, создание тяжелых объектов, драйверы устройств, логгеры, кэши,
// Переменная volatile и синхронизация - для многопоточки
public class Connection {

    private static volatile Connection instance;

    private Connection() {} // Чтобы снаружи нельзя было создать

    public static Connection getInstance() {

        if (instance == null) {
            synchronized (Connection.class) {
                if (instance == null) {
                    instance = new Connection();
                }
            }
        }
        return instance;
    }
}
