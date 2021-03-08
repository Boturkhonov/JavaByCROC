/**
 * Класс CD плеера
 */
public class CDPlayer extends Player {
    public CDPlayer(String name) {
        super(name);
    }

    @Override
    public void loadStorageDevice(StorageDevice storageDevice) {
        if (storageDevice instanceof CD) {
            this.storageDevice = storageDevice;
            System.out.println("Диск успешно прочитан");
        } else {
            System.out.println("Ошибка: CD плеер может прочитать только CD диск");
        }
    }
}
