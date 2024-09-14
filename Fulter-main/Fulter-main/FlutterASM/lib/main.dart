import 'dart:io';


void main() {
  MusicApp app = MusicApp();
  app.runApp();
}


class Song {
  String title;
  String artist;
  String genre;
  int year;

  // Constructor để khởi tạo các thuộc tính
  Song(this.title, this.artist, this.genre, this.year);

  // Getter và Setter cho các thuộc tính
  String get getTitle => title;
  void set setTitle(String title) => this.title = title;

  String get getArtist => artist;
  void set setArtist(String artist) => this.artist = artist;

  String get getGenre => genre;
  void set setGenre(String genre) => this.genre = genre;

  int get getYear => year;
  void set setYear(int year) => this.year = year;

  // Phương thức để hiển thị thông tin bài hát
  void displaySongDetails() {
    print('Title: $title, Artist: $artist, Genre: $genre, Year: $year');
  }
}


class MusicApp {
  List<Song> songs = [];

  void createSong() {
    print('Nhập tên bài hát:');
    String title = stdin.readLineSync()!;
    print('Nhập nghệ sĩ:');
    String artist = stdin.readLineSync()!;
    print('Nhập thể loại:');
    String genre = stdin.readLineSync()!;
    print('Nhập năm phát hành:');
    int year = int.parse(stdin.readLineSync()!);

    Song newSong = Song(title, artist, genre, year);
    songs.add(newSong);
    print('Bài hát đã được thêm thành công.');
  }

  void readSongs() {
    if (songs.isEmpty) {
      print('Không có bài hát nào trong danh sách.');
    } else {
      print('Danh sách bài hát yêu thích:');
      for (var song in songs) {
        song.displaySongDetails();
      }
    }
  }

 void updateSong() {
  print('Nhập tên bài hát bạn muốn cập nhật:');
  String title = stdin.readLineSync()!;
  
  Song? songToUpdate = songs.firstWhere((song) => song.title == title);

  if (songToUpdate != null) {
    print('Nhập thông tin mới cho bài hát:');
    print('Nhập nghệ sĩ mới:');
    songToUpdate.artist = stdin.readLineSync()!;
    print('Nhập thể loại mới:');
    songToUpdate.genre = stdin.readLineSync()!;
    print('Nhập năm phát hành mới:');
    songToUpdate.year = int.parse(stdin.readLineSync()!);
    print('Bài hát đã được cập nhật.');
  } else {
    print('Bài hát không tồn tại.');
  }
}


  void deleteSong() {
    print('Nhập tên bài hát bạn muốn xóa:');
    String title = stdin.readLineSync()!;
    songs.removeWhere((song) => song.title == title);
    print('Bài hát đã được xóa.');
  }

  // Hiển thị menu
  void showMenu() {
    print('--- Menu Quản Lý Bài Hát ---');
    print('1. Thêm bài hát');
    print('2. Hiển thị danh sách bài hát');
    print('3. Cập nhật bài hát');
    print('4. Xóa bài hát');
    print('5. Thoát');
  }

  // Chạy ứng dụng
  void runApp() {
    bool isRunning = true;
    while (isRunning) {
      showMenu();
      print('Chọn một tùy chọn:');
      int choice = int.parse(stdin.readLineSync()!);

      switch (choice) {
        case 1:
          createSong();
          break;
        case 2:
          readSongs();
          break;
        case 3:
          updateSong();
          break;
        case 4:
          deleteSong();
          break;
        case 5:
          isRunning = false;
          print('Thoát ứng dụng.');
          break;
        default:
          print('Tùy chọn không hợp lệ.');
      }
    }
  }
}
