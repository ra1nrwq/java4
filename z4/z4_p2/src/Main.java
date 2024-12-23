import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Меню выбора задания
            System.out.println("Выберите задание:");
            System.out.println("1. Система управления библиотекой");
            System.out.println("2. Система учета автомобилей");
            System.out.println("3. Выход");
            System.out.print("Введите номер задания: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим буфер от лишнего символа новой строки

            switch (choice) {
                case 1:
                    librarySystem();
                    break;
                case 2:
                    carSystem();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close(); // Закрытие сканнера после завершения работы программы
    }

    // Задание 1: Система управления библиотекой
    public static void librarySystem() {
        System.out.println("Вы выбрали систему управления библиотекой.");
        // Создаем библиотеку, книги и читателя
        Library library = new Library();
        Book book1 = new Book("1984", "Джордж Оруэлл");
        Book book2 = new Book("Гарри Поттер", "Джоан Роулинг");
        library.addBook(book1);
        library.addBook(book2);

        Reader reader = new Reader("Жанибек");

        library.displayAvailableBooks();
        reader.checkoutBook(book1);
        reader.displayInfo();
        library.displayAvailableBooks();
    }

    // Задание 2: Система учета автомобилей
    public static void carSystem() {
        System.out.println("Вы выбрали систему учета автомобилей.");
        // Создаем автопарк, автомобили и водителя
        CarPark carPark = new CarPark();
        Car car1 = new Car("747ABC", "Toyota Camry");
        Car car2 = new Car("668AID", "Honda Accord");
        carPark.addCar(car1);
        carPark.addCar(car2);

        Driver driver = new Driver("Махмет");
        carPark.displayAvailableCars();
        driver.rentCar(car1);
        driver.displayInfo();
        carPark.displayAvailableCars();
    }
}

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public void checkout() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println("Книга \"" + title + "\" теперь на руках.");
        } else {
            System.out.println("Книга \"" + title + "\" уже на руках.");
        }
    }

    public void checkin() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println("Книга \"" + title + "\" возвращена в библиотеку.");
        } else {
            System.out.println("Книга \"" + title + "\" уже в библиотеке.");
        }
    }

    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Доступна: " + (isCheckedOut ? "Нет" : "Да"));
    }
}

class Reader {
    private String name;
    private java.util.List<Book> checkedOutBooks;

    public Reader(String name) {
        this.name = name;
        this.checkedOutBooks = new java.util.ArrayList<>();
    }

    public void checkoutBook(Book book) {
        book.checkout();
        checkedOutBooks.add(book);
    }

    public void checkinBook(Book book) {
        book.checkin();
        checkedOutBooks.remove(book);
    }

    public void displayInfo() {
        System.out.println("Читатель: " + name);
        System.out.println("Книги на руках:");
        for (Book book : checkedOutBooks) {
            book.displayInfo();
        }
    }
}

class Library {
    private java.util.List<Book> books;

    public Library() {
        books = new java.util.ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Доступные книги:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

class Car {
    private String licensePlate;
    private String model;
    private boolean isRented;

    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("Автомобиль \"" + model + "\" арендован.");
        } else {
            System.out.println("Автомобиль \"" + model + "\" уже арендован.");
        }
    }

    public void returnCar() {
        if (isRented) {
            isRented = false;
            System.out.println("Автомобиль \"" + model + "\" возвращен.");
        } else {
            System.out.println("Автомобиль \"" + model + "\" уже в автопарке.");
        }
    }

    public void displayInfo() {
        System.out.println("Модель: " + model);
        System.out.println("Номерной знак: " + licensePlate);
        System.out.println("Доступен: " + (isRented ? "Нет" : "Да"));
    }
}

class Driver {
    private String name;
    private Car rentedCar;

    public Driver(String name) {
        this.name = name;
        this.rentedCar = null;
    }

    public void rentCar(Car car) {
        car.rent();
        rentedCar = car;
    }

    public void returnCar() {
        if (rentedCar != null) {
            rentedCar.returnCar();
            rentedCar = null;
        } else {
            System.out.println("У вас нет арендованного автомобиля.");
        }
    }

    public void displayInfo() {
        System.out.println("Водитель: " + name);
        if (rentedCar != null) {
            rentedCar.displayInfo();
        } else {
            System.out.println("Нет арендованного автомобиля.");
        }
    }
}

class CarPark {
    private java.util.List<Car> cars;

    public CarPark() {
        cars = new java.util.ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void displayAvailableCars() {
        System.out.println("Доступные автомобили:");
        for (Car car : cars) {
            car.displayInfo();
        }
    }
}
