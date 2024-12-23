import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Основное меню
        do {
            System.out.println("Меню:");
            System.out.println("1. Задание 1: Создание класса Книга");
            System.out.println("2. Задание 2: Сравнение студентов");
            System.out.println("3. Задание 3: Класс Продукт с методами");
            System.out.println("4. Задание 4: Наследование");
            System.out.println("5. Задание 5: Полиморфизм");
            System.out.println("6. Выход");
            System.out.print("Выберите номер задания: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Задание 1: Создание класса "Книга"
    public static void task1() {
        class Book {
            private String title;
            private String author;
            private double price;

            public Book(String title, String author, double price) {
                this.title = title;
                this.author = author;
                this.price = price;
            }

            public void displayInfo() {
                System.out.println("Название: " + title);
                System.out.println("Автор: " + author);
                System.out.println("Цена: " + price);
                System.out.println();
            }
        }

        Book book1 = new Book("1984", "George Orwell", 15.99);
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", 12.99);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 10.49);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
    }

    // Задание 2: Сравнение студентов
    public static void task2() {
        class Student {
            private String name;
            private int age;
            private String major;

            public Student(String name, int age, String major) {
                this.name = name;
                this.age = age;
                this.major = major;
            }

            public int getAge() {
                return age;
            }

            public void displayInfo() {
                System.out.println("Имя: " + name);
                System.out.println("Возраст: " + age);
                System.out.println("Специальность: " + major);
            }
        }

        Student[] students = {
                new Student("Alice", 22, "Computer Science"),
                new Student("Bob", 24, "Mathematics"),
                new Student("Charlie", 26, "Physics")
        };

        Student oldestStudent = students[0];
        for (Student student : students) {
            if (student.getAge() > oldestStudent.getAge()) {
                oldestStudent = student;
            }
        }

        System.out.println("Самый старший студент:");
        oldestStudent.displayInfo();
    }

    // Задание 3: Класс "Продукт с методами"
    public static void task3() {
        class Product {
            private String name;
            private int quantity;
            private double price;

            public Product(String name, int quantity, double price) {
                this.name = name;
                this.quantity = quantity;
                this.price = price;
            }

            public void changeQuantity(int quantity) {
                this.quantity += quantity;
            }

            public void changePrice(double price) {
                this.price = price;
            }

            public void displayInfo() {
                System.out.println("Продукт: " + name);
                System.out.println("Количество: " + quantity);
                System.out.println("Цена: " + price);
                System.out.println();
            }
        }

        Product product = new Product("Laptop", 50, 999.99);
        product.displayInfo();

        product.changeQuantity(20);
        product.changePrice(899.99);
        product.displayInfo();
    }

    // Задание 4: Наследование
    public static void task4() {
        class ElectronicDevice {
            private String brand;
            private String model;
            private double price;

            public ElectronicDevice(String brand, String model, double price) {
                this.brand = brand;
                this.model = model;
                this.price = price;
            }

            public void displayInfo() {
                System.out.println("Бренд: " + brand);
                System.out.println("Модель: " + model);
                System.out.println("Цена: " + price);
            }
        }

        class Smartphone extends ElectronicDevice {
            private String operatingSystem;

            public Smartphone(String brand, String model, double price, String operatingSystem) {
                super(brand, model, price);
                this.operatingSystem = operatingSystem;
            }

            @Override
            public void displayInfo() {
                super.displayInfo();
                System.out.println("Операционная система: " + operatingSystem);
                System.out.println();
            }
        }

        ElectronicDevice device = new ElectronicDevice("Samsung", "Galaxy S20", 799.99);
        Smartphone smartphone = new Smartphone("Apple", "iPhone 13", 999.99, "iOS");

        device.displayInfo();
        smartphone.displayInfo();
    }

    // Задание 5: Полиморфизм
    public static void task5() {
        class Animal {
            public void makeSound() {
                System.out.println("Животное издает звук");
            }
        }

        class Dog extends Animal {
            @Override
            public void makeSound() {
                System.out.println("Собака лает");
            }
        }

        class Cat extends Animal {
            @Override
            public void makeSound() {
                System.out.println("Кошка мяукает");
            }
        }

        Animal[] animals = { new Dog(), new Cat() };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
