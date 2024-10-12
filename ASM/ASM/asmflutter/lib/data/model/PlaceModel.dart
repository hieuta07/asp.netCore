class PlaceModel {
  final int id;
  final String name;
  final String image;
  final double star;

  PlaceModel({
    required this.id,
    required this.name,
    required this.image,
    required this.star,
  });

  factory PlaceModel.fromJson(Map<String, dynamic> json) {
    return PlaceModel(
      id: json['id'] ?? 0,
      name: json['name'] ?? '',
      image: json['image'] ?? '',
      star: json['star']?.toDouble() ?? 0.0,
    );
  }
}