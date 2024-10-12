
import 'package:flutter/material.dart';

class CustomBottomAppBar extends StatefulWidget {
  CustomBottomAppBar({this.onChanged});

  final Function(BottomBarEnum)? onChanged;

  @override
  _CustomBottomAppBarState createState() => _CustomBottomAppBarState();
}

class _CustomBottomAppBarState extends State<CustomBottomAppBar> {
  BottomBarEnum selectedMenu = BottomBarEnum.Home;

  @override
  Widget build(BuildContext context) {
    return BottomAppBar(
      shape: const CircularNotchedRectangle(),
      child: SizedBox(
        height: kBottomNavigationBarHeight + MediaQuery.of(context).viewInsets.bottom,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: List.generate(
            bottomMenuList.length,
                (index) {
              final BottomMenuModel menuItem = bottomMenuList[index];
              final bool isSelected = selectedMenu == menuItem.type;
              return InkWell(
                onTap: () {
                  setState(() {
                    selectedMenu = menuItem.type;
                  });
                  widget.onChanged?.call(menuItem.type);
                },
                child: Container(
                  padding: EdgeInsets.symmetric(vertical: 10.0, horizontal: 15.0),
                  decoration: BoxDecoration(
                    color: isSelected ? Theme.of(context).colorScheme.primary : null,
                    borderRadius: BorderRadius.circular(20.0),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Opacity(
                        opacity: isSelected ? 1.0 : 0.6,
                        child: Icon(
                          menuItem.icon,
                          color: isSelected ? Colors.white : Colors.black,
                        ),
                      ),
                      if (isSelected)
                        Padding(
                          padding: const EdgeInsets.only(left: 12.0),
                          child: Text(
                            menuItem.title ?? "",
                            style: TextStyle(
                              color: isSelected ? Colors.white : Colors.black,
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                    ],
                  ),
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}

enum BottomBarEnum {
  Home,
  Search,
  Notification,
  Profile,
}

class BottomMenuModel {
  BottomMenuModel({
    required this.icon,
    required this.title,
    required this.type,
  });

  IconData icon;
  String? title;
  BottomBarEnum type;
}

final List<BottomMenuModel> bottomMenuList = [
  BottomMenuModel(
    icon: Icons.home,
    title: "Home",
    type: BottomBarEnum.Home,
  ),
  BottomMenuModel(
    icon: Icons.video_library,
    title: "Search",
    type: BottomBarEnum.Search,
  ),
  BottomMenuModel(
    icon: Icons.home_repair_service_sharp,
    title: "Notification",
    type: BottomBarEnum.Notification,
  ),
  BottomMenuModel(
    icon: Icons.person,
    title: "Profile",
    type: BottomBarEnum.Profile,
  )
];