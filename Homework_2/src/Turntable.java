/**
 * Класс виниловой вертушки
 */
public class Turntable extends Player {

    public Turntable(String name) {
        super(name);
    }

    @Override
    public void loadStorageDevice(StorageDevice storageDevice) {
        if (storageDevice instanceof Record) {
            this.storageDevice = storageDevice;
            System.out.println("Пластинка успешно прочитана");
        } else {
            System.out.println("Ошибка: Виниловая вертушка может прочитать только пластинку");
        }
    }
}
