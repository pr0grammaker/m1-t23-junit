package sprint5.shiplt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    static final Scanner scanner = new Scanner(System.in);
    private final static List<Parcel> allParcels = new ArrayList<>();

    private final static List<FragileParcel> fragileParcels = new ArrayList<>();

    static ParcelBox standartBox = new ParcelBox(100);
    static ParcelBox perishableBox = new ParcelBox(50);
    static ParcelBox fragileBox = new ParcelBox(35);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    System.out.println("Введите текущий день:");
                    int currentDay = scanner.nextInt();
                    scanner.nextLine();
                    sendParcels(currentDay);
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    System.out.println("Введите новую локацию для посылок:");
                    String newLocation = scanner.nextLine();
                    for (Parcel parcel : allParcels) {
                        if (parcel instanceof FragileParcel) {
                            ((FragileParcel) parcel).reportStatus(newLocation);
                        } else {
                            System.out.println("Данный тип посылок отсутствует!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("""
                            Выберите тип коробки: 
                            1.Стандартная 
                            2.Скоропортещаяся
                            3.Хрупкая
                            """);
                    int typeBox = scanner.nextInt();
                    scanner.nextLine();
                    List<Parcel> parcels;
                    if (typeBox == 1) {
                        parcels = standartBox.getAllParcels();
                    } else if (typeBox == 2) {
                        parcels = perishableBox.getAllParcels();
                    } else if (typeBox == 3) {
                        parcels = fragileBox.getAllParcels();
                    } else {
                        System.out.println("Такой тип не поддерживается!");
                        return;
                    }

                    if (parcels.isEmpty()){
                        System.out.println("Коробка пуста!");
                    } else{
                        for (Parcel parcel : parcels) {
                            System.out.println(parcel.getDescription());
                        }
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить все поссылки поддерживающие трекинг");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("""
                Для добавления поссылки введите необходимые поля:
                1.Описание;
                2.Вес;
                3.Адрес доставки;
                4.День отправки;
                """);
        System.out.println("Название вашей поссылки?");
        String discription = scanner.nextLine();
        System.out.println("Вес вашей поссылки?");
        int weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Адрес доставки вашей поссылки?");
        String deliveryAddress = scanner.nextLine();
        System.out.println("День отправки вашей поссылки?");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("""
                Тип вашей поссылки?
                1.Стандартная 
                2.Скоропортещаяся
                3.Хрупкая
                """);
        int type = scanner.nextInt();
        scanner.nextLine();
        int timeToLive = 0;
        ParcelType parcelType;
        if (type == 1) {
            parcelType = ParcelType.STANDART;
        } else if (type == 2) {
            parcelType = ParcelType.PERISHABLE;
            System.out.println("Cколько дней посылка может храниться?");
            timeToLive = scanner.nextInt();
            scanner.nextLine();

        } else if (type == 3) {
            parcelType = ParcelType.FRAGILE;
        } else {
            System.out.println("Такой тип не поддерживается!");
            return;
        }

        if (parcelType == ParcelType.STANDART) {
            StandardParcel standardParcel = new StandardParcel(discription, weight, deliveryAddress, sendDay, parcelType);
            allParcels.add(standardParcel);
            standartBox.addParcel(standardParcel);

        } else if (parcelType == ParcelType.PERISHABLE) {
            PerishableParcel perishableParcel = new PerishableParcel(discription, weight, deliveryAddress, sendDay,
                    parcelType, timeToLive);
            allParcels.add(perishableParcel);
            perishableBox.addParcel(perishableParcel);

        } else if (parcelType == ParcelType.FRAGILE) {
            FragileParcel fragileParcel = new FragileParcel(discription, weight, deliveryAddress, sendDay, parcelType);
            fragileParcels.add(fragileParcel);
            allParcels.add(fragileParcel);
            fragileBox.addParcel(fragileParcel);
        }
    }

    private static void sendParcels(int currentDay) {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parsel : allParcels) {
            if (parsel instanceof PerishableParcel) {
                if (((PerishableParcel) parsel).isExpired(currentDay)) {
                    System.out.printf("Посылка ПРОСРОЧЕНА и не отправлена: %s", parsel.getDescription());
                    System.out.println();
                    continue;
                }
            }
            parsel.packageItem();
            System.out.println();
            parsel.deliver();
            System.out.println();
        }
        System.out.println();
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parsel : allParcels) {
            sum += parsel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок составила " + sum);
    }

}

