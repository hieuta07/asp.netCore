import 'dart:io';

class Contact {
  String name;
  String phoneNumber;

  Contact(this.name, this.phoneNumber);
}

class AddressBook {
  List<Contact> contacts = [];

  void addContact(Contact contact) {
    contacts.add(contact);
  }

  void removeContact(String name) {
    contacts.removeWhere((contact) => contact.name == name);
  }

  void displayContacts() {
    if (contacts.isEmpty) {
      print("Danh bạ trống.");
    } else {
      print("Danh bạ:");
      for (var contact in contacts) {
        print("Tên: ${contact.name}, Số điện thoại: ${contact.phoneNumber}");
      }
    }
  }
}

void main() {
  var addressBook = AddressBook();

  while (true) {
    print("1. Thêm liên hệ");
    print("2. Xóa liên hệ");
    print("3. Hiển thị danh bạ");
    print("4. Thoát");

    var readLineSync = stdin.readLineSync();
    var choice = int.parse(readLineSync!);

    switch (choice) {
      case 1:
        print("Nhập tên liên hệ:");
        var name = stdin.readLineSync();
        print("Nhập số điện thoại:");
        var phoneNumber = stdin.readLineSync();
        var contact = Contact(name!, phoneNumber!);
        addressBook.addContact(contact);
        print("Liên hệ đã được thêm.");
        break;

      case 2:
        print("Nhập tên liên hệ để xóa:");
        var name = stdin.readLineSync();
        addressBook.removeContact(name!);
        print("Liên hệ đã được xóa.");
        break;

      case 3:
        addressBook.displayContacts();
        break;

      case 4:
        print("Kết thúc chương trình.");
        return;

      default:
        print("Lựa chọn không hợp lệ.");
    }
  }
}
