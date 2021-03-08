/**
 * Общий абстрактный класс для звуковоспроизводящих устройств
 */
public abstract class Player {

    protected StorageDevice storageDevice;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void play() {
        if (storageDevice != null) {
            System.out.println("Название звуковоспроизводящего устройства: " + name);
            if (storageDevice.getSong() != null) {
                System.out.println(storageDevice.getSong());
            } else {
                System.out.println("Носитель пуст");
            }
        } else {
            System.out.println("Ошибка: Носитель не загружен");
        }
    }

    public abstract void loadStorageDevice(StorageDevice storageDevice);

}
