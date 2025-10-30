package library;

import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "[" + id + "] " + title + " - " + author;
    }
}


class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private int nextId = 1; // автоинкремент ID


    public Book addBook(String title, String author) {
        Book b = new Book(nextId, title, author);
        books.put(nextId, b);
        nextId++;
        return b;
    }


    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }


    public Book getBookById(int id) {
        return books.get(id);
    }


    public boolean deleteBook(int id) {
        return books.remove(id) != null;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n МЕНЮ:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Показать все книги");
            System.out.println("3. Найти книгу по id");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Выйти");
            System.out.print("Выберите пункт: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    Book b = library.addBook(title, author);
                    System.out.println("Добавлена книга: " + b);
                }
                case 2 -> {
                    System.out.println("Список всех книг:");
                    List<Book> books = library.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("Пока книг нет.");
                    } else {
                        for (Book b : books) System.out.println(b);
                    }
                }
                case 3 -> {
                    System.out.print("Введите id книги: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Book b = library.getBookById(id);
                    if (b != null) {
                        System.out.println("Найдена: " + b);
                    } else {
                        System.out.println("Книга не найдена");
                    }
                }
                case 4 -> {
                    System.out.print("Введите id книги для удаления: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (library.deleteBook(id)) {
                        System.out.println("Книга удалена");
                    } else {
                        System.out.println("Книга с таким id не найдена");
                    }
                }
                case 5 -> {
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Нет такого пункта!");
            }
        }
    }
}